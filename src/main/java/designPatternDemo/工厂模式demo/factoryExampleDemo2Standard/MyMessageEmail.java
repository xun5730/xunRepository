package designPatternDemo.工厂模式demo.factoryExampleDemo2Standard;

public class MyMessageEmail extends MyAbstractMessage {

	@Override
	public void sendMessage() throws Exception {
		
		if(null==getMessageParam()||null==getMessageParam().get("EMAIL")||"".equals(getMessageParam().get("EMAIL")) ){
			
			throw new Exception("发送email待办,需要传入EMAIL参数");
			
		}
		System.out.println("我是短信，发送通知给"+getMessageParam().get("EMAIL"));
		
	}

	
	
}
