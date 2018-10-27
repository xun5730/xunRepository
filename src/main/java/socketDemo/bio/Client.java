package socketDemo.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
	final static int PROT=8765;
	final static String ADDRESS = "127.0.0.1";
	
	public static void main(String[] args) {
		
		Socket socket=null;
		BufferedReader in =null;
		PrintWriter out =null;
		try{
			
			socket =new Socket(ADDRESS,PROT);
			in =new BufferedReader(new InputStreamReader(socket.getInputStream()  )  );
			out=new PrintWriter(socket.getOutputStream(),true);
			
			//向服务器发送数据
			 out.println("clinet : hello world server ");
			 String response=in.readLine();
			 System.out.println("clinet 接收到："+response);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			socket = null;
		}
		
		
	}

}
