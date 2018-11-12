package designPatternDemo.stimulate策略模式.demo1.oo;

public abstract class  Duck {

	public Duck(){}
	
	public void Quack(){
		System.out.println("~~~gaga~~~");
	}
	
	public void swim(){
		System.out.println("~~~in swim~~~");
	}
	public void fly(){
		System.out.println("~~~in fly~~~");
	}
	public abstract void display();
	
	
	
}
