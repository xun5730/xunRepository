package designPatternDemo.工厂模式demo.simpleFactory;
/**
 * 

 *正确使用简单工厂模式好处
 */
public class SuccessClient {
	
	public static void main(String[] args) {
		
		SimpleFactory simpleFactory=new SimpleFactory();
		Product product= simpleFactory.createProduct(1);
		System.out.println(product);
		// do something with the product
	}

}
