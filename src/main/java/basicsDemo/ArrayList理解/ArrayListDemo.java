package basicsDemo.ArrayList理解;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
	public static void main(String[] args) {
		
		
		int oldCapacity=1;
		int newCapacity=oldCapacity+(oldCapacity>>1);
		int a=10;
		System.out.println(newCapacity);
		System.out.println(a>>1);
	/*	
		List<Integer> list2=new ArrayList<Integer>();
		for(int i=0;i<20;i++){
			list2.add(i);
			System.out.println(i);
		}
		*/
		
	}

}
