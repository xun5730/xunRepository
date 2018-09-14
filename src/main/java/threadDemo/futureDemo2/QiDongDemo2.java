package threadDemo.futureDemo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;






public class QiDongDemo2 {
	
/**
 * 
 * 
 * 
 * 
 * 	转载http://www.cnblogs.com/dolphin0520/p/3949310.html
	先说一下java.lang.Runnable吧，它是一个接口，在它里面只声明了一个run()方法：
	public interface Runnable {
	    public abstract void run();
	}
由于run()方法返回值为void类型，所以在执行完任务之后无法返回任何结果。

Callable位于java.util.concurrent包下，它也是一个接口，在它里面也只声明了一个方法，只不过这个方法叫做call()：
public interface Callable<V> {
    
    V call() throws Exception;
}
可以看到，这是一个泛型接口，call()函数返回的类型就是传递进来的V类型。

那么怎么使用Callable呢？一般情况下是配合ExecutorService来使用的，在ExecutorService接口中声明了若干个submit方法的重载版本

<T> Future<T> submit(Callable<T> task);
<T> Future<T> submit(Runnable task, T result);
Future<?> submit(Runnable task);
第一个submit方法里面的参数类型就是Callable。

暂时只需要知道Callable一般是和ExecutorService配合来使用的，具体的使用方法讲在后面讲述。

一般情况下我们使用第一个submit方法和第三个submit方法，第二个submit方法很少使用。

Future就是对于具体的Runnable或者Callable任务的执行结果进行取消、查询是否完成、获取结果。必要时可以通过get方法获取执行结果，该方法会阻塞直到任务返回结果。

Future类位于java.util.concurrent包下，它是一个接口：
public interface Future<V> {
    boolean cancel(boolean mayInterruptIfRunning);
    boolean isCancelled();
    boolean isDone();
    V get() throws InterruptedException, ExecutionException;
    V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}
在Future接口中声明了5个方法，下面依次解释每个方法的作用：

cancel方法用来取消任务，如果取消任务成功则返回true，如果取消任务失败则返回false。参数mayInterruptIfRunning表示是否允许取消正在执行却没有执行完毕的任务，如果设置true，则表示可以取消正在执行过程中的任务。如果任务已经完成，则无论mayInterruptIfRunning为true还是false，此方法肯定返回false，即如果取消已经完成的任务会返回false；如果任务正在执行，若mayInterruptIfRunning设置为true，则返回true，若mayInterruptIfRunning设置为false，则返回false；如果任务还没有执行，则无论mayInterruptIfRunning为true还是false，肯定返回true。
isCancelled方法表示任务是否被取消成功，如果在任务正常完成前被取消成功，则返回 true。
isDone方法表示任务是否已经完成，若任务完成，则返回true；
get()方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回；
get(long timeout, TimeUnit unit)用来获取执行结果，如果在指定时间内，还没获取到结果，就直接返回null。
　　也就是说Future提供了三种功能：

　　1）判断任务是否完成；

　　2）能够中断任务；

　　3）能够获取任务执行结果。

　　因为Future只是一个接口，所以是无法直接用来创建对象使用的，因此就有了下面的FutureTask。*/
	
	public static void main(String[] args) {
//		1使用Callable+Future获取执行结果
		/*ExecutorService executor=Executors.newFixedThreadPool(2);
		TaskDemo2 task=new TaskDemo2(100);
		Future<Integer> result=    executor.submit(task);
		TaskDemo2 task2=new TaskDemo2(1000);
		Future<Integer> result2=    executor.submit(task2);
		executor.shutdown();*/
		
		
		//2使用Callable+FutureTask获取执行结果
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
		System.out.println("主线程在执行任务");
		
		try {
//			1使用Callable+Future获取执行结果
//			System.out.println("task运行结果"+result.get());
//			System.out.println("task运行结果"+result2.get());
			
			//2使用Callable+FutureTask获取执行结果
			System.out.println(futureTask.get());
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("所有任务执行完毕");
		
		
		
	}

}
