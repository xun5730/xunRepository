package threadDemo.master_work模式;

import java.util.Random;

/**
 * 
 * @author xun
 * 
 * Master-Worker模式是常用的并行模式之一，它的核心思想是：
 * 系统由两类进程协同工作，即Master进程和Worker进程，
 * Master负责接收和分配任务，Wroker负责处理子任务。
 * 当各个Worker进程将子任务处理完成后，将结果返回给Master进程，由Master进程进行汇总
 * ，从而得到最终的结果，其具体处理过程如下图所示。
 *
 */
public class QiDongMasterWoker {
	
	public static void main(String[] args) {
		
		Master master=new Master(new Worker(),20);
		Random r=new Random();
		for(int i=0;i<1000;i++){
			Task t=new Task();
			t.setId(i);
			t.setPrice(r.nextInt(1000));
			master.submit(t);
		}
		
		master.execute();
		long start =System.currentTimeMillis();
		while(true){
			if(master.isComplete()){
				long end=System.currentTimeMillis()-start;
				int priceResult=master.getResult();
				System.out.println("最终结果："+priceResult+",执行时间 : "+end);
				break;
			}
			
		}
		
		
		
		
		
		/*long start =System.currentTimeMillis();
		Random r=new Random();
		Integer resultInteger=0;
		for(int i=0;i<999999999;i++){
			resultInteger+=r.nextInt(1000);
		}
		long end=System.currentTimeMillis()-start;
		System.out.println("最终结果："+resultInteger+",执行时间 : "+end);
		*/
		
	}
	
	
	

}
