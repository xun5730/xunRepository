package socketDemo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server3 implements Runnable {

	//1多路复用器（管理所有的通道）
	private Selector selector;
	//2 建立缓冲区
	private ByteBuffer readBuf=ByteBuffer.allocate(1024);
	//3
	private ByteBuffer writeBuf=ByteBuffer.allocate(1024);
	
	public Server3(int port){
		
		try {
			//1打开路服用器
			this.selector=Selector.open();
			//2打开 服务器通道
			ServerSocketChannel ssc=ServerSocketChannel.open();
			//3设置服务器通道为非阻塞模式
			ssc.configureBlocking(false);
			//4绑定地址
			ssc.bind(new InetSocketAddress(port));
			//5把服务器通过注册到多路复用器上，并且监听阻塞事件
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
		    	//1获取服务通道
		 		ServerSocketChannel ssc=(ServerSocketChannel) key.channel();
		 		//2执行阻塞方法
				SocketChannel sc=  ssc.accept();
				//3设置阻塞的模式
				sc.configureBlocking(false);
				//4注册到多路复用器上，并设置读取标志
				sc.register(this.selector, SelectionKey.OP_READ);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	

}
