package com.demo.study.threadDemo;

import java.util.ArrayList;
import java.util.List;

public class ListAdd2 {

	private volatile static List<String> list = new ArrayList<String>();

	public void add() {
		list.add("asdf");
	}

	public int listSize() {
		return list.size();
	}

	

	public static void main(String[] args) {
		final ListAdd2 demo = new ListAdd2();
		final Object lock = new Object();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {

					for (int i = 0; i < 10; i++) {
						demo.add();
						System.out.println("���Ԫ��" + i);
						if(list.size()==5){
							lock.notify();
						}
					}
				}

			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {

				synchronized (lock) {


						if (demo.listSize() != 5) {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} 

						throw new RuntimeException("��ֹt2���߳�");
				}
			}
		}, "t2");

		t2.start();
		t1.start();

	}

}
