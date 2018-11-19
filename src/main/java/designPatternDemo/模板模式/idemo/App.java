package designPatternDemo.模板模式.idemo;

public class App {
	
	
	
	
	
	/*引入：这几天在看一本讲spring源码的书《SPRING技术内幕》里面在讲加载配置文件的时候，可以有不同的加载方式，如根据文件系统目录加载配置文件（FileSystemXmlApplicationContext），类路径加载配置文件(ClassPathXmlApplicationContext)，以及根据项目上下文目录(XmlWebApplicationContext)加载配置文件。这个在加载的过程中就使用了模板设计模式，所以就来学习下模板设计模式。

	1. 模板设计模式在书中定义：
	　 定义一个操作中算法的骨架，而将一些步骤延迟到子类中，模板方法使得子类可以不改变算法的结构即可重定义该算法的某些特定步骤。

	　 通俗点的理解就是 ：完成一件事情，有固定的数个步骤，但是每个步骤根据对象的不同，而实现细节不同；就可以在父类中定义一个完成该事情的总方法，按照完成事件需要的步骤去调用其每个步骤的实现方法。每个步骤的具体实现，由子类完成。

	2. 如下网上找到的一个模板模式的类图：
	　　抽象父类（AbstractClass）：实现了模板方法，定义了算法的骨架。

	　　具体类（ConcreteClass)：实现抽象类中的抽象方法，即不同的对象的具体实现细节*/
	
	public static void main(String[] args) {
		DodishTemplate e=new EggsWithTomato();
		e.doDish();
		
		System.out.println("-------------");
		DodishTemplate b=new Bouilli();
		b.doDish();
		
		
		
	}

}
