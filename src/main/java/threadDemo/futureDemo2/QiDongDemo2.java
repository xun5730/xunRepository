package threadDemo.futureDemo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;






public class QiDongDemo2 {
	
/**
 * 
 * 
 * 
 * 
 * 	ת��http://www.cnblogs.com/dolphin0520/p/3949310.html
	��˵һ��java.lang.Runnable�ɣ�����һ���ӿڣ���������ֻ������һ��run()������
	public interface Runnable {
	    public abstract void run();
	}
����run()��������ֵΪvoid���ͣ�������ִ��������֮���޷������κν����

Callableλ��java.util.concurrent���£���Ҳ��һ���ӿڣ���������Ҳֻ������һ��������ֻ���������������call()��
public interface Callable<V> {
    
    V call() throws Exception;
}
���Կ���������һ�����ͽӿڣ�call()�������ص����;��Ǵ��ݽ�����V���͡�

��ô��ôʹ��Callable�أ�һ������������ExecutorService��ʹ�õģ���ExecutorService�ӿ������������ɸ�submit���������ذ汾

<T> Future<T> submit(Callable<T> task);
<T> Future<T> submit(Runnable task, T result);
Future<?> submit(Runnable task);
��һ��submit��������Ĳ������;���Callable��

��ʱֻ��Ҫ֪��Callableһ���Ǻ�ExecutorService�����ʹ�õģ������ʹ�÷������ں��潲����

һ�����������ʹ�õ�һ��submit�����͵�����submit�������ڶ���submit��������ʹ�á�

Future���Ƕ��ھ����Runnable����Callable�����ִ�н������ȡ������ѯ�Ƿ���ɡ���ȡ�������Ҫʱ����ͨ��get������ȡִ�н�����÷���������ֱ�����񷵻ؽ����

Future��λ��java.util.concurrent���£�����һ���ӿڣ�
public interface Future<V> {
    boolean cancel(boolean mayInterruptIfRunning);
    boolean isCancelled();
    boolean isDone();
    V get() throws InterruptedException, ExecutionException;
    V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}
��Future�ӿ���������5���������������ν���ÿ�����������ã�

cancel��������ȡ���������ȡ������ɹ��򷵻�true�����ȡ������ʧ���򷵻�false������mayInterruptIfRunning��ʾ�Ƿ�����ȡ������ִ��ȴû��ִ����ϵ������������true�����ʾ����ȡ������ִ�й����е�������������Ѿ���ɣ�������mayInterruptIfRunningΪtrue����false���˷����϶�����false�������ȡ���Ѿ���ɵ�����᷵��false�������������ִ�У���mayInterruptIfRunning����Ϊtrue���򷵻�true����mayInterruptIfRunning����Ϊfalse���򷵻�false���������û��ִ�У�������mayInterruptIfRunningΪtrue����false���϶�����true��
isCancelled������ʾ�����Ƿ�ȡ���ɹ�������������������ǰ��ȡ���ɹ����򷵻� true��
isDone������ʾ�����Ƿ��Ѿ���ɣ���������ɣ��򷵻�true��
get()����������ȡִ�н������������������������һֱ�ȵ�����ִ����ϲŷ��أ�
get(long timeout, TimeUnit unit)������ȡִ�н���������ָ��ʱ���ڣ���û��ȡ���������ֱ�ӷ���null��
����Ҳ����˵Future�ṩ�����ֹ��ܣ�

����1���ж������Ƿ���ɣ�

����2���ܹ��ж�����

����3���ܹ���ȡ����ִ�н����

������ΪFutureֻ��һ���ӿڣ��������޷�ֱ��������������ʹ�õģ���˾����������FutureTask��*/
	
	public static void main(String[] args) {
//		1ʹ��Callable+Future��ȡִ�н��
		/*ExecutorService executor=Executors.newFixedThreadPool(2);
		TaskDemo2 task=new TaskDemo2(100);
		Future<Integer> result=    executor.submit(task);
		TaskDemo2 task2=new TaskDemo2(1000);
		Future<Integer> result2=    executor.submit(task2);
		executor.shutdown();*/
		
		
		//2ʹ��Callable+FutureTask��ȡִ�н��
		  TaskDemo2 task3=new TaskDemo2(10000);
		  FutureTask<Integer> futureTask=new FutureTask<Integer>(task3);
		  Thread thread=new Thread(futureTask);  
		  thread.start();
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("���߳���ִ������");
		
		try {
//			1ʹ��Callable+Future��ȡִ�н��
//			System.out.println("task���н��"+result.get());
//			System.out.println("task���н��"+result2.get());
			
			//2ʹ��Callable+FutureTask��ȡִ�н��
			System.out.println(futureTask.get());
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��������ִ�����");
		
		
		
	}

}
