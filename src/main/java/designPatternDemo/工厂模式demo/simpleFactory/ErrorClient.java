package designPatternDemo.工厂模式demo.simpleFactory;
/**
 * 

很不好的实现
 */
public class ErrorClient {

/*	以下的 Client 类包含了实例化的代码，这是一种错误的实现。
	如果在客户类中存在这种实例化代码，就需要考虑将代码放到简单工厂中。*/
	public static void main(String[] args) {
		 int type = 1;
	        Product product;
	        if (type == 1) {  
	            product = new ConcreteProdect1();
	        } else if (type == 2) {
	            product = new ConcreteProdect2();
	        } else {
	            product = new ConcreteProdect();
	        }
	        // do something with the product
	}
}
