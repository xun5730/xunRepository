package designPatternDemo.命令模式.idemo.audioPlayerDemo.macroCommand;

import java.util.ArrayList;
import java.util.List;

import designPatternDemo.命令模式.idemo.audioPlayerDemo.Command;

public interface MacroCommand extends Command {


	  /**
     * 宏命令聚集的管理方法
     * 可以添加一个成员命令
     */
	public void add(Command command);
	 /**
     * 宏命令聚集的管理方法
     * 可以删除一个成员命令
     */
	public void remove(Command command);
	
	
}
