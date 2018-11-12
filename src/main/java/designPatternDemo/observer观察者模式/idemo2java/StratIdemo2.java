package designPatternDemo.observer观察者模式.idemo2java;

public class StratIdemo2 {

	public static void main(String[] args) {
		
		House house=new House(10000);
		HousePriceObserver a=new HousePriceObserver("a");
		HousePriceObserver b=new HousePriceObserver("b");
		HousePriceObserver c=new HousePriceObserver("c");
		house.addObserver(a);
		house.addObserver(b);
		house.addObserver(c);
		System.out.println(house);
		house.setPrice(6000);
		house.setPrice(8000);
	}
}
