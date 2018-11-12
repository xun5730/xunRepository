package designPatternDemo.stimulate策略模式.demo1.oo;

public class GreenHeadDuck extends Duck {

	@Override
	public void display() {

		System.out.println("***greenHead***");
	}

	@Override
	public void fly() {

		System.out.println("~~~no fly~~~");
	}
	
	

}
