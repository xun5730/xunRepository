package designPatternDemo.工厂模式demo.factoryExampleDemo2Standard;

public class MyMessageOaToDo extends MyAbstractMessage {

	@Override
	public void sendMessage() throws Exception {
		
		if(null==getMessageParam()||null==getMessageParam().get("OAUSERNAME")||"".equals(getMessageParam().get("OAUSERNAME")) ){
			
			throw new Exception("发送OA待办,需要传入OAUSERNAME参数");
			
		}
		System.out.println("我是OA待办，发送通知给"+getMessageParam().get("OAUSERNAME"));
		
	}

	
	
}
