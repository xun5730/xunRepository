package designPatternDemo.工厂模式demo.factoryExampleDemo2Standard;

import java.util.Map;

public interface IMyMessage {
	public Map<String,Object> getMessageParam();
	public void setMessageParam(Map<String,Object> messageParam);
	public void sendMessage() throws Exception;//发送通知/消息
	

}
