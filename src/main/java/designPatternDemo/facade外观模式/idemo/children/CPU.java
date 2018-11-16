package designPatternDemo.facade外观模式.idemo.children;

import org.apache.log4j.Logger;

/**
 * cpu 子系统类
 * @author 刘源
 *
 */
public class CPU {
	
	public static final Logger logger=Logger.getLogger(CPU.class);
	
	public void start(){
		logger.info("cpu is strat");
	}
	public void shutDown(){
		
		logger.info("cpu is shutDown");
	}
	

}
