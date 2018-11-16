package designPatternDemo.命令模式.idemo.audioPlayerDemo;

public class KeyPad {
	private Command playCommand;
	private Command rewindCommand;
	private Command stopCommand;
	public void setPlayCommand(Command playCommand) {
		this.playCommand = playCommand;
	}
	public void setRewindCommand(Command rewindCommand) {
		this.rewindCommand = rewindCommand;
	}
	public void setStopCommand(Command stopCommand) {
		this.stopCommand = stopCommand;
	}

	/**
	 * 执行播放的方法
	 */
	
	public void play(){
		playCommand.execute();
	}
	/**
	 * 执行倒带的方法
	 */
	public void rewind(){
		rewindCommand.execute();
	}
	/**
	 * 执行播放的方法
	 */
	public void stop(){
		stopCommand.execute();
	}
	
	
	

}
