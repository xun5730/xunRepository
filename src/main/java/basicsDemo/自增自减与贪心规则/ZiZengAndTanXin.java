package basicsDemo.自增自减与贪心规则;

import java.util.concurrent.atomic.AtomicInteger;

public class ZiZengAndTanXin {
	
	static int a=0;
	static int b=0;
	
	static AtomicInteger atomicInt=new AtomicInteger(0);
	
	public static void main(String[] args) throws InterruptedException {
		
		int aa=5;
		aa=aa++;
		//此时a的值为多少？
		System.out.println(aa);
		for(int i=0;i<10;i++){//创建10个线程
			
			Thread t=new Thread(){

				@Override
				public void run() {
					
					for(int j=0;j<1000;j++){//计算1000次
						a=a+1;
						b++;
						atomicInt.incrementAndGet();//自鞥的原子性方法
					}
					
				}
				
			};
			t.start();
			
		}
		
		//判断当前的活动线程是不是只有main线程，以确保10个计算线程执行完成
		while(Thread.activeCount()>1){
			Thread.sleep(1000);
		}

		System.out.println("a=a+1在多线程下的结果是"+a);
		System.out.println("b++在多线程下的结果是"+b);
		System.out.println("原子操作类atomicInteger在多线程下的结果是"+atomicInt.get());
//		=====================
		
		int aaa=5;
		int bbb=5;
		int ccc=aaa+++bbb;
		System.out.println("aaa的值是"+aaa);
		System.out.println("bbb的值是"+bbb);
		System.out.println("ccc的值是"+ccc);
		
		
	}

}
