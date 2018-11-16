package designPatternDemo.observer观察者模式.demo1.jvdemo;

import java.util.Observable;
import java.util.Observer;

import designPatternDemo.observer观察者模式.demo1.jvdemo.WeatherData.Data;

public class CurrentConditions implements Observer {

	private float mTemperatrue;
	private float mPressure;
	private float mHumidity;
	@Override
	public void update(Observable o, Object arg1) {
		this.mTemperatrue=((Data)(arg1)).mTemperatrue;
		this.mPressure=((Data)(arg1)).mPressure;
		this.mHumidity=((Data)(arg1)).mHumidity;
		display();
		
		
	}
	public void display()
	{
		System.out.println("***Today mTemperatrue:" +mTemperatrue+"***");
		System.out.println("***Today mPressure:" +mPressure+"***");
		System.out.println("***Today mHumidity:" +mHumidity+"***");
	}

}
