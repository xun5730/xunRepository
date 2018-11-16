package designPatternDemo.命令模式.idemo.audioPlayerDemo;

public class Julia {
	/**
	 * 
	 * 
	 * 　小女孩茱丽(Julia)有一个盒式录音机，此录音机有播音(Play)、倒带(Rewind)和停止(Stop)功能，录音机的键盘便是请求者(Invoker)角色；茱丽(Julia)是客户端角色，而录音机便是接收者角色。Command类扮演抽象命令角色，而PlayCommand、StopCommand和RewindCommand便是具体命令类。茱丽(Julia)不需要知道播音(play)、倒带(rewind)和停止(stop)功能是怎么具体执行的，这些命令执行的细节全都由键盘(Keypad)具体实施。茱丽(Julia)只需要在键盘上按下相应的键便可以了。

　　录音机是典型的命令模式。录音机按键把客户端与录音机的操作细节分割开来。
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
		
		
		
		
		//创建请求对象
		KeyPad keypad=new KeyPad();
		
		keypad.setPlayCommand(playCommand);
		keypad.setRewindCommand(rewindCommand);
		keypad.setStopCommand(stopCommand);
		//测试
		
		keypad.play();
		keypad.rewind();
		keypad.stop();
		keypad.play();
		keypad.stop();
		
		
	}

}
