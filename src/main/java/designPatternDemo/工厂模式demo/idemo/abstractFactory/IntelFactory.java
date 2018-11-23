package designPatternDemo.工厂模式demo.idemo.abstractFactory;

import designPatternDemo.工厂模式demo.idemo.factoryDemo.Cpu;
import designPatternDemo.工厂模式demo.idemo.factoryDemo.IntelCpu;
import designPatternDemo.工厂模式demo.idemo.factoryDemo.IntelMainBoard;
import designPatternDemo.工厂模式demo.idemo.factoryDemo.MainBoard;

public class IntelFactory  implements AbstractFactory{

	@Override
	public Cpu createCpu() {
		return new IntelCpu(755);
	}

	@Override
	public MainBoard createMainBoard() {
		return new IntelMainBoard(755);
	}

}
