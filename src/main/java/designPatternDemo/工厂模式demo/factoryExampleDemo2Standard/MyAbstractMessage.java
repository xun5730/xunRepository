package designPatternDemo.工厂模式demo.factoryExampleDemo2Standard;

import java.util.Map;

public class MyAbstractMessage implements IMyMessage {

	private Map<String,Object> messageParam;
	// 这里可以理解为生产产品所需要的原材料库。最好是个自定义的对象，这里为了不引起误解使用Map。  
	
	
	
	
	








	public Map<String, Object> getMessageParam() {
		return messageParam;
	}






	public void setMessageParam(Map<String, Object> messageParam) {
		this.messageParam = messageParam;
	}






	@Override
	public void sendMessage() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
