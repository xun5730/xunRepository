package basicsDemo.java基础类的初始化;

public class A1 {
	
	static {
		System.out.println("Static init A");
	}
	{
		
		System.out.println("Instance init A");
	}
	
	A1(){
		System.out.println("Constructor A");
	}
	
}
