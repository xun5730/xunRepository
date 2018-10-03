package threadDemo.master_work模式;


import java.util.Random;

/**
 * 
 * @author xun
 * 
 * Master-Workerģʽ�ǳ��õĲ���ģʽ֮һ�����ĺ���˼���ǣ�
 * ϵͳ���������Эͬ��������Master���̺�Worker���̣�
 * Master������պͷ�������Wroker������������
 * ������Worker���̽�����������ɺ󣬽�������ظ�Master���̣���Master���̽��л���
 * ���Ӷ��õ����յĽ��������崦���������ͼ��ʾ��
 *
 */
public class QiDongMasterWoker {
	
	public static void main(String[] args) {
		
		Master master=new Master(new Worker(),20);
		Random r=new Random();
		for(int i=0;i<1000;i++){
			Task t=new Task();
			t.setId(i);
			t.setPrice(r.nextInt(1000));
			master.submit(t);
		}
		
		master.execute();
		long start =System.currentTimeMillis();
		while(true){
			if(master.isComplete()){
				long end=System.currentTimeMillis()-start;
				int priceResult=master.getResult();
				System.out.println("���ս����"+priceResult+",ִ��ʱ�� : "+end);
				break;
			}
			
		}
		
		
		
		
		
		/*long start =System.currentTimeMillis();
		Random r=new Random();
		Integer resultInteger=0;
		for(int i=0;i<999999999;i++){
			resultInteger+=r.nextInt(1000);
		}
		long end=System.currentTimeMillis()-start;
		System.out.println("���ս����"+resultInteger+",ִ��ʱ�� : "+end);
		*/
		
	}
	
	
	

}
