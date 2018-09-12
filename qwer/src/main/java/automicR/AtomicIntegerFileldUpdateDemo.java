package automicR;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFileldUpdateDemo {
	
	 static class Aifd{
		int id;
		volatile int score;
		
	}
	private  static AtomicIntegerFieldUpdater<Aifd> aifd=AtomicIntegerFieldUpdater.newUpdater(Aifd.class, "score");
	
	public static AtomicInteger sAtomic=new AtomicInteger(0);
	public static void main(String[] args) {
		final Aifd a=new Aifd();
		Thread[] t=new Thread[10000];
		
		for(int i=0;i<1000;i++){
			t[i]=new Thread(){
				
				@Override
				public void run() {
			
					if(Math.random()>0.4){
						
						aifd.incrementAndGet(a);
						sAtomic.incrementAndGet();
					}
					
				}
				
			};
			t[i].start();
		}
		for(int i=0;i<1000;i++){
			try {
				t[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Aifd   "+a.score);
		System.out.println("Atomic   "+sAtomic);
		
		
		
	}
	
	
	

}
