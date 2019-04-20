package basicsDemo.java基础类的初始化;

public class CMain1 {

	
	static {
		
		System.out.println("static init main");
	}
	{
		System.out.println("instance init main");
	}
	
	public CMain1(){
		System.out.println("construtor main");
	}
	public static void main(String[] args) {
	C1 c=new C1();
	
	System.out.println("=============>>>>>>");
	C1 c2=new C1();
	
	/*观察上面的输出，可以观察到两个有趣的现象：

	Main类是肯定没有被实例化过的，但是由于执行main入口函数用到了Main类，于是static初始化块也被执行了；
	所有的静态初始化块都优先执行，其次才是非静态的初始化块和构造函数，它们的执行顺序是：
	父类的静态初始化块
	子类的静态初始化块
	父类的初始化块
	父类的构造函数
	子类的初始化块
	子类的构造函数*/
	
	
	}
	
	
}
