package designPatternDemo.命令模式.idemo.audioPlayerDemo.macroCommand;

import designPatternDemo.命令模式.idemo.audioPlayerDemo.AudioPlayer;
import designPatternDemo.命令模式.idemo.audioPlayerDemo.Command;
import designPatternDemo.命令模式.idemo.audioPlayerDemo.PlayCommand;
import designPatternDemo.命令模式.idemo.audioPlayerDemo.RewindCommand;
import designPatternDemo.命令模式.idemo.audioPlayerDemo.StopCommand;

public class JuliaMacro {
	
	/**
	 * 
	 * 
	 * 　所谓宏命令简单点说就是包含多个命令的命令，是一个命令的组合。

　　设想茱丽的录音机有一个记录功能，可以把一个一个的命令记录下来，再在任何需要的时候重新把这些记录下来的命令一次性执行，这就是所谓的宏命令集功能。因此，茱丽的录音机系统现在有四个键，分别为播音、倒带、停止和宏命令功能。此时系统的设计与前面的设计相比有所增强，主要体现在Julia类现在有了一个新方法，用以操作宏命令键。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//创建接收者对象
		AudioPlayer audioPlayer=new AudioPlayer();
		
		//创建命令对象
		Command playCommand=new PlayCommand(audioPlayer);
		Command rewindCommand=new RewindCommand(audioPlayer);
		Command stopCommand=new StopCommand(audioPlayer);
		
		
		MacroCommand marco=new MacroAudioCommand();
		marco.add(playCommand);
        marco.add(rewindCommand);
        marco.add(stopCommand);
        marco.execute();
		
		
	}

}
