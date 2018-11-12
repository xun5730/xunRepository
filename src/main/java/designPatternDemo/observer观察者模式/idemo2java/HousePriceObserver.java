package designPatternDemo.observer观察者模式.idemo2java;

import java.util.Observable;
import java.util.Observer;

public class HousePriceObserver implements Observer {

	private String name;
	public HousePriceObserver(String name){
		this.name=name;
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		//这里最好判断一下通知是否来自于房价，有可能来自其它地方
		if( o instanceof House){
			System.out.println("购物者"+name+ "观察到房价已调整为："+arg);
		}
		
	}

}
