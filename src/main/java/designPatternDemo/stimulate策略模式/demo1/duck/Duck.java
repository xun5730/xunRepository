package designPatternDemo.stimulate策略模式.demo1.duck;

import designPatternDemo.stimulate策略模式.demo1.flybehavior.FlyBehavior;
import designPatternDemo.stimulate策略模式.demo1.quackbehavior.QuackBehavior;

public abstract class Duck {
	public Duck(){}
	
	public abstract void display();
	public void swim(){
		System.out.println("~~~im swim~~~");
	}
	
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public void fly(){
		flyBehavior.fly();
	}
	
	public void quack(){
		quackBehavior.quack();
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	
	

}
