package designPatternDemo.动态代理Demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	
	private Object object;
	public MyInvocationHandler(Object object){
		this.object=object;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("发现方法"+method.getName());
		
		if(method.getName().equals("sayHello") ||method.getName().equals("queryAopDemo")){
			
			System.out.println("前置逻辑");
			//参数 
                if(args!=null&& args.length>0){
                	for(Object arg:args){
    					System.out.println("参数有那些------->>"+arg);
    				}
                	
                }			    
			 Object returnObj=	method.invoke(object, args);
			 if(returnObj!=null){
		     System.out.println("后置逻辑"+returnObj.toString());
			 }
		}
		
		return null;
	}

}
