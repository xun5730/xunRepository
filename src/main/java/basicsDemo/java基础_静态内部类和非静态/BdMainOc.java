package basicsDemo.java基础_静态内部类和非静态;

public class BdMainOc {
	//https://www.cnblogs.com/coshaho/p/5127135.html
//	https://www.cnblogs.com/kungfupanda/p/7239414.html
	//怎么创建静态内部类和非静态内部类的实例
	public static void main(String[] args) {
		
		//创建静态内部类的实例
		OuterClass.NesteStaticClass printer=new OuterClass.NesteStaticClass();

		//创建静态内部类的非静态方法
		printer.printMessage();
		
	
		//为了创建非静态内部类，我们需要外部类的实例
		OuterClass outer=new OuterClass();
		OuterClass.InnerClass inner=  outer.new InnerClass();
		
		//调用非静态内部类的非静态方法
		inner.display();
		
		//我们也可以结合以上步骤，一步创建内部类的实例
		OuterClass.InnerClass innerObject=    new OuterClass().new InnerClass();
		//同样我们现在可以调用内部类方法
		innerObject.display();
		
		
		
	}

}
