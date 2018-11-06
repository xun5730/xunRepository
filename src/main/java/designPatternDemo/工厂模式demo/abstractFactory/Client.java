package designPatternDemo.工厂模式demo.abstractFactory;

public class Client {
	public static void main(String[] args) {
		
		AbstractFactory abstractFactory=new ConcreteFactory1();
		
		AbstractProductA  productA=abstractFactory.createProductA();
		AbstractProductB  productB=abstractFactory.createProductB();
		
		
	}

}
