package designPatternDemo.facade外观模式.idemo.facade;

import org.apache.log4j.Logger;

import designPatternDemo.facade外观模式.idemo.children.CPU;
import designPatternDemo.facade外观模式.idemo.children.Disk;
import designPatternDemo.facade外观模式.idemo.children.Memory;

/**
 * 门面类（核心）
 * @author xun
 *
 */
public class Computer {
	
	public static final Logger logger=Logger.getLogger(Computer.class);
	
	private CPU cpu;
	private Memory memory;
	private Disk disk;
	
	public Computer(){
		
		cpu=new CPU();
		memory=new Memory();
		disk=new Disk();
	}
	public void strat(){
		logger.info("computer start begin");
		
		cpu.start();
		disk.start();
		memory.start();
		logger.info("computer start end");
		
	}
	public void shutDown(){
		
        logger.info("computer shutDown begin");
		cpu.shutDown();
		disk.shutDown();
		memory.shutDown();
		logger.info("computer shutDown end");
		
	}
	
	
	
	
	
	
	

}
