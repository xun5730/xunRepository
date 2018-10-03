package threadDemo.生产者消费者模式;


import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer  implements Runnable{

	
	private BlockingQueue<PCData> queue;
	
	public Consumer(BlockingQueue queue){
		this.queue=queue;
	}
	private static Random r=new Random();

	@Override
	public void run() {

		while(true){
			
			try {
				//��ȡ����
				PCData data=   this.queue.take();
				//�������ݴ�������0-1000ģ�� ����
				System.out.println("��ǰ�����̣߳�"+Thread.currentThread().getName()+"���ѳɹ��ˣ���������ΪIDΪ"+data.getId());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block һ����
				e.printStackTrace();
			}
			
		}
	}
	
	
}
