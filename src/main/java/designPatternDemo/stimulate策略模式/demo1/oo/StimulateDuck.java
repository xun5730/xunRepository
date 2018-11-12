package designPatternDemo.stimulate策略模式.demo1.oo;

public class StimulateDuck {
	public static void main(String[] args) {
		
		GreenHeadDuck greenHeadDuck=new GreenHeadDuck();
		RedHeadDuck redHeadDuck=new RedHeadDuck();
		greenHeadDuck.display();
		greenHeadDuck.fly();
		greenHeadDuck.Quack();
		greenHeadDuck.swim();
		
		redHeadDuck.display();
		redHeadDuck.Quack();
		redHeadDuck.swim();
		redHeadDuck.fly();
	}

}
