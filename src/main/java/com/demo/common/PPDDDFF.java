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
	
	public static void test1(){//����pdf
		  BaseFont bf;
	          Font font = null;
	          try {
	              bf = BaseFont.createFont( "STSong-Light", "UniGB-UCS2-H",
	                      BaseFont.NOT_EMBEDDED);//��������
	              font = new Font(bf,12);//ʹ������
	          } catch (Exception e) {
	              e.printStackTrace();
	         }
	          Document document = new Document();
	          try {
	              PdfWriter.getInstance(document, new FileOutputStream("d:/����1.pdf"));
	              document.open();
	              document.add(new Paragraph("������:1020180807155522002",font));//��������
	              document.add(new Paragraph("�ŵ��ַ����̨�Ƽ�԰  �µ�ʱ�䣺2018-08-07 15��55��22",font));//��������
	  
	              document.add(new Paragraph("�ͻ����ƣ���ѩ��  �Ѹ���200   δ����800 ֧����ʽ���ֽ�",font));//��������
	              
	              float[] widths = {25f,25f,25f,25f,30f,25f,25f };// ���ñ����п������ Ĭ����4��  
	              PdfPTable table = new PdfPTable(widths);// ����һ��pdf���  
	              table.setSpacingBefore(20f);  
	              table.setWidthPercentage(100);// ���ñ����Ϊ100%  
	              
	              PdfPCell cell = null;  
	              cell = new PdfPCell(new Paragraph("��Ʒ����",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	              
	              cell = new PdfPCell(new Paragraph("��Ʒ��ɫ",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	              
	              cell = new PdfPCell(new Paragraph("�׺�",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	              cell = new PdfPCell(new Paragraph("����",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	              cell = new PdfPCell(new Paragraph("���ۣ�Ԫ/�ף�",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	              cell = new PdfPCell(new Paragraph("�ܽ��",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	              cell = new PdfPCell(new Paragraph("��ע",font));//  
	              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	              table.addCell(cell);
	 
	              //���´���������Ǵ���100������,����ÿ��������,������Ϊ ��� ���� �Ա� ��ע
	              for (int i = 1; i <=3; i++) {
	                  //���ñ�ŵ�Ԫ��
	            	  PdfPCell cell11=new PdfPCell(new Paragraph("aa����",font));
	            	  PdfPCell cell22=new PdfPCell(new Paragraph("bbŮ",font));
	            	  PdfPCell cell33=new PdfPCell(new Paragraph("cc������1",font));
	            	  PdfPCell cell44=new PdfPCell(new Paragraph("cc������2",font));
	            	  PdfPCell cell55=new PdfPCell(new Paragraph("cc������3",font));
	            	  PdfPCell cell66=new PdfPCell(new Paragraph("cc������4",font));
	            	  PdfPCell cell77=new PdfPCell(new Paragraph("cc������5",font));
	 
	                  //��Ԫ��ˮƽ���뷽ʽ
	                  cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
	                  //��Ԫ��ֱ���뷽ʽ
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
