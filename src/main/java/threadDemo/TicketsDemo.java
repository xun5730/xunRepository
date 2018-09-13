package threadDemo;

import java.util.Vector;

/**
 * 多线程使用vector
 * 
 * @author 刘源
 *
 */
public class TicketsDemo {

	public static void main(String[] args) {
		
		final Vector<String> tickets=new Vector<String>();
		
		for(int i=1;i<=100;i++){
			tickets.add("火车票"+i);
			
		}
		for(int i=0;i<10;i++){
			new Thread(new Runnable(){

				@Override
				public void run() {
					
					while(true){
					if(tickets.isEmpty()){
						break;
					}
					System.out.println(Thread.currentThread().getName()+" --> "+  tickets.remove(0));
					}
				}
				
			}).start();;
			
			
			
		}
		
		
	}

}
