package designPatternDemo.工厂模式demo.idemo.factoryDemo;

public class AmdMainBoard implements  MainBoard {
	/**
	 * CPU插槽的孔数
	 */
	private int cpuHoles = 0;

	public AmdMainBoard(int cpuHoles) {
		this.cpuHoles = cpuHoles;
	}

	@Override
	public void installCpu() {
		System.out.println("AMD主板的CPU插槽孔数是：" + cpuHoles);
	}
}
