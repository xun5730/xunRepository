package designPatternDemo.工厂模式demo.idemo.abstractFactory;

import designPatternDemo.工厂模式demo.idemo.factoryDemo.AmdCpu;
import designPatternDemo.工厂模式demo.idemo.factoryDemo.AmdMainBoard;
import designPatternDemo.工厂模式demo.idemo.factoryDemo.Cpu;
import designPatternDemo.工厂模式demo.idemo.factoryDemo.MainBoard;

public class AmdFactory implements AbstractFactory {

	@Override
	public Cpu createCpu() {
		return new AmdCpu(938);
	}

	@Override
	public MainBoard createMainBoard() {
		return new AmdMainBoard(938);
	}

}
