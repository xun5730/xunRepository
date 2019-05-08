package basicsDemo.运算顺序的深入解析;

import java.util.Arrays;

public class YunSuanShunXu {
	
	
	public static void main(String[] args) {
		
		
//		在Java中，表达式的计算顺序是从左往右的，也就是先计算左侧的结果，再计算右侧的结果。
//		example1();
//		example2();
//		example3();
//		example4();
		
//		example5();
		example6();
		
		
		
		
		
		
	}

	private static void example6() {

		int a=5;
		a*=a=2;
		System.out.println(a);
		
		
	}

	private static void example5() {

		int a=1;
		a+=++a;
		System.out.println(a);
	}

	private static void example4() {

		int a[]=new int[]{0,0,0,0};
		int b[]=new int[]{1,2,3,4,5};
		
		int cc[]=a;
		int i=1;
		a[++i]=(a=b)[i];
		System.out.println("i="+i);
		System.out.println("数组a[]"+Arrays.toString(a));
		System.out.println("数组c[]"+Arrays.toString(cc));
		
		
	}

	private static void example3() {
		int a[]=new int[]{0,0,0,0};
		int i=1;
		a[i++]=i=4;
		System.out.println("i="+i);
		System.out.println(Arrays.toString(a));
		
	}

	private static void example2() {
		int a[]=new int[]{0,0,0,0};
		int i=1;
		a[i++]=i++;
		System.out.println("i="+i);
		System.out.println(Arrays.toString(a));
	}

	private static void example1() {

		int i=5;
		int j=(i++)+(i++)+(i++);
		System.out.println(j);
		
		
	}

}
