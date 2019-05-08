package basicsDemo.threadLocal例子.demo1;

public class MyThreadScopeData1 {
	
	private static ThreadLocal<MyThreadScopeData1> map=new ThreadLocal<MyThreadScopeData1>();
	

	public static MyThreadScopeData1 getThreadInstance(){
		MyThreadScopeData1 instance=  map.get();
		if(instance==null){
			instance=new MyThreadScopeData1();
		    map.set(instance);
		}
		return instance;
	}
	
	
	private String name;
	private int num;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	

}
