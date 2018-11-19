package designPatternDemo.适配器模式.idemo.prototype2;

public interface Target {
	
	/**
	 * 这是源类Adaptee也有的方法
	 */
	public void sampleOperation1();
	
	/**
	 * 这是源类Adaptee没有方法
	 */
	public void sampleOperation2();

}
