package designPatternDemo.工厂模式demo.idemo.factoryDemo;

public class AmdCpu implements Cpu {

	
	/**
	 * cpu的真脚数
	 */
	private int pins=0;
	
	public AmdCpu(int pins){
		this.pins=pins;
	}
	
	
	@Override
	public void calculate() {
		 System.out.println("AMD CPU的针脚数：" + pins);
	}

}
