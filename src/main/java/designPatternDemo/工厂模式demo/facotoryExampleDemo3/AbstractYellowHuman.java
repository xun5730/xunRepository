package designPatternDemo.工厂模式demo.facotoryExampleDemo3;

public class AbstractYellowHuman implements Human {

	@Override
	public void getColor() {

		System.out.println("黄色人种的皮肤颜色是白色的！");
	}

	@Override
	public void talk() {
		System.out.println("黄色人种会说话，一般都是但是双字节。");
	}

	@Override
	public void getSex() {
		
	}

}
