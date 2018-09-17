package threadDemo.lockDemo;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class UserReentRantReadWriterLock {
	
	private ReentrantReadWriteLock rwLock=new ReentrantReadWriteLock();

	
	private ReadLock readLock = rwLock.readLock();
	private WriteLock writeLock=rwLock.writeLock();
	
	public void read(){
		try{
			readLock.lock();
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"����");
			Thread.sleep(3000);
			System.out.println("��ǰ�߳�"+Thread.currentThread().getName()+"�Ƴ�");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			readLock.unlock();
		}
		
		
	}
	public void write(){
		
		try{
			writeLock.lock();
			System.out.println("��ǰ�߳�"+Thread.currentThread().getName()+"����");
			Thread.sleep(3000);
			System.out.println("��ǰ�߳�"+Thread.currentThread().getName()+"�˳�");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			writeLock.unlock();
		}
		
	}
	
	public static void main(String[] args) {
		final UserReentRantReadWriterLock  urrw=new UserReentRantReadWriterLock();
		Thread t1=new Thread(new Runnable(){

			@Override
			public void run() {

				urrw.read();
			}
			
		},"t1");
		Thread t2=new Thread(new Runnable(){
			
			@Override
			public void run() {
				urrw.read();
			}
			
		},"t2");
		Thread t3=new Thread(new Runnable(){
			
			@Override
			public void run() {
				urrw.write();
			}
			
		},"t3");
		Thread t4=new Thread(new Runnable(){
			
			@Override
			public void run() {
				urrw.write();
			}
			
		},"t4");
		
	/*	
	 * ����������
	 * t1.start();
		t2.start();*/
		
		//дд����
//		t3.start();
//		t4.start();
		//��д����
		t4.start();
		t1.start();
		
		
		
		
	}
	
	
	

}
