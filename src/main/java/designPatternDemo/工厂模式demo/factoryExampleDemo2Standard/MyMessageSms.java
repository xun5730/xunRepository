package designPatternDemo.工厂模式demo.factoryExampleDemo2Standard;

public class MyMessageSms extends MyAbstractMessage {

	@Override
	public void sendMessage() throws Exception {
		
		if(null==getMessageParam()||null==getMessageParam().get("PHONENUM")||"".equals(getMessageParam().get("PHONENUM")) ){
			
			throw new Exception("发送OA待办,需要传入PHONENUM参数");
			
		}
		System.out.println("我是短信，发送通知给"+getMessageParam().get("PHONENUM"));
		
	}

	
	
}
