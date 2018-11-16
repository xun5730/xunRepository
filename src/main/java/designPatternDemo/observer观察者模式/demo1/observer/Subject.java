package designPatternDemo.observer观察者模式.demo1.observer;

public interface Subject {
	
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();

}
