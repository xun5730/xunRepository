package designPatternDemo.工厂模式demo.factory2;

import designPatternDemo.工厂模式demo.simpleFactory.ConcreteProdect;
import designPatternDemo.工厂模式demo.simpleFactory.Product;

public class ConcreateFactory extends Factory {

	@Override
	public Product factoryMethod() {
		return new ConcreteProdect();
	}

}
