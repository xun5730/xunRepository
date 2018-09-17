package threadDemo.lockDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseCondition {
	private Lock lock=new ReentrantLock();
	private Condition condition =lock.newCondition();
	
	
	public void method1(){
		lock.lock();
		
		System.out.println("��ǰ�߳� �� "+Thread.currentThread().getName()+"����ȴ�״̬");
		try {
			Thread.sleep(3000);
		
		
		System.out.println("��ǰ�߳�"+Thread.currentThread().getName()+"�ͷ���");
		condition.await();
		System.out.println("��ǰ�߳�"+Thread.currentThread().getName()+"����ִ��");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void method2(){
		try{
			lock.lock();
			System.out.println("��ǰ�߳�:"+Thread.currentThread().getName()+"���롣������");
				Thread.sleep(3000);
				System.out.println("��ǰ�߳�"+Thread.currentThread().getName()+"��������");
				condition.signal();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
		
	}
	public static void main(String[] args) {
		final UseCondition uc=new UseCondition();
		Thread t1=new Thread(new Runnable(){

			@Override
			public void run() {
				
				uc.method1();
			}
			
		} ,"tt1");
		Thread t2=new Thread(new Runnable(){

			@Override
			public void run() {

				uc.method2();
			}
			
		},"tt2");
		t1.start();
		
		t2.start();
		
		
		
	}
	
	
	
	

}
