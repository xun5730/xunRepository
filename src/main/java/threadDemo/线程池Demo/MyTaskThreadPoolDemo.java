package threadDemo.线程池Demo;


public class MyTaskThreadPoolDemo implements Runnable {

	private int taskId;
	private String taskName;

	public MyTaskThreadPoolDemo(int taskId, String taskName) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		return "MyTaskThreadPoolDemo [taskId=" + taskId + ", taskName=" + taskName + "]";
	}

	@Override
	public void run() {
		System.out.println("run taskId="+this.taskId);
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
