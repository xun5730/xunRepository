package basicsDemo.threadLocal例子.demo1;

public class ThreadlocalTest1 {
	
	private static int threadLocal=0;
	
	public static void main(String[] args) {
		
		for(int i=0;i<5;i++){
			final  int temp =i;
			new Thread(new Runnable(){

				@Override
				public void run() {
					 
					threadLocal=temp;
					System.out.println(Thread.currentThread().getName()+"has put data"+temp);
					MyThreadScopeData1.getThreadInstance().setName("name"+temp);
					MyThreadScopeData1.getThreadInstance().setNum(temp);
					new A().get();
					new B().get();
				}
				
			}).start();;
		}
		
		
	}
	
	static class A{
		int data=threadLocal;
		public void get(){
			System.out.println("A from "+Thread.currentThread().getName()+" get data :"+data);
			MyThreadScopeData1 myData=  MyThreadScopeData1.getThreadInstance();
			System.out.println("A from "+Thread.currentThread().getName()+"getMyData:"+myData.getName()+"--"+myData.getNum());
		}
		
	}
	
	static class B{
		int data=threadLocal;
		public void get(){
			System.out.println("B from "+Thread.currentThread().getName()+" get data :"+data);
			MyThreadScopeData1 myData=  MyThreadScopeData1.getThreadInstance();
			System.out.println("B from "+Thread.currentThread().getName()+"getMyData:"+myData.getName()+"--"+myData.getNum());
		}
		
		
	}
	
	
	
	

}
