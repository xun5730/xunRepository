package designPatternDemo.命令模式.demo.device;

public class Light {
	
	String ioc="";
	
	public Light(String loc){
		this.ioc=ioc;
	}
	
	public void on(){
		System.out.println(ioc+"on");
		
	}
	
	public void off(){
		System.out.println(ioc+"off");
	}
	

}
