package basicsDemo;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * 
 * @author xun
 * 
 * 参数传递demo
 *
 *
 *Java 的参数是以值传递的形式传入方法中，而不是引用传递。

以下代码中 Dog dog 的 dog 是一个指针，存储的是对象的地址。在将一个参数传入一个方法时，
本质上是将对象的地址以值的方式传递到形参中。因此在方法中使指针引用其它对象，
那么这两个指针此时指向的是完全不同的对象，
在一方改变其所指向对象的内容时对另一方没有影响。
 */
public class ParameterObjPassDemo {
	
	String name;
	
	ParameterObjPassDemo(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static void func( ParameterObjPassDemo demo ){
		System.out.println(demo.toString());
		demo=new ParameterObjPassDemo("B");
		System.out.println(demo.getName()+"----"+demo.toString());
	}
	
	
	public static void main(String[] args) {
		
		
		ParameterObjPassDemo a=new ParameterObjPassDemo("A");
		System.out.println(a.toString()+"--"+a.getName());
		
		func(a);
		System.out.println(a.getName()+"---"+a.toString());
		
		
	}
	

}
