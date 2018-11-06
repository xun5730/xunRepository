package designPatternDemo.工厂模式demo.factory2;

import designPatternDemo.工厂模式demo.simpleFactory.ConcreteProdect;
import designPatternDemo.工厂模式demo.simpleFactory.ConcreteProdect1;
import designPatternDemo.工厂模式demo.simpleFactory.ConcreteProdect2;
import designPatternDemo.工厂模式demo.simpleFactory.Product;

public class ConcreateFactory2 extends Factory {

	@Override
	public Product factoryMethod() {
		return new ConcreteProdect2();
	}

}
