package designPatternDemo.命令模式.idemo.audioPlayerDemo;

public class PlayCommand implements Command {

	private AudioPlayer audioPlayer;
	
	
	public PlayCommand(AudioPlayer audioPlayer  ){
		this.audioPlayer=audioPlayer;
	}
	
	/**
	 * 执行方法
	 */
	@Override
	public void execute() {
		audioPlayer.play();
	}

}
