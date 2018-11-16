package designPatternDemo.命令模式.idemo.audioPlayerDemo.macroCommand;

import java.util.ArrayList;
import java.util.List;

import designPatternDemo.命令模式.idemo.audioPlayerDemo.Command;

public class MacroAudioCommand implements MacroCommand {

	private List<Command> commandList=new ArrayList<Command>();
	
	
	  /**
     * 执行方法
     */
	@Override
	public void execute() {
		for(Command command:commandList){
			command.execute();
		}
	}

	 /**
     * 宏命令聚集管理方法
     */
	@Override
	public void add(Command command) {
		commandList.add(command);
	}

	  /**
     * 宏命令聚集管理方法
     */
	@Override
	public void remove(Command command) {
		commandList.remove(command);
		
	}

}
