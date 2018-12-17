package designPatternDemo.状态模式.idemo.prototype;

public class ConcreteStateB  implements State{

	@Override
	public void handle(String sampleParameter) {
		 System.out.println("ConcreteStateB handle ：" + sampleParameter);
	}

}
