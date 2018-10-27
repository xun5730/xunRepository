package threadDemo.future原理模拟;


public class FutureData implements Data {

	private RealData realData;
	private boolean  isReady=false;
	
	
	public synchronized void setRealData(RealData realData  ){
		//如果一家装载完毕了，就直接返回
		if(isReady){
			return ;
		}
		this.realData=realData;
		isReady=true;
		this.notify();
	}
	
	
	@Override
	public synchronized  String getRequest() {
		//如果没装载好 程序就一直处于阻塞状态
		while(!isReady){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//装载好直接获取的数据即可
		return this.realData.getRequest();
	}

}
