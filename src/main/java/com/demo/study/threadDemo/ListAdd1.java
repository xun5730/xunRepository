package com.demo.study.threadDemo;

import java.util.ArrayList;
import java.util.List;

public class ListAdd1 {
	
	private  volatile static List<String> list=new ArrayList<String>();
	public void add( ){
		list.add("asdf");
	}
	public int listSize(){
		return list.size();
	}
	
	public static void main(String[] args) {
		final	ListAdd1  demo =new ListAdd1();
		Thread t1=new Thread(new Runnable(){
			@Override
			public void run() {

				for(int i=0;i<10;i++){
					demo.add();
					System.out.println("���Ԫ��"+i);
				}
				
				
			}},"t1");
		Thread t2=new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					if(demo.listSize()==5){
						System.out.println("��ֹt2���߳�");
						throw new RuntimeException("��ֹt2���߳�");
					}else{
						System.out.println("��û�е�ʱ����ֹ���߳�");
					}
					
				}
			}
		},"t2");
		
		t2.start();
		t1.start();
		
		
		
		
	}
	

}
