package designPatternDemo.命令模式.demo;

import designPatternDemo.命令模式.demo.device.Light;
import designPatternDemo.命令模式.demo.device.Stereo;

public class TraditionControl  implements Control{

	Light light;
	Stereo stereo;
	
	
	public TraditionControl(Light light ,Stereo stereo){
		this.light=light;
		this.stereo=stereo;
	}
	
	@Override
	public void onButton(int slot) {

		switch (slot) {
		case 0:
			light.on();
			break;
		case 1:
			stereo.on();
			break;
		case 2:
			int vol = stereo.getVolume();
			if (vol < 11) {
				stereo.setVolume(++vol);
			}
			break;

		}
		
		
		
	}

	@Override
	public void offButton(int slot) {
		
		switch (slot) {
		case 0:
			light.off();
			break;
		case 1:
			stereo.off();
			break;
		case 2:
			int vol = stereo.getVolume();
			if (vol > 0) {
				stereo.setVolume(--vol);
			}
			break;
		}
		
	}

	@Override
	public void undoButton() {
		
	}

}
