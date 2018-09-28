package threadDemo.master_work模式;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	
	
	//1��һ��ʢ�����������
	private ConcurrentLinkedQueue<Task>  workQueue=new ConcurrentLinkedQueue<Task>();
	
	//2��Ҫ��һ��ʢ��worker�ļ���
	private HashMap<String,Thread> workers=new HashMap<String,Thread>();
	//3��Ҫһ��һ��ʢ��ûһ��workerִ������Ľ������
	private ConcurrentHashMap<String,Object> resultMap=new ConcurrentHashMap<String,Object>();
	//4���췽��
	public Master(Worker worker ,int workerCount){
		worker.setResultMap(this.resultMap);
		worker.setWorkQueue(this.workQueue);
		
		for(int i=0;i<workerCount;i++){
			this.workers.put(Integer.toString(i), new Thread(worker));
		}
		
	}
	//5��Ҫһ���ύ����ķ���
	public void submit(Task task){
		this.workQueue.add(task);
	}
	//6��Ҫ��һ��ִ�еķ������������е�worker����ȥִ������
	public void execute(){
		for(Map.Entry<String, Thread> me: workers.entrySet()  ){
			me.getValue().start();
		}
	}
	//7�ж��Ƿ����н����ķ���
	public boolean isComplete(){
		for(Map.Entry<String, Thread> me:workers.entrySet()){
			if(me.getValue().getState()!=Thread.State.TERMINATED){
				return false;
			}
		}
		return true;
	}
	//8����������
	public int getResult(){
		int priceResult=0;
		for(Map.Entry<String, Object> me: resultMap.entrySet()){
			priceResult+=(Integer)me.getValue();
		}
		return priceResult;
	}
	

}
