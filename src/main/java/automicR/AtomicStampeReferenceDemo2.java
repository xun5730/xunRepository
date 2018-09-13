package automicR;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampeReferenceDemo2 {
	private static AtomicStampedReference<Integer> money=new AtomicStampedReference<Integer>(19, 0);
	
	public static void main(String[] args) {
		
		
		if(money.compareAndSet(money.getReference(), 50, money.getStamp(), money.getStamp())){
			System.out.println("suucess11");
			System.out.println(money.getReference()+"--"+money.getStamp());
		}else{
			System.out.println("fail");
		}
		
		
		if(money.compareAndSet(money.getReference(), 100, 1, money.getStamp()+1)){
			System.out.println("suucess1122");
			System.out.println(money.getReference()+"--"+money.getStamp());
		}else{
			System.out.println("fail222");
		}
		
		
		
		
	}
	
	
	

}
