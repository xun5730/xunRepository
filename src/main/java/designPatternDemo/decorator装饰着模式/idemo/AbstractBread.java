package designPatternDemo.decorator装饰着模式.idemo;

public class AbstractBread  implements IBread{

	
	private  IBread bread;
	
	public AbstractBread(IBread bread){
		this.bread=bread;
	}
	
	
	@Override
	public void prepair() {
		this.bread.prepair();
		
	}

	@Override
	public void kneadFlour() {
		this.bread.kneadFlour();
	}

	@Override
	public void steamed() {
		this.bread.steamed();
	}

	@Override
	public void process() {
		prepair();
		kneadFlour();
		steamed();
	}

}
