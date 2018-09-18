package socketDemo.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler implements Runnable {

	private Socket socket;
	
	public ServerHandler(Socket socket ){
		this.socket=socket;
	}
	
	
	
	@Override
	public void run() {
		
		BufferedReader in =null;
		PrintWriter out =null;
		try{
		  in =new BufferedReader(new InputStreamReader(this.socket.getInputStream()) );
		  out=new PrintWriter (this.socket.getOutputStream(),true);
		  String body=null;
		  while(true){
			  body=in.readLine();
			  if(body==null){
				  System.out.println("handler");
				  break;
			  }else{
				  System.out.println("server:"+body);
				  out.println(" 服务器响应client数据 ");
			  }
		  }
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
