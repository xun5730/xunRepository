package designPatternDemo.工厂模式demo.idemo.abstractFactory;

public class Client {
	
	public static void main(String[] args) {
		
		//创建装机工程师对象
		ComputerEngineer cf=new ComputerEngineer();
		AbstractFactory af=new IntelFactory();
		cf.makeComputer(af);
	}

}
