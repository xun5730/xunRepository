package threadDemo.生产者消费者模式;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class PCMain {
	public static void main(String[] args) {
		
		BlockingQueue<PCData> queue=new LinkedBlockingQueue<PCData>(10);
		
		//������
		Provider p1=new Provider(queue);
		
		Provider p2=new Provider(queue);
		
		Provider p3=new Provider(queue);
		
		//������
		Consumer c1=new  Consumer(queue);
		Consumer c2=new Consumer(queue);
		Consumer c3=new Consumer(queue);
		
		ExecutorService cachePool=Executors.newCachedThreadPool();
		
		cachePool.execute(p1);
		cachePool.execute(p2);
		cachePool.execute(p3);
		
		cachePool.execute(c1);
		cachePool.execute(c2);
		cachePool.execute(c3);
		
	/*	try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		cachePool.shutdown();
		while(!cachePool.isShutdown()){
			System.out.println("��ǰ�̳߳�û�йر�");
		}
		System.out.println("�ر���"+cachePool.isShutdown());
		while(! (Provider.getCount().get()>10)){
//			System.out.println(Provider.getCount().get()+"---************--->>");
			
		}
		p1.stop();
		p2.stop();
		p3.stop();
		
		System.out.println(Provider.getCount().get()+"------>>");
		
		
	}

}
