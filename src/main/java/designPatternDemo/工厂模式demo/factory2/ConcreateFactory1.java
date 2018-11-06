package designPatternDemo.工厂模式demo.factory2;

import designPatternDemo.工厂模式demo.simpleFactory.ConcreteProdect;
import designPatternDemo.工厂模式demo.simpleFactory.ConcreteProdect1;
import designPatternDemo.工厂模式demo.simpleFactory.Product;

public class ConcreateFactory1 extends Factory {

	@Override
	public Product factoryMethod() {
		return new ConcreteProdect1();
	}

}
