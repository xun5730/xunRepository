package designPatternDemo.工厂模式demo.abstractFactory;

public class ConcreteFactory1  extends AbstractFactory{

	@Override
	AbstractProductA createProductA() {
		return new ProductA1();
	}

	@Override
	AbstractProductB createProductB() {
		// TODO Auto-generated method stub
		return new ProductB1();
	}

}
