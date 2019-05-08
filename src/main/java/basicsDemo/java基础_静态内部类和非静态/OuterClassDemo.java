package basicsDemo.java基础_静态内部类和非静态;

public class OuterClassDemo {//外围类
	
	public int aa;//实例成员
	private static float f=1.5f;
	static void println(){
		System.out.println("这是静态方法");
	}
	
	protected static class StaticInnerClass{
		float a;
		public StaticInnerClass(){
			a=f;//外围类的private 静态变量
			println();//外围类的静态方法
		}
		
		
	}
	
	
	
	

}
