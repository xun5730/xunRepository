package threadDemo.shuangseqiu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSQTask  implements Runnable {

	@Override
	public void run() {

//		Boolean flag= SSQMain.flag;
		while(!SSQMain.flag){
//		for(int z=0;z<10;z++){	
			ShuangSeQiueBean sui=       getSq();
			int i=  SSQMain.count.incrementAndGet();
			ShuangSeQiueBean zj=  SSQMain.shuangSeQiueBean;
			System.out.println("第"+i+"循环" );
			System.out.println(sui.getHongQiuSet().toString() +"----"+sui.getLanQiu()+"-->>>>>"+Thread.currentThread().getName());
			if(zj.equals(sui)){
		    	SSQMain.flag=true;
		    	System.out.println("----第"+SSQMain.count.get()+"循环---------______________________________"
		    			+ "-----------------------------------"
		    		+Thread.currentThread().getName()  + "---------------------------------"
		    			+ "---------------------------------"
		    			+ "_______________________---------------------------------------"+sui.getHongQiuSet().toString() +"----"+sui.getLanQiu());
			}
		}
		
		
		
		
	}
	
	private ShuangSeQiueBean getSq() {

		ShuangSeQiueBean shuangSeQiueBean=new ShuangSeQiueBean();
		  Set<Integer> hongseSet=new  TreeSet<Integer>();
		  while(true){
			  int i= (int) (Math.random() * 33) + 1;
			  hongseSet.add(i);
			  if(hongseSet.size()==2){
				  break;
			  }
		  }
		  int z= (int) (Math.random() * 16) + 1;
		  shuangSeQiueBean.setHongQiuSet(hongseSet);
		  
		  shuangSeQiueBean.setLanQiu(z);
		  return shuangSeQiueBean;
	}
	
	public static void main(String[] args) {
		
	
		
		Thread t1= new Thread( new ThreadSQTask() );
		Thread t2= new Thread( new ThreadSQTask() );
		Thread t3= new Thread( new ThreadSQTask() );
		Thread t4= new Thread( new ThreadSQTask() );
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		
		
	}

}
