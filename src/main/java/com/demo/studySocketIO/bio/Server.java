package com.demo.studySocketIO.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	   static int PROT=8765;
	
	public static void main(String[] args) {
	
		  ServerSocket server=null;
		  try {
			server=new ServerSocket(PROT);
			System.out.println("server start..");
			//½øÐÐ×èÈû
			 while(true){
			 Socket socket=  server.accept();
			 
			 new Thread(new ServerHandler(socket)).start();;
			 }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(server!=null){
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			server=null;
		}
		  
		
		
	}

}
