package basicsDemo.java基础类的初始化;

public class C1 extends B1 {
	
	static {
		System.out.println("static init C");
	}
	{
		System.out.println("instance init C");
	}
	C1(){
		System.out.println("Constructor C");
	}
	

}
