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
				//获取数据
				PCData data=   this.queue.take();
				//进行数据处理，休眠0-1000模拟 消耗
				System.out.println("当前消费线程："+Thread.currentThread().getName()+"消费成功了，消费数据为ID为"+data.getId());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
}
