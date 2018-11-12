package designPatternDemo.observer观察者模式.idemo;

public class ConcreteObserver implements Observer {

	//观察者的状态
	private String oberverState;
	
	
	@Override
	public void update(String state) {

		/**
		 * 更新观察者的状态，使其与目标的状态保持一致
		 */
		oberverState=state;
		System.out.println("状态"+oberverState);
		
	}

}
