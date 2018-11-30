package designPatternDemo.命令模式.demo.command;

import designPatternDemo.命令模式.demo.device.Light;

public class LightOffCommand  implements Command{

	private Light light;
	
	public LightOffCommand(Light light){
		this.light=light;
	}
	
	@Override
	public void execute() {
		light.off();
	}

	@Override
	public void undo() {
		light.on();
	}

}
