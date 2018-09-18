package socketDemo.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	final static int PROT=8765;
	
	public static void main(String[] args) {
		
		ServerSocket server=null;
		try{
		server=new ServerSocket(PROT);
		System.out.println("server start");
		
		while(true){
			//��������
			Socket socket=  server.accept();
			//�½�һ���߳�ִ�пͻ��˵�����
			new Thread( new ServerHandler(socket) ).start();;
		}
		
		
		
		}catch(Exception e){
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
