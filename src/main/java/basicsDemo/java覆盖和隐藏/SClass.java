package basicsDemo.java覆盖和隐藏;

public class SClass {

	public static int i=1;
	
	public int j=2;
	public final int k=3;
	
	public static void method1(){
		System.out.println("super static method1");
	}
	
	public void method2(){
		System.out.println("super method2");
	}
	
	public final void method3(){
		System.out.println("super final method3");
	}
	
	
	
	
	
}
