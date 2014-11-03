package com.somnus.transaction.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

public interface ExportBigData {
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
            final String sql, final Object... sqlParams);
    
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
            String sql, Object... sqlParams);
    
    
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
            final Object... sqlParams);
    
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
            Object... sqlParams);
    
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
            final OutputStream os, final String sql, final Object... sqlParams);
    
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
            final Object... sqlParams);
}
