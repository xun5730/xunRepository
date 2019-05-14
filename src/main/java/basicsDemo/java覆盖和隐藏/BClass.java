package basicsDemo.java覆盖和隐藏;

public class BClass  extends SClass{

    public static int i=10;
	public int j=20;
	public final int k=30;
	
	public static void method1(){
		System.out.println("bb static method1");
	}
	
	public void method2(){
		System.out.println("bb method2");
	}
	
/*	public final void method3(){//不能被编译 不能重写父类中的最终方法(final)；
		System.out.println("bb final method3");
	}*/
	public static void main(String[] args) {
		SClass s=new BClass();
		SClass s2=new SClass();
		s2.method1();
		System.out.println("i"+s.i);//1
		System.out.println("i"+s.j);//2
		System.out.println("i"+s.k);//3
		
		s.method1();//bb static method1
		s.method2();//bb method2
		s.method3();//super final method3
		BClass b=new BClass();
		System.out.println("i"+b.i);//10
		System.out.println("i"+b.j);//20
		System.out.println("i"+b.k);//30
		
		b.method1();//bb static method1
		b.method2();//bb method2
		b.method3();//super final method3
//		变量只能被隐藏(包括静态和非静态)，不能被覆盖
		
	}
	
	
}
