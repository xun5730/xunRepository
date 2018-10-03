package threadDemo.future原理模拟;


public class QiDongDemo {
	
	public static void main(String[] args) {
		FutureClient fc=new FutureClient();
		
		 Data data=   fc.request("����");
		System.out.println("�����ͳɹ�");
		System.out.println("������������������顣�����߼�");
		String result=data.getRequest();

		System.out.println(result);
		FutureClient fc2=new FutureClient();
		Data data2=   fc2.request("����");
		
		String result2=   data2.getRequest();
		System.out.println(result2);
		
		
		
		
	}
	
	

}
