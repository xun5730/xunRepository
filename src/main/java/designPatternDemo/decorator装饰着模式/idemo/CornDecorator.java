package designPatternDemo.decorator装饰着模式.idemo;

public class CornDecorator extends AbstractBread {

	
	public CornDecorator(IBread bread) {
		super(bread);
	}

	public void paint(){
		
		System.out.println("添加柠檬黄的着色剂");
	}
	
	@Override
	public void kneadFlour() {
		this.paint();
		super.kneadFlour();
	}
	
	
	
	

}
