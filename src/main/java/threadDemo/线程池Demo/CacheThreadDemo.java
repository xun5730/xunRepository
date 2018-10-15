package threadDemo.线程池Demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newCachedThreadPool 的例子
 * @author xun
 *
 */
public class CacheThreadDemo {
	
	
	
	public static void main(String[] args) {
		ExecutorService es=  Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			final int  index=1;
			try {
				Thread.sleep(index*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			es.execute(new Runnable(){

				@Override
				public void run() {

					System.out.println(index+"--------------"+ Thread.currentThread().getName());
				}
				
			});
			
		}
		
		
		
		
		
	}

}
