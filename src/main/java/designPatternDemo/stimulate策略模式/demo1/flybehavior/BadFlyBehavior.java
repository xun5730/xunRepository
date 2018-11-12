package designPatternDemo.stimulate策略模式.demo1.flybehavior;

public class BadFlyBehavior implements FlyBehavior {

	@Override
	public void fly() {

		System.out.println("---bad fly---");
	}

}
