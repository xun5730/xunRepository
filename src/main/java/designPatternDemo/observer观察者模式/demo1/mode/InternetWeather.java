package designPatternDemo.observer观察者模式.demo1.mode;

public class InternetWeather {
	
	public static void main(String[] args) {
		
		CurrentConditions currentConditions;
		ForcastConditions forcastConditions;
		WeatherDataSt weatherDataSt;
		
		weatherDataSt=new WeatherDataSt();
		currentConditions=new CurrentConditions();
		forcastConditions=new ForcastConditions();
		
		weatherDataSt.registerObserver(currentConditions);
		weatherDataSt.registerObserver(forcastConditions);
		
		weatherDataSt.setData(30, 150, 40);
		weatherDataSt.removeObserver(currentConditions);
		weatherDataSt.setData(40, 250, 50);
		
		
		
		
		
		
	}

}
