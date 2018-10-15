package threadDemo.线程池Demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorPoolDemo {
	
	
	public static void main(String[] args) {
		  
		ThreadPoolExecutor executorPool=
//	new ThreadPoolExecutor(5, 5, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
		new ThreadPoolExecutor(10, 10,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(20));
		
		
		for(int i=0;i<30;i++){
			
			MyTaskThreadPoolDemo myTask=new MyTaskThreadPoolDemo(i,"taskName"+i);
			
			executorPool.execute(myTask);
//			System.out.println("线程池中线程的数目"+executorPool.getPoolSize());
//			System.out.println("队列等待执行的任务数目"+executorPool.getQueue().size());
//			System.out.println("已经执行的任务数目"+executorPool.getCompletedTaskCount());
			
		}
		executorPool.shutdown();
		
		
	}
	
	
	

}
