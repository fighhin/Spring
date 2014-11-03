package com.somnus.transaction.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.annotation.Resource;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public abstract class AbstractExportBigData implements ExportBigData{
	/** 
     * 每个文件的最大行数 超过请求按默认算 
     */  
    public static final int MAXROWS = 50000;  
    /**
     * 临时文件前缀 
     */
    public static final String prefix = "excelTemp"; 
    /**
     * 临时文件后缀 
     */
    public static final String suffix = ".xls"; 
    
    /** 
     * 用于数据查询 
     */  
    private JdbcTemplate jdbcTemplate;  
  
  
    /** 
     * 删除临时文件 
     *  
     * @param fileList 
     */  
    protected void cleanTempFile(List<File> fileList) {
        for (File file : fileList) {
            System.out.println("-----删除文件," + file.getPath());
            file.delete();
        }
    }
  
    /** 
     * 创建临时文件 
     *  
     * @return 
     * @throws IOException 
     */  
    protected File createTempFile() throws IOException {
        return File.createTempFile(prefix, suffix);
    }
  
    /** 
     * 数据输出 
     *  
     * @param data 
     * @param fos 
     * @throws IOException 
     */  
    protected void writeToOutputStream(String data, FileOutputStream fos)
            throws IOException {
        IOUtils.write(data, fos, "UTF-8");
    }
  
    /** 
     * 文件开头的写入 
     *  
     * @param fos 
     * @throws IOException 
     */  
    abstract protected void writeHeaderToOutputStream(FileOutputStream fos)
            throws IOException;
  
    /** 
     * 文件结尾的写入 
     *  
     * @param fos 
     */  
    abstract protected void writeFooterToOutputStream(FileOutputStream fos)
            throws IOException;
  
    /** 
     * 一行数据的写入 
     *  
     * @param rs 
     * @param fos 
     * @throws SQLException 
     * @throws IOException 
     */  
    abstract protected void writeOneRowToOutputStream(ResultSet rs,
            FileOutputStream fos) throws SQLException, IOException;
  
    /** 
     * 写数据标题 
     *  
     * @param titles 
     * @param fos 
     * @throws IOException 
     */  
    abstract protected void writeTitleToOutputStream(Collection<String> titles,
            FileOutputStream fos) throws IOException;
  
  
    /** 
     * 获取单个文件最大行数 
     *  
     * @param maxRow 
     * @return 
     */  
    protected int getMaxRows(int maxRow) {
        return maxRow < MAXROWS ? maxRow : MAXROWS;
    }  
  
  
    /** ①yy
     * 导出xls压缩成zip（无定义最大行）
     *  
     * @param titles 
     *            标题《数组》
     * @param os 
     *            输出流
     * @param sql 
     *            查询sql
     * @param sqlParams
     * 			   查询条件          
     * @throws IOException 
     */  
    public void exportToZip(final String[] titles, final OutputStream os, 
            final String sql, final Object... sqlParams) {
        exportToZip(titles, os, MAXROWS, sql, sqlParams);
    }
    
    /** ②yy
     * 导出xls压缩成zip（有定义最大行）
     *  
     * @param titles 
     *            标题《数组》
     * @param os 
     *            输出流
     * @param maxRow 
     *            每个excel的最大行数 
     * @param sql 
     *            查询sql
     * @param sqlParams
     * 			   查询条件          
     * @throws IOException 
     */  
    public void exportToZip(final String[] titles, OutputStream os, int maxRow,  
            String sql, Object... sqlParams) {
        exportToZip(Arrays.asList(titles), os, maxRow, sql, sqlParams);
    }
    
    
    /** ①xx
     * 导出xls压缩成zip（无定义标题）
     *  
     * @param os 
     *            输出流
     * @param sql 
     *            查询sql
     * @param sqlParams
     * 			   查询条件          
     * @throws IOException 
     */  
    public void exportToZip(final OutputStream os, final String sql,
            final Object... sqlParams) {
        exportToZip(os, MAXROWS, sql, sqlParams);
    }  
    
    /** ②xx
     * 导出xls压缩成zip（无标题）
     *  
     * @param os 
     *            输出流
     * @param maxRow 
     *            每个excel的最大行数 
     * @param sql 
     *            查询sql
     * @param sqlParams
     * 			   查询条件          
     * @throws IOException 
     */  
    public void exportToZip(final OutputStream os, int maxRow, String sql,  
            Object... sqlParams) {
        exportToZip(Collections.EMPTY_LIST, os, maxRow, sql, sqlParams);
    }
    
    /** ①ZZ
     * 导出xls压缩成zip（无定义最大行）
     *  
     * @param titles 
     *            标题《Collection》
     * @param os 
     *            输出流
     * @param sql 
     *            查询sql
     * @param sqlParams
     * 			   查询条件          
     * @throws IOException 
     */  
    public void exportToZip(final Collection<String> titles,
            final OutputStream os, final String sql, final Object... sqlParams) {
        exportToZip(titles, os, MAXROWS, sql, sqlParams);
    }
    
    /** ③
     * 导出xls压缩成zip
     *  
     * @param titles 
     *            标题《Collection》
     * @param os 
     *            输出流
     * @param maxRow 
     *            每个excel的最大行数 
     * @param sql 
     *            查询sql
     * @param sqlParams
     * 			   查询条件          
     * @throws IOException 
     */  
    public void exportToZip(final Collection<String> titles,
            final OutputStream os, final int maxRow, final String sql,
            final Object... sqlParams) {
        // 每个文件最大行数  
        final int max = getMaxRows(maxRow);
        jdbcTemplate.query(sql, sqlParams, new ResultSetExtractor() {
            public Object extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                // 文件收集器
                List<File> fileList = new ArrayList<File>();
                // 行数记录器 
                int i = 0;
                // 临时文件
                File file = null;
                FileOutputStream fos = null;
                try {
                    while (rs.next()) {
                        // 达到最大行数 或者 新建的 创建新文件  
                        if (i == max || i == 0) {
                            // 如果不是新文件 为这个文件写入文件尾  
                            if (file != null) {
                                // 写文件尾  
                                writeFooterToOutputStream(fos);
                                // 关闭流  
                                IOUtils.closeQuietly(fos);
                            }
                            // 创建临时文件  
                            file = createTempFile();
                            // 打开流  
                            fos = FileUtils.openOutputStream(file);
                            // 放进收集器里
                            fileList.add(file);
                            // 写文件头  
                            writeHeaderToOutputStream(fos);
                            // 数据区标题栏  
                            writeTitleToOutputStream(titles, fos);
                            i = 0;
                        }
                        i++;
                        // 写实际一行数据  
                        writeOneRowToOutputStream(rs, fos);
                    }  
  
                    if (file != null) {
                        // 写文件尾  
                        writeFooterToOutputStream(fos);
                        // 关闭流  
                        IOUtils.closeQuietly(fos);
                    }
                    // 打包  
                    doZip(os, fileList);
                } catch (IOException e) {
                    // io异常  
                } finally {
                    IOUtils.closeQuietly(fos);
                    // 清空临时文件  
                    cleanTempFile(fileList);
                    fileList.clear();
                    fileList = null;
                }
                return null;
            }
        });
    }
    
    @Resource(name="jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}  
    /** 
     * 打包 压缩成zip 
     *  
     * @param os 
     *            压缩输出流 
     * @param fileList 
     *            被压缩的文件列表 
     * @throws IOException 
     */  
    protected void doZip(OutputStream os, List<File> fileList)  
            throws IOException {
        if (fileList != null && fileList.size() > 0) {
            byte[] buf = new byte[1024];
            ZipOutputStream out = new ZipOutputStream(os);
            for (File file : fileList) {
                FileInputStream in = new FileInputStream(file);
                out.putNextEntry(new ZipEntry(file.getName()));
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry(); 
                in.close();
            } 
            System.out.println(os == null);
            out.close();
            System.out.println(os == null);
        }
    }
}
