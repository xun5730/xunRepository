package socketDemo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server3 implements Runnable {

	//1��·���������������е�ͨ����
	private Selector selector;
	//2 ����������
	private ByteBuffer readBuf=ByteBuffer.allocate(1024);
	//3
	private ByteBuffer writeBuf=ByteBuffer.allocate(1024);
	
	public Server3(int port){
		
		try {
			//1��·������
			this.selector=Selector.open();
			//2�� ������ͨ��
			ServerSocketChannel ssc=ServerSocketChannel.open();
			//3���÷�����ͨ��Ϊ������ģʽ
			ssc.configureBlocking(false);
			//4�󶨵�ַ
			ssc.bind(new InetSocketAddress(port));
			//5�ѷ�����ͨ��ע�ᵽ��·�������ϣ����Ҽ��������¼�
			ssc.register(this.selector, SelectionKey.OP_ACCEPT);
			System.out.println("server start ,port:"+port);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@Override
	public void run() {
		
	}
	
	private void accept(SelectionKey key){
		
		     try {
		    	//1��ȡ����ͨ��
		 		ServerSocketChannel ssc=(ServerSocketChannel) key.channel();
		 		//2ִ����������
				SocketChannel sc=  ssc.accept();
				//3����������ģʽ
				sc.configureBlocking(false);
				//4ע�ᵽ��·�������ϣ������ö�ȡ��־
				sc.register(this.selector, SelectionKey.OP_READ);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	

}
