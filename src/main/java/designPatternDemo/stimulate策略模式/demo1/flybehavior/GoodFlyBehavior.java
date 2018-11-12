package designPatternDemo.stimulate策略模式.demo1.flybehavior;

public class GoodFlyBehavior  implements FlyBehavior{

	@Override
	public void fly() {

		System.out.println("---good fly---");
	}

}
