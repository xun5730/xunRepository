package automicR;

import java.util.concurrent.atomic.AtomicReference;

public class AutomicReferenceTest {
	private  static AtomicReference<String> atomicStr=new AtomicReference<String>("abc");
	
	
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++){
			
//		   final int num=i;
		   new Thread(){
			   public void run() {
				   try {
					Thread.sleep(Math.abs(  (int)    (Math.random()*100)  ));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   
				   if(atomicStr.compareAndSet("abc", "def")){
					   System.out.println("thread" +Thread.currentThread().getName()+"succes" );
				   }else{
					   System.out.println("thread" +Thread.currentThread().getName()+"fail" );
				   }
				   
				   
				   
			   }
			   
		   }.start();
		}
		
		
		
		
		
		
		
		
	}
	
	

}
