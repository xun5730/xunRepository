package designPatternDemo.工厂模式demo.factoryExampleDemo2Standard;

import java.util.HashMap;
import java.util.Map;

public class MyMessageFactory implements IMyMessageFacotory {

	@Override
	public IMyMessage createMessage(String messageType) {
	       // 这里的方式是：消费者知道自己想要什么产品；若生产何种产品完全由工厂决定，则这里不应该传入控制生产的参数。  
		
		IMyMessage iMyMessage;
		Map<String,Object> messageParameter=new HashMap<String,Object>();
		 // 根据某些条件去选择究竟创建哪一个具体的实现对象，条件可以传入的，也可以从其它途径获取。
		//sms
		if("SMS".equals(messageType)){
			iMyMessage=new MyMessageSms();
			messageParameter.put("PHONENUM", "123456789");
		}else if("OA".equals(messageType)){
			//OA待办
			iMyMessage=new MyMessageOaToDo();
			messageParameter.put("OAUSERNAME", "testUser");
			
		}else{
			iMyMessage= new MyMessageEmail();
			messageParameter.put("EMAIL", "test@test.com");
			
		}
		iMyMessage.setMessageParam(messageParameter);
		return iMyMessage;
	}

}
