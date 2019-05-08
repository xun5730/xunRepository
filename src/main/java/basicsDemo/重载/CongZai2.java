package basicsDemo.重载;

public class CongZai2 {
	
	public static void main(String[] args) {
		
		int a=5;
		Short s=8;
		m(a,s);
		
		
	}

	private static void m(int a, Short s) {
		System.out.println("调用了m(int ,Short)");
	}
	
	private static void m(float f,Short s){
		System.out.println("调用了m(float,short)");
	}
	
	

}
