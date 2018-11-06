package designPatternDemo.工厂模式demo.factory2;

import designPatternDemo.工厂模式demo.simpleFactory.Product;

public abstract class  Factory {

	abstract public Product factoryMethod();
	public void doSomethding(){
	    Product product= 	factoryMethod();
	    System.out.println(product);
	 // do something with the product
	}
	
	
}
