package blockque;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingArrayQueueTest {
	 
	
	public static void main(String[] args) {
		  BlockingQueue<String> queue=new ArrayBlockingQueue<String>(3);
		for(  int i=0;i<2;i++){
			Runnable runnable=new Runnable(){
				@Override
				public void run() {
					try {
						while(true){
						Thread.sleep((long) Math.random()*1000 );
						System.out.println(Thread.currentThread().getName()+"准备放数据");
						queue.put(Thread.currentThread().getName()+"-->");
						System.out.println(Thread.currentThread().getName()+"当前队列里面有"+queue.size());
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			};
			new Thread(runnable).start();
			
		}
	
		Runnable r2=new Runnable(){

			@Override
			public void run() {
				try {
					while(true){
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName()+"准备取走数据");
					 String take= queue.take();
					 System.out.println(Thread.currentThread().getName()+"取走了"+take+"当前队列里面有"+queue.size());
					}
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		};
		new Thread(r2,"<<TakeThread>>").start();
		
		
	}
	
	

}
