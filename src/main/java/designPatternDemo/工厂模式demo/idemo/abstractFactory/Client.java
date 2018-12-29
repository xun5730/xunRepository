package designPatternDemo.工厂模式demo.idemo.abstractFactory;

public class Client {
	
//	https://www.cnblogs.com/java-my-life/archive/2012/03/28/2418836.html
	public static void main(String[] args) {
		
		//创建装机工程师对象
		ComputerEngineer cf=new ComputerEngineer();
		AbstractFactory af=new IntelFactory();
		cf.makeComputer(af);
	}

}
