package basicsDemo.重载;

public class CongZai {
	
	public static void main(String[] args) {
		
		short s=5;
		overloadMethod(s);
		int i=10;
		overloadMethod(i);
		overloadMethod(s,s);
	}

	public static void overloadMethod(int a) { //m1
	    System.out.println("调用  overloadMethod(int)");
	}
	public static void overloadMethod(short in) {//m2 换成Short会不一样的
	    System.out.println("调用  overloadMethod(short)");
	}
	public static void overloadMethod(int a,int b) {//m3
	    System.out.println("调用  overloadMethod(int,int)");
	}
	public static void overloadMethod(short... s) { //m4
	    System.out.println("调用  overloadMethod(short...)");
	}
	public static void overloadMethod(Integer... i) {//m5
	    System.out.println("调用  overloadMethod(Integer...)");
	}
	
	

}
