package designPatternDemo.stimulate策略模式.demo1.duck;

import designPatternDemo.stimulate策略模式.demo1.flybehavior.BadFlyBehavior;
import designPatternDemo.stimulate策略模式.demo1.quackbehavior.GeGeQuackBehavior;

public class RedHeadDuck  extends Duck{

	
	

	@Override
	public void display() {

		System.out.println("***red head***");
		
	}
	public  RedHeadDuck(){
		flyBehavior=new BadFlyBehavior();
		quackBehavior=new GeGeQuackBehavior();
	}
	

}
