package designPatternDemo.facade外观模式.idemo.children;

import org.apache.log4j.Logger;

/**
 * disk子系统类
 * @author 刘源
 *
 */
public class Disk {

	public static final Logger logger=Logger.getLogger(Disk.class);
	
	public void start(){
		logger.info("cpu is strat");
	}
	public void shutDown(){
		
		logger.info("cpu is shutDown");
	}
	
	
	
}
