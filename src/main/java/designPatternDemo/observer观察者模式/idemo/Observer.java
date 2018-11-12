package designPatternDemo.observer观察者模式.idemo;

public interface Observer {

	
	/**
	 * 更新接口
	 * @param state 更新的状态
	 */
	public void update(String state);
}
