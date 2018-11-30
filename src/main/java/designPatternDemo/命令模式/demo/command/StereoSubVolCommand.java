package designPatternDemo.命令模式.demo.command;

import designPatternDemo.命令模式.demo.device.Stereo;

public class StereoSubVolCommand  implements Command{

	private Stereo setreo;
	
	public StereoSubVolCommand( Stereo  setreo){
		this.setreo=setreo;
	}
	@Override
	public void execute() {
		
		int vol=setreo.getVolume();
		if(vol>0)
		{
			setreo.setVolume(--vol);
		}
		
	}

	@Override
	public void undo() {
		int vol=setreo.getVolume();
		if(vol<11)
		{
			setreo.setVolume(++vol);
		}
		
	}

}
