package designPatternDemo.责任链模式.idemo2;

public abstract class Handler {

	/**
	 * 持有下一个处理请求的对象
	 */
	protected Handler successor=null;

	/**
     * 取值方法
     */
	public Handler getSuccessor() {
		return successor;
	}

	 /**
     * 设置下一个处理请求的对象
     */
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	
	public abstract String handleFeeRequest(String user ,Double fee);
	
	
	
}
