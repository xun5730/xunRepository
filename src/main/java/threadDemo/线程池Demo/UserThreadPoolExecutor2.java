package threadDemo.线程池Demo;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class UserThreadPoolExecutor2 implements Runnable {
	private static AtomicInteger count=new AtomicInteger(0);

	@Override
	public void run() {

		int temp=count.addAndGet(3);
		System.out.println("����"+temp);
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		BlockingQueue<Runnable> queue=
//				new ArrayBlockingQueue<Runnable>(10);
		new LinkedBlockingQueue<Runnable>();
		ExecutorService executor=
	    new ThreadPoolExecutor(5, 10, 120l, TimeUnit.SECONDS, queue);
		for(int i=0;i<200;i++){
			executor.execute(new UserThreadPoolExecutor2());
		}
		try {
			Thread.sleep(1000);
			System.out.println("queue size:" + queue.size());		//10
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	
	

}
