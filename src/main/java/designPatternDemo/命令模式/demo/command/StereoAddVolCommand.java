package designPatternDemo.命令模式.demo.command;

import designPatternDemo.命令模式.demo.device.Stereo;

public class StereoAddVolCommand implements Command {

	private Stereo stereo;
	
	public StereoAddVolCommand(Stereo stereo){
	
		this.stereo=stereo;
	}
	
	@Override
	public void execute() {
		int vol=stereo.getVolume();
		if(vol<11){
			stereo.setVolume(++vol);
		}
		
	}

	@Override
	public void undo() {
		
		int vol =stereo.getVolume();
		if(vol>0){
			stereo.setVolume(--vol);
		}
		
		
	}

}
