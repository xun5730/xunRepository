package threadDemo.futureԭ��ģ��;

public class RealData implements Data {

	private String result;

	@Override
	public String getRequest() {
		return result;
	}
	public RealData(String queryStr){
		System.out.println("��ѯ"+queryStr+"���в�ѯ������һ���ܺ�ʱ�Ĳ���...");
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("������ϣ���ȡ���");
		result= "��ѯ���:"+queryStr+"��Բ��";
		
		
	}
	 
	

}
