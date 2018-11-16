package designPatternDemo.facade外观模式.idemo.children;

import org.apache.log4j.Logger;
/**
 * Memory子系统类
 * @xun
 *
 */
public class Memory {

	
	public static final Logger logger=Logger.getLogger(Disk.class);
	
	public void start(){
		logger.info("Memory is strat");
	}
	public void shutDown(){
		
		logger.info("Memory is shutDown");
	}
}
