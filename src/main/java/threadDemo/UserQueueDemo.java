package threadDemo;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * queue使用Demo
 * 
 * @author xun
 *
 */

public class UserQueueDemo {

	public static void main(String[] args) throws Exception {

		// 高性能无阻塞无界队列：ConcurrentLinkedQueue
		/*
		 * ConcurrentLinkedQueue<String> q=new ConcurrentLinkedQueue<String>();
		 * 
		 * q.offer("a"); q.offer("b"); q.offer("c"); q.offer("d"); q.add("e");
		 * 
		 * System.out.println(q.poll()); System.out.println(q.size());
		 * System.out.println(q.peek()); System.out.println(q.size());
		 */

	/*	ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(5);
		array.put("a");
		array.put("b");
		array.put("c");
		array.put("d");
		array.put("e");
		array.put("f");*/
//		 LinkedBlockingQueue<String> linkedBQ =new LinkedBlockingQueue<String>(10);
/*		 LinkedBlockingDeque<String> linkedDQ=new LinkedBlockingDeque<String>(10);
		 linkedDQ.addFirst("a");
		 linkedDQ.addFirst("b");
		 linkedDQ.addFirst("c");
		 linkedDQ.addFirst("d");
		 
		 linkedDQ.addLast("4");
		 linkedDQ.addLast("3");
		 linkedDQ.addLast("2");
		 linkedDQ.addLast("1");
		 System.out.println("查看头元素"+linkedDQ.peekFirst());
		 System.out.println("获取尾巴的元素"+linkedDQ.pollLast());
		 Object [] objs=   linkedDQ.toArray();
		 for(int i=0;i<objs.length;i++){
			 System.out.println(objs[i]);
			 
		 }*/
		 
		/*PriorityBlockingQueue<PriorityDemo>  priorityQue=new PriorityBlockingQueue<PriorityDemo>();
		  
		  PriorityDemo pd1=new PriorityDemo();
		  pd1.setId(1);
		  pd1.setName("id1");
		
		  PriorityDemo pd3=new PriorityDemo();
		  pd3.setId(3);
		  pd3.setName("id3");
		  
		  PriorityDemo pd2=new PriorityDemo();
		  pd2.setId(2);
		  pd2.setName("id2");
		  priorityQue.add(pd1);
		  priorityQue.add(pd2);
		  priorityQue.add(pd3);
		  System.out.println("容器"+priorityQue);
		  System.out.println(priorityQue.take().getId());
		  System.out.println(priorityQue.take().getId());
		  System.out.println(priorityQue.take().getId());
		  System.out.println("容器"+priorityQue);*/
		
		 
		 
		 
		 

		//这个就是 singleThreadPool   原理
		/*final SynchronousQueue<String> synQueue = new SynchronousQueue<String>();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						System.out.println(synQueue.take());
						
						
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					for (int i = 0; i < 3; i++) {
						synQueue.put(i+"zxcv");
						Thread.currentThread().sleep(3000);
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		t1.start();
		t2.start();*/
		

	}

}
