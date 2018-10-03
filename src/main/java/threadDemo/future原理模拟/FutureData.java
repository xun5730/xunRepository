package threadDemo.future原理模拟;


public class FutureData implements Data {

	private RealData realData;
	private boolean  isReady=false;
	
	
	public synchronized void setRealData(RealData realData  ){
		//���һ��װ������ˣ���ֱ�ӷ���
		if(isReady){
			return ;
		}
		this.realData=realData;
		isReady=true;
		this.notify();
	}
	
	
	@Override
	public synchronized  String getRequest() {
		//���ûװ�غ� �����һֱ��������״̬
		while(!isReady){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//װ�غ�ֱ�ӻ�ȡ�����ݼ���
		return this.realData.getRequest();
	}

}
