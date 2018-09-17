package threadDemo.lockDemo;

import java.util.concurrent.locks.ReentrantLock;

public class TestHoldCount {
	
	
	private ReentrantLock lock =new ReentrantLock();
	
	public void m1(){
		
		try {
			lock.lock();
			System.out.println("进入m1方法，holdCount数为"+lock.getHoldCount());
			m2();
		}finally{
			
			lock.unlock();
			
		}
		
	}
	
	public void m2(){
		
		try{
		lock.lock();
		System.out.println("进入m2方法，holdCount数为"+lock.getHoldCount());
		}finally{
			lock.unlock();
		}
		
	}
	public static void main(String[] args) {
		
		TestHoldCount thc=new TestHoldCount();
		thc.m1();
	}
	

}
