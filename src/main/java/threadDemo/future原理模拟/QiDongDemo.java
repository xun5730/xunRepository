package threadDemo.future原理模拟;

public class QiDongDemo {
	
	public static void main(String[] args) {
		FutureClient fc=new FutureClient();
		
		 Data data=   fc.request("地球");
		System.out.println("请求发送成功");
		System.out.println("这里可以做其他的事情。属性逻辑");
		String result=data.getRequest();

		System.out.println(result);
		FutureClient fc2=new FutureClient();
		Data data2=   fc2.request("月球");
		
		String result2=   data2.getRequest();
		System.out.println(result2);
		
		
		
		
	}
	
	

}
