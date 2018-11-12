package designPatternDemo.observer观察者模式.idemo2java;

import java.util.Observable;

public class House  extends Observable{

	
	private double price;
	public House(double price){
		this.price=price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		
		if(this.price!=price){
			this.price = price;
			setChanged();//标注价格已经被更改
			this.notifyObservers(price);
		}
	
	}
	@Override
	public String toString() {
		return "当前房价为："+price;
	}

	
	
	
}
