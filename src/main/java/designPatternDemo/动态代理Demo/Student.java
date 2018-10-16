package designPatternDemo.动态代理Demo;

public class Student implements Person {

	@Override
	public void sayHello(String content) {
		System.out.println("你好："+content);
	}

	@Override
	public String sayDemo() {
		System.out.println("你好，地球");
		
		return "你好，地球";
	}
	public String demo(){
		System.out.println("地球绕日太阳转");
		return "地球绕日太阳转";
	}

}
