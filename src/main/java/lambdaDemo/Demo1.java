package lambdaDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//**

public class Demo1 {
	public static void main(String[] args) {
		
		
		
//		
//		//创建线程
//		Thread td=new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//
//				System.out.println("hello....");
//			}
//			
//		});
//		
//		td.start();
//		//lambda 写法
//		Thread td1=new Thread(()-> System.out.println("hello,lambda"));
//		td1.start();
		
		
		//排序
		List<String> list=Arrays.asList(new String[]{"b","c","a"});
		for( String str:list ){
			System.out.println(str);
		}
//		Collections.sort(list);
//		for( String str:list ){
//			System.out.println(str);
//		}
		//匿名匿名内部类
		Collections.sort(list, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		//lambda写法
		Collections.sort(list, (str1,str2)->str1.compareTo(str2));
		
		List<String> proNames=Arrays.asList(new String[]{"Ni","Hao","Lambda"});
		
		List<String> lowerProNames=new ArrayList<String>();
		for(String str:proNames){
			lowerProNames.add(str.toLowerCase());
		}
		//lambda写法
		List<String> lowercaseNamesLambda=proNames.stream().map(name -> {return name.toLowerCase();} ).collect(Collectors.toList());
		
		
		
		
		
		
	}

}
