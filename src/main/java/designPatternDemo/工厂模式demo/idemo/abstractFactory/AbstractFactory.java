package designPatternDemo.工厂模式demo.idemo.abstractFactory;

import designPatternDemo.工厂模式demo.idemo.factoryDemo.Cpu;
import designPatternDemo.工厂模式demo.idemo.factoryDemo.MainBoard;

public interface AbstractFactory {
	
	
	/**
     * 创建CPU对象
     * @return CPU对象
     */
	public Cpu createCpu();
	 /**
     * 创建主板对象
     * @return 主板对象
     */
	public MainBoard createMainBoard();

}
