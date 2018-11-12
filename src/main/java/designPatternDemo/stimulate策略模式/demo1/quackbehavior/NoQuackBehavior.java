package designPatternDemo.stimulate策略模式.demo1.quackbehavior;

public class NoQuackBehavior implements QuackBehavior {

	@Override
	public void quack() {

		System.out.println("___no quack___");
	}

}
