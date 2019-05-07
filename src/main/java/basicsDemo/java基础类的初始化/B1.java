package basicsDemo.java基础类的初始化;

public class B1 extends A1 {

	static {
		
		System.out.println("static init B");
	}
	
	{
		System.out.println("instance init b");
	}
	
	B1(){
		System.out.println("Constructor B");
	}
	
	
}
