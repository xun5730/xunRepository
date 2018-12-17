package threadDemo.master_work模式;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {

	private ConcurrentLinkedQueue<Task> workQueue;
	private ConcurrentHashMap<String,Object> resultMap;
	
	public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue  ){
		this.workQueue=workQueue;
		
	}
	
	public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}


	@Override
	public void run() {
		while(true){
			Task input=  this.workQueue.poll();
			if(input==null){
				break;
			}else{
			    Object output= handle(input);
			    this.resultMap.put(Integer.toString(input.getId()), output);
			    
			}
			
		}
		
	}

	private Object handle(Task input) {
		
		Object output=null;
		//处理任务的耗时，比如说进行操作数据库
		try {
			Thread.sleep(5000);
			output=input.getPrice();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

}
