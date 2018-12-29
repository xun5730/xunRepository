package threadDemo.shuangseqiu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.validation.annotation.Validated;

public class SSQMain {
	
//	public static  Map<Integer,Set<Integer>> zjmap=new HashMap<Integer,Set<Integer>>();
	
	public static AtomicInteger count=new AtomicInteger(0);
	public static AtomicInteger lc=new AtomicInteger(0);
	public static Set<Integer> zjhSet=new  TreeSet<Integer>();
	public static Set<Integer> zjlSet=new  HashSet<Integer>();
//	public static    AtomicBoolean flag = new  AtomicBoolean(false);
	public static volatile Boolean flag =new Boolean(false);
	
	public static ShuangSeQiueBean shuangSeQiueBean=new ShuangSeQiueBean();
	
	static{
		 
		 
		  
		  zjhSet.add(11);
		  zjhSet.add(12);
		/*  zjhSet.add(13);
		  zjhSet.add(14);
		  zjhSet.add(15);
		  zjhSet.add(16);*/
		  shuangSeQiueBean.setHongQiuSet(zjhSet);
		  shuangSeQiueBean.setLanQiu(11);
	}
	
	
	
	

	
	
	public static void main(String[] args) {
		
		/*    Map<Integer,Set<Integer>> sqSet=   getSq();
		    
		    Set<Integer> hongseSet=  sqSet.get(1);
		    Set<Integer> lanseSet=  sqSet.get(2);
		    System.out.println("红球"+hongseSet.toString());
		    System.out.println("篮球"+lanseSet.toString());*/
		/* System.out.println(zjhSet); 
		 System.out.println(zjlSet); */
		System.out.println(SSQMain.flag);
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while(!SSQMain.flag){
					int i= SSQMain.lc.incrementAndGet();
					System.out.println(i);
					if(i==20){
						SSQMain.flag=true;
					}
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
/*		try {
			Thread.currentThread().sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SSQMain.flag=true;*/
		
	}

	private static Map<Integer,Set<Integer>> getSq() {

		  Map<Integer,Set<Integer>> map=new HashMap<Integer,Set<Integer>>();
		  Set<Integer> hongseSet=new  TreeSet<Integer>();
		  Set<Integer> lanseSet=new  HashSet<Integer>();
		  Random  r=new  Random();
		  while(true){
			  int i= r.nextInt(33)+1;
			  System.out.println(i);
			  hongseSet.add(i);
			  if(hongseSet.size()==6){
				  break;
			  }
		  }
		  map.put(1, hongseSet);
		  int z= r.nextInt(16)+1;
		  lanseSet.add(z);
		  map.put(2, lanseSet);
		  return map;
	}

}
