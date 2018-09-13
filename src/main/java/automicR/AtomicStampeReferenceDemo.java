package automicR;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampeReferenceDemo {
	private static AtomicStampedReference<Integer> money=new AtomicStampedReference<Integer>(19, 0);
	
	public static void main(String[] args) {
		
		for(int i=0;i<3;i++){
			final int timestamp=money.getStamp();
			new Thread(){
				@Override
				public void run() {
					while(true){
					while(true){
						Integer m=  money.getReference();
						if(m<20){
							if(money.compareAndSet(m, m+20, timestamp, timestamp+1));
							System.out.println("���С��2-Ԫ����ֵ�ɹ�  "+money.getReference()+money.getStamp());
							break;
						}else{
							break;
						}
						
					}
					}
					
				}
				
			}.start();
		}
		new Thread(){
			@Override
			public void run() {
				for(int i=0;i<100;i++){
					while(true){
					
					int timestamp=  money.getStamp();
					Integer m=  money.getReference();
					if(m>10){
						System.out.println("����10Ԫ");
						if(money.compareAndSet(m, m-10, timestamp, timestamp+1)){
							System.out.println("success����10�����"+money.getReference()+"--"+money.getStamp());
						}
					}else{
			           System.out.println("û���㹻�Ľ��");
			           break;
					}
					
					
				}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				
			}
			
		}.start();
		
		
		
		
	}
	
	
	

}
