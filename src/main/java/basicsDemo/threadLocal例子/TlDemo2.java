package basicsDemo.threadLocal例子;

public class TlDemo2 {
	
	ThreadLocal<Long> longLocal=new ThreadLocal<Long>();
	ThreadLocal<String>  StringLocal=new ThreadLocal<String>();
	
	
	public void set(){
		longLocal.set(Thread.currentThread().getId());
		StringLocal.set(Thread.currentThread().getName());
	}
	
	public long getLong(){
		return longLocal.get();
	}
	public String getString(){
		return StringLocal.get();
	}
	
	

}
