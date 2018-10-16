package socketDemo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;


public class Server3 implements Runnable {

	//1��·���������������е�ͨ����
	private Selector selector;
	//2 ����������
	private ByteBuffer readBuf=ByteBuffer.allocate(1024);
	//3 ���ؿͻ��˶�� buff  ����û��ʵ��
//	private ByteBuffer writeBuf=ByteBuffer.allocate(1024);
	
	public Server3(int port){
		
		try {
			//1 ��·������
			this.selector = Selector.open();
			//2 �򿪷�����ͨ��
			ServerSocketChannel ssc = ServerSocketChannel.open();
			//3 ���÷�����ͨ��Ϊ������ģʽ
			ssc.configureBlocking(false);
			//4 �󶨵�ַ
			ssc.bind(new InetSocketAddress(port));
			//5 �ѷ�����ͨ��ע�ᵽ��·�������ϣ����Ҽ��������¼�
			ssc.register(this.selector, SelectionKey.OP_ACCEPT);
			
			System.out.println("Server start, port :" + port);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void run() {
		while(true){
			
		
		try {
			//1 ����Ҫ�ö�·��������ʼ����
			this.selector.select();
			//2 ���ض�·�������Ѿ�ѡ��Ľ����
			Iterator<SelectionKey> keys=   this.selector.selectedKeys().iterator();
			//3 ���б���
			while(keys.hasNext()){
				//4 ��ȡһ��ѡ���Ԫ��
				SelectionKey key=  keys.next();
				//5 ֱ�Ӵ��������Ƴ��Ϳ�����
				keys.remove();
				//6 �������Ч��
				if(key.isValid()){
					//7 ���Ϊ����״̬
					if(key.isAcceptable()){
						this.accept(key);
					}
					//���Ϊ�ɶ�״̬
					if(key.isReadable()){
						this.read(key);
					}
					//9 д����
					if(key.isWritable()){
						//this.write(key); //ssc
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
	}
	
	private void read(SelectionKey key) {
		try{
			//1 ��ջ������ɵ�����
			this.readBuf.clear();
			//2 ��ȡ֮ǰע���socketͨ������
			SocketChannel sc=  (SocketChannel) key.channel();
			//3 ��ȡ����
			int count= sc.read(this.readBuf);
			//4 ���û������
			if(count==-1){
				key.channel().close();
				key.cancel();
				return ;
			}
			
			//5 ����������ж�ȡ ��ȡ֮ǰ��Ҫ���и�λ����(��position ��limit���и�λ)
			this.readBuf.flip();
			//6 ���ݻ����������ݳ��ȴ�����Ӧ��С��byte���飬���ջ�����������
			byte[] bytes=new byte[this.readBuf.remaining()];
			//7 ���ջ���������
			this.readBuf.get(bytes);
			//8 ��ӡ���
			String body=new String(bytes).trim();
			System.out.println("server"+body);
		}catch(Exception e){
			e.printStackTrace();
		}
	}




	private void accept(SelectionKey key){
		try{
		//1 ��ȡ����ͨ��
		ServerSocketChannel ssc=	(ServerSocketChannel) key.channel();
		//2 ִ����������
		SocketChannel sc=  ssc.accept();
		//3 ��������ģʽ
		sc.configureBlocking(false);
		//4 ע�ᵽ��·�������ϣ������ö�ȡ��ʶ
		sc.register(this.selector, SelectionKey.OP_READ);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		new Thread(new Server3(8765)).start();;
		
	}
	
	

}
