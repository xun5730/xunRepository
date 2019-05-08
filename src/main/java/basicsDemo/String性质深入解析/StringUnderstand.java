package basicsDemo.String性质深入解析;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class StringUnderstand {

	
	public static void main(String[] args) {
		
//		example1();
		
//		example2();

		

		
	}

	private static void example2() {

		String s="Love You";
		String s2="Love"+" You";
		String s3=s2+"";
		
		String s4=new String("Love You");
		String s5="Love Y"+"ou";
		System.out.println("s==s2"+(s==s2));//true
		System.out.println("s==s3"+(s==s3));//false
		System.out.println("s==s4"+(s==s4));//false
		System.out.println("s==s4"+(s==s5));
		
	}

	private static void example1() {

		char[] arr=new char[]{'a','b','c','d'};
		String str=new String(arr);
		
		arr[3]='e';
		System.out.println("str="+str);
		System.out.println("arr[]="+Arrays.toString(arr));
		
	}
}
