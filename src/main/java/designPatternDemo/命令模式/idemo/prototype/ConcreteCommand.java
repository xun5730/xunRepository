package designPatternDemo.命令模式.idemo.prototype;

public class ConcreteCommand  implements Command{

	//持有响应的接收者对象
	
	private Receiver receiver=null;
	
	
	public ConcreteCommand(Receiver receiver){
		this.receiver=receiver;
	}
	
	@Override
	public void execute() {
		//通常会转调用接收者的响应方法，让接收者来真正执行功能
		receiver.action();
	}

}
