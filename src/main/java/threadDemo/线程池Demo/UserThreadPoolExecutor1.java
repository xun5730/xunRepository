package threadDemo.线程池Demo;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UserThreadPoolExecutor1 {
	public static void main(String[] args) {
		
		ThreadPoolExecutor pool =
				new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2));
//		new ThreadPoolExecutor(6, 6, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
//		new ThreadPoolExecutor(3, 6, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
//		new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(2));
		
		MyTaskThreadPoolDemo t1=new MyTaskThreadPoolDemo(1, "����1");
		MyTaskThreadPoolDemo t2=new MyTaskThreadPoolDemo(2, "����2");
		MyTaskThreadPoolDemo t3=new MyTaskThreadPoolDemo(3, "����3");
		MyTaskThreadPoolDemo t4=new MyTaskThreadPoolDemo(4, "����4");
		MyTaskThreadPoolDemo t5=new MyTaskThreadPoolDemo(5, "����5");
		MyTaskThreadPoolDemo t6=new MyTaskThreadPoolDemo(6, "����6");
		
		
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
//		pool.execute(t6);
		
		
		

		/*pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		System.out.println("---�ȿ�����---");
		System.out.println("�����߳���" + pool.getCorePoolSize());
		System.out.println("�̳߳���" + pool.getPoolSize());
		System.out.println("����������" + pool.getQueue().size());*/
	
/*		try {
			Thread.currentThread().sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
//		pool.execute(t4);
//		pool.execute(t5);
//		pool.execute(t6);
/*		System.out.println("---�ڿ�����---");
		System.out.println("�����߳���" + pool.getCorePoolSize());
		System.out.println("�̳߳���" + pool.getPoolSize());
		System.out.println("����������" + pool.getQueue().size());
		try {
			Thread.currentThread().sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----8��֮��----");
		System.out.println("�����߳���" + pool.getCorePoolSize());
		System.out.println("�̳߳���" + pool.getPoolSize());
		System.out.println("����������" + pool.getQueue().size());*/
	    pool.shutdown();	
		
		
	}

}
