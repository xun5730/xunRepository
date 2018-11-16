package designPatternDemo.facade外观模式.idemo;

import org.apache.log4j.Logger;

import designPatternDemo.facade外观模式.idemo.facade.Computer;

public class Client {

	
	/**
	 * 针对外观模式，在项目开发和实际运用中十分频繁，但是其极易理解，下面就简要介绍一下。

　　外观模式（Facade）,他隐藏了系统的复杂性，并向客户端提供了一个可以访问系统的接口。这种类型的设计模式属于结构性模式。为子系统中的一组接口提供了一个统一的访问接口，这个接口使得子系统更容易被访问或者使用
	 * 
	 * 
	 * 简单来说，该模式就是把一些复杂的流程封装成一个接口供给外部用户更简单的使用。这个模式中，设计到3个角色。

　　1）.门面角色：外观模式的核心。它被客户角色调用，它熟悉子系统的功能。内部根据客户角色的需求预定了几种功能的组合。

　　2）.子系统角色:实现了子系统的功能。它对客户角色和Facade时未知的。它内部可以有系统内的相互交互，也可以由供外界调用的接口。

　　3）.客户角色:通过调用Facede来完成要实现的功能。

　　使用场景：
　　1- 为复杂的模块或子系统提供外界访问的模块；

　　2- 子系统相互独立；

　　3- 在层析结构中，可以使用外观模式定义系统的每一层的入口。
	 */
	public static final Logger LOGGER = Logger.getLogger(Client.class);
	public static void main(String[] args) {
		
		
		Computer computer = new Computer();
		  computer.strat();
		     LOGGER.info("=================");
		   computer.shutDown();

	}
}
