package threadDemo.生产者消费者模式;


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Provider implements Runnable {

	
	
	//��������
	private BlockingQueue<PCData> queue;
	
	private volatile boolean isRuning =true;
	//id������
	private static AtomicInteger count=new AtomicInteger();
	//���
	private static Random r=new Random();
	
	public Provider( BlockingQueue queue ){
		this.queue=queue;
	}
	
	
	public static AtomicInteger getCount() {
		return count;
	}





	@Override
	public void run() {
		while(isRuning){
		
			try {
				Thread.sleep(r.nextInt(1000));
			 	int id= count.addAndGet(2);
				PCData data=new PCData( Integer.toString(id),"����"+id  );
				System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+",��ȡ�����ݣ�IdΪ"+id);
				if(!this.queue.offer(data,2,TimeUnit.SECONDS)){
					System.out.println("�ύ����������ʧ�ܡ���������");
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	public void stop(){
		this.isRuning=false;
	}

}
