package designPatternDemo.工厂模式demo.facotoryExampleDemo3;

public class AbstractBlackHuman implements Human {

	@Override
	public void getColor() {

		System.out.println("黑色人种的皮肤颜色是白色的！");
	}

	@Override
	public void talk() {
		System.out.println("黑色人种会说话，但是听不懂。");
	}
	@Override
	public void getSex() {
		
	}

}
