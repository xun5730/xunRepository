package basicsDemo.java基础_静态内部类和非静态;

/**
 * 下面程序演示如何在java中创建静态内部类和非静态内部类 
 * @author Administrator
 *
 */
public class OuterClass {
	private static String msg="GeeksForGeeks";
	
	//静态内部类
	public static class NesteStaticClass{

		//静态内部类只能访问内部类的静态成员
		public void printMessage(){
			//试着将MSG该处非静态的，这将导致编译错误
			System.out.println("message from nested static class :"+msg);
		}
		
	}
	
	//非静态内部类
	public class InnerClass{
		//不管是静态方法还是非静态方法都可以在非静态内部类中访问
		public void display(){
			System.out.println(" message from non-static nested class:"+msg);
		}
		
	}
	
	
	

}
