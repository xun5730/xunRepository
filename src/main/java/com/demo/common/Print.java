package com.demo.common;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Print {

        public static void printWithDialog(String filePath) {
            try {
                PDDocument document = PDDocument.load(new File(filePath));
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPageable(new PDFPageable(document));
                if (job.printDialog()){
                    job.print();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }

        public static String getFilePath(String fileName){
            File path = new File("D:/zxcv1");
            if (!path.exists() && !path.isDirectory()) {
                path.mkdir();
            }
            String filePath = path + "" + fileName;
            return filePath;
        }

        public static boolean downloadFile(String fileURL,String fileName) {
            try {
                URL url = new URL(fileURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                DataInputStream in = new DataInputStream(connection.getInputStream());
                DataOutputStream out = new DataOutputStream(new FileOutputStream(getFilePath(fileName)));
                byte[] buffer = new byte[4096];
                int count = 0;
                while ((count = in.read(buffer)) > 0) {
                    out.write(buffer, 0, count);
                }
                out.close();
                in.close();
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        public static void main(String[] args) {
        	String fileURL = "http";
            String fileName = ".pdf";
            Print.downloadFile(fileURL,fileName);
            Print.printWithDialog(Print.getFilePath(fileName));
        	
        	
		}

}
