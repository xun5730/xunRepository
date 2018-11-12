package designPatternDemo.stimulate策略模式.demo1.duck;

import designPatternDemo.stimulate策略模式.demo1.flybehavior.GoodFlyBehavior;
import designPatternDemo.stimulate策略模式.demo1.quackbehavior.GaGaQuackBehavior;

public class GreenHeadDuck extends Duck {

	@Override
	public void display() {
		System.out.println("*** green head***");
	}

	public GreenHeadDuck(){
		
		flyBehavior=new GoodFlyBehavior();
		quackBehavior=new GaGaQuackBehavior();
		
	}
	
	
}
