package designPatternDemo.命令模式.demo.device;

public class Stereo {
	
	 int volume=0;
	
	public void on(){
		System.out.println(" stereo on ");
	}
	
	public void off(){
		System.out.println("stereo off");
	}
	public void setCd(){
		System.out.println("stereo setCd");
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void start(){
		System.out.println("stereo start");
	}
	
	
	

}
