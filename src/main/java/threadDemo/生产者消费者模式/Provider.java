package threadDemo.生产者消费者模式;


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Provider implements Runnable {

	
	
	//共享缓存区
	private BlockingQueue<PCData> queue;
	
	private volatile boolean isRuning =true;
	//id生产器
	private static AtomicInteger count=new AtomicInteger();
	//随机
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
				PCData data=new PCData( Integer.toString(id),"数据"+id  );
				System.out.println("当前线程："+Thread.currentThread().getName()+",获取了数据，Id为"+id);
				if(!this.queue.offer(data,2,TimeUnit.SECONDS)){
					System.out.println("提交缓冲区数据失败。。。。。");
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
