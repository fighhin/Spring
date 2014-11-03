package com.somnus.transaction.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

@Component("bigDataToExcelImpl")
public class BigDataToExcelImpl extends AbstractExportBigData implements
		ExportBigData {

	StringBuffer headStr = new StringBuffer(
            "<html xmlns:x=\"urn:schemas-microsoft-com:office:excel\">")  
            .append("<head>")  
            .append( "<meta http-equiv=\"content-type\" content=\"application/ms-excel; charset=UTF-8\"/>")  
            .append("<!--[if gte mso 9]><xml>").append("<x:ExcelWorkbook>")  
            .append("<x:ExcelWorksheets>").append("<x:ExcelWorksheet>")
            .append("<x:Name></x:Name>").append("<x:WorksheetOptions>")
            .append("<x:Print>").append("<x:ValidPrinterInfo />")
            .append("</x:Print>").append("</x:WorksheetOptions>")
            .append("</x:ExcelWorksheet>").append("</x:ExcelWorksheets>")  
            .append("</x:ExcelWorkbook>").append("</xml><![endif]-->")
            .append("</head>").append("<body>").append("<table>");  
  
    StringBuffer footStr = new StringBuffer("</table></body></html>");  
  
  
    /** 
     * 文件开头的写入 
     *  
     * @param fos 
     * @throws IOException 
     */  
    protected void writeHeaderToOutputStream(FileOutputStream fos)
            throws IOException {
    	System.out.println(headStr.toString());
        writeToOutputStream(headStr.toString(), fos);
    }  
  
    /** 
     * 文件结尾的写入 
     *  
     * @param fos 
     */  
    protected void writeFooterToOutputStream(FileOutputStream fos)  
            throws IOException {
        writeToOutputStream(footStr.toString(), fos);
    }  
  
    /** 
     * 一行数据的写入 
     *  
     * @param rs 
     * @param fos 
     * @throws SQLException 
     * @throws IOException 
     */  
    protected void writeOneRowToOutputStream(ResultSet rs, FileOutputStream fos)
            throws SQLException, IOException {
        // 获取metaData;  
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        writeToOutputStream("<tr>", fos);
        for (int i = 1; i <= columnCount; i++) {
            Object obj = JdbcUtils.getResultSetValue(rs, i);
            writeToOutputStream("<td>"  + HtmlUtils.htmlEscape(obj == null ? "" : obj.toString()) + "</td>", fos); 
            System.out.println("<td>"  + HtmlUtils.htmlEscape(obj == null ? "" : obj.toString()) + "</td>");
        }
        writeToOutputStream("</tr>", fos);
    }  
  
    protected void fileOutputStreamStatus(List<FileOutputStream> foList)
            throws IOException {
        System.out.println("共有文件输出流：" + foList.size());
        for (FileOutputStream fo : foList) {
            System.out.println("文件输出流：" + (fo == null ? "已清空" : fo.toString() + " : " + (fo.getFD().valid())));
        }  
    }  
  
    @Override  
    protected void writeTitleToOutputStream(Collection<String> titles,  
            FileOutputStream fos) throws IOException {
        if (titles != null && titles.size() > 0) {
            writeToOutputStream("<tr>", fos);
            for (String title : titles) {
                writeToOutputStream("<td>" + HtmlUtils.htmlEscape(title == null ? "" : title) + "</td>", fos);
            }
            writeToOutputStream("</tr>", fos);
        }
    }

}
