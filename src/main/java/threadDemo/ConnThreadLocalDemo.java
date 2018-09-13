package threadDemo;

public class ConnThreadLocalDemo {
	private ThreadLocal<String> th=new ThreadLocal<String>();

	public ThreadLocal<String> getTh() {
		return th;
	}

	public void setTh(ThreadLocal<String> th) {
		this.th = th;
	}
	
	
	
	public static void main(String[] args) {
		final ConnThreadLocalDemo threadDemo=new ConnThreadLocalDemo();
		Thread t1=new Thread(new Runnable(){

			@Override
			public void run() {
                  
				ThreadLocal<String> tl1=new ThreadLocal<String>();
				tl1.set("t1");
				System.out.println(tl1.get()+"-------");
				threadDemo.setTh(tl1);
				System.out.println(threadDemo.getTh().get());
			}
			
		},"t1");
		
		Thread t2=new Thread(new Runnable(){

			@Override
			public void run() {

				ThreadLocal<String> tl2=new ThreadLocal<String>();
				tl2.set("t2");
				threadDemo.setTh(tl2);
				System.out.println(threadDemo.getTh().get());
			}
			
		},"t2");
		t1.start();
		t2.start();
		
		
		
	}
	
	
	

}
