package com.demo.common;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PPDDDFF {
	
	public static void test1(){//生成pdf
		  BaseFont bf;
	          Font font = null;
	          try {
	              bf = BaseFont.createFont( "STSong-Light", "UniGB-UCS2-H",
	                      BaseFont.NOT_EMBEDDED);//创建字体
	              font = new Font(bf,12);//使用字体
	          } catch (Exception e) {
	              e.printStackTrace();
	         }
	          Document document = new Document();
	          try {
	              PdfWriter.getInstance(document, new FileOutputStream("d:/测试1.pdf"));
	              document.open();
	              document.add(new Paragraph("订单号:1020180807155522002",font));//引用字体
	              document.add(new Paragraph("门店地址：丰台科技园  下单时间：2018-08-07 15：55：22",font));//引用字体
	  
	              document.add(new Paragraph("客户名称：王雪涛  已付金额：200   未付金额：800 支付方式：现金",font));//引用字体
	              
	              float[] widths = {25f,25f,25f,25f,30f,25f,25f };// 设置表格的列宽和列数 默认是4列  
	              PdfPTable table = new PdfPTable(widths);// 建立一个pdf表格  
	              table.setSpacingBefore(20f);  
	              table.setWidthPercentage(100);// 设置表格宽度为100%  
	              
	              PdfPCell cell = null;  
	              cell = new PdfPCell(new Paragraph("商品名称",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	              
	              cell = new PdfPCell(new Paragraph("商品颜色",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	              
	              cell = new PdfPCell(new Paragraph("缸号",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	              cell = new PdfPCell(new Paragraph("米数",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	              cell = new PdfPCell(new Paragraph("单价（元/米）",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	              cell = new PdfPCell(new Paragraph("总金额",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	              cell = new PdfPCell(new Paragraph("备注",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	 
	              //以下代码的作用是创建100行数据,其中每行有四列,列依次为 编号 姓名 性别 备注
	              for (int i = 1; i <=3; i++) {
	                  //设置编号单元格
	            	  PdfPCell cell11=new PdfPCell(new Paragraph("aa名媛",font));
	            	  PdfPCell cell22=new PdfPCell(new Paragraph("bb女",font));
	            	  PdfPCell cell33=new PdfPCell(new Paragraph("cc花姑娘1",font));
	            	  PdfPCell cell44=new PdfPCell(new Paragraph("cc花姑娘2",font));
	            	  PdfPCell cell55=new PdfPCell(new Paragraph("cc花姑娘3",font));
	            	  PdfPCell cell66=new PdfPCell(new Paragraph("cc花姑娘4",font));
	            	  PdfPCell cell77=new PdfPCell(new Paragraph("cc花姑娘5",font));
	 
	                  //单元格水平对齐方式
	                  cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
	                  //单元格垂直对齐方式
	                  cell11.setVerticalAlignment(Element.ALIGN_CENTER);
	 
	                  cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
	                  cell22.setVerticalAlignment(Element.ALIGN_CENTER);
	 
	                  cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
	                  cell33.setVerticalAlignment(Element.ALIGN_CENTER);
	 
	 
	                  table.addCell(cell11);
	                  table.addCell(cell22);
	                  table.addCell(cell33);
	                  table.addCell(cell44);
	                  table.addCell(cell55);
	                  table.addCell(cell66);
	                  table.addCell(cell77);
	              
	              }
	              document.add(table);  
	              
	              document.close();
	         } catch (Exception e) {
	             System.out.println("file create exception");
	             e.printStackTrace();
	         }
	          
	     }

	  public static void main(String[] args) {
		
		  PPDDDFF.test1();
	}
	
}
