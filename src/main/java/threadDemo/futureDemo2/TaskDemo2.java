package threadDemo.futureDemo2;

import java.util.concurrent.Callable;

public class TaskDemo2 implements Callable<Integer> {

	private Integer number;
	
    public TaskDemo2(Integer number){
    	this.number=number;
    }




	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName()+ "线程进行计算");
		Thread.sleep(3000);
		int sum=0;
		for(int i=0;i<this.number;i++){
			sum+=i;
		}
		return sum;
	}
	
	
	

}
