package threadDemo.线程池Demo;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UserThreadPoolExecutor1 {
	public static void main(String[] args) {
		
		
	/*	ThreadPoolExecutor的策略

		上面介绍参数的时候其实已经说到了ThreadPoolExecutor执行的策略，这里给总结一下，当一个任务被添加进线程池时：

		    线程数量未达到corePoolSize，则新建一个线程(核心线程)执行任务
		    线程数量达到了corePools，则将任务移入队列等待
		    队列已满，新建线程(非核心线程)执行任务
		    队列已满，总线程数又达到了maximumPoolSize，就会由上面那位星期天(RejectedExecutionHandler)抛出异常

		作者：LiuZh_
		链接：https://www.jianshu.com/p/210eab345423
		來源：简书
		简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
		
		*常见四种线程池
CachedThreadPool()

可缓存线程池：

   1 线程数无限制
    2有空闲线程则复用空闲线程，若无空闲线程则新建线程
    3一定程序减少频繁创建/
	
	
	
	我知道你看到这些构造函数和我一样也是吓呆了，但其实一共就7种类型，理解起来简直和理解一周有7天一样简单，而且一周有两天是周末，其实也就只有5天需要了解！相信我，毕竟扯皮，我比较擅长

    int corePoolSize => 该线程池中核心线程数最大值

        核心线程：

        线程池新建线程的时候，如果当前线程总数小于corePoolSize，则新建的是核心线程，如果超过corePoolSize，则新建的是非核心线程

        核心线程默认情况下会一直存活在线程池中，即使这个核心线程啥也不干(闲置状态)。

        如果指定ThreadPoolExecutor的allowCoreThreadTimeOut这个属性为true，那么核心线程如果不干活(闲置状态)的话，超过一定时间(时长下面参数决定)，就会被销毁掉

        很好理解吧，正常情况下你不干活我也养你，因为我总有用到你的时候，但有时候特殊情况(比如我自己都养不起了)，那你不干活我就要把你干掉了

    int maximumPoolSize

        该线程池中线程总数最大值

        线程总数 = 核心线程数 + 非核心线程数。核心线程在上面解释过了，这里说下非核心线程：

        不是核心线程的线程(别激动，把刀放下...)，其实在上面解释过了

    long keepAliveTime

        该线程池中非核心线程闲置超时时长

        一个非核心线程，如果不干活(闲置状态)的时长超过这个参数所设定的时长，就会被销毁掉

        如果设置allowCoreThreadTimeOut = true，则会作用于核心线程

    TimeUnit unit

        keepAliveTime的单位，TimeUnit是一个枚举类型，其包括：
            NANOSECONDS ： 1微毫秒 = 1微秒 / 1000
            MICROSECONDS ： 1微秒 = 1毫秒 / 1000
            MILLISECONDS ： 1毫秒 = 1秒 /1000
            SECONDS ： 秒
            MINUTES ： 分
            HOURS ： 小时
            DAYS ： 天

    BlockingQueue<Runnable> workQueue

        该线程池中的任务队列：维护着等待执行的Runnable对象

        当所有的核心线程都在干活时，新添加的任务会被添加到这个队列中等待处理，如果队列满了，则新建非核心线程执行任务

        常用的workQueue类型：

            SynchronousQueue：这个队列接收到任务的时候，会直接提交给线程处理，而不保留它，如果所有线程都在工作怎么办？那就新建一个线程来处理这个任务！所以为了保证不出现<线程数达到了maximumPoolSize而不能新建线程>的错误，使用这个类型队列的时候，maximumPoolSize一般指定成Integer.MAX_VALUE，即无限大

            LinkedBlockingQueue：这个队列接收到任务的时候，如果当前线程数小于核心线程数，则新建线程(核心线程)处理任务；如果当前线程数等于核心线程数，则进入队列等待。由于这个队列没有最大值限制，即所有超过核心线程数的任务都将被添加到队列中，这也就导致了maximumPoolSize的设定失效，因为总线程数永远不会超过corePoolSize

            ArrayBlockingQueue：可以限定队列的长度，接收到任务的时候，如果没有达到corePoolSize的值，则新建线程(核心线程)执行任务，如果达到了，则入队等候，如果队列已满，则新建线程(非核心线程)执行任务，又如果总线程数到了maximumPoolSize，并且队列也满了，则发生错误

            DelayQueue：队列内元素必须实现Delayed接口，这就意味着你传进去的任务必须先实现Delayed接口。这个队列接收到任务时，首先先入队，只有达到了指定的延时时间，才会执行任务

    ThreadFactory threadFactory

        创建线程的方式，这是一个接口，你new他的时候需要实现他的Thread newThread(Runnable r)方法，一般用不上，这是星期六，休息

        但我还是说一句吧(把枪放下...)

        小伙伴应该知道AsyncTask是对线程池的封装吧？那就直接放一个AsyncTask新建线程池的threadFactory参数源码吧：

        new ThreadFactory() {
            private final AtomicInteger mCount = new AtomicInteger(1);
            
            public Thread new Thread(Runnable r) {
                return new Thread(r,"AsyncTask #" + mCount.getAndIncrement());
            }
        }


    RejectedExecutionHandler handler

        这玩意儿就是抛出异常专用的，比如上面提到的两个错误发生了，就会由这个handler抛出异常，你不指定他也有个默认的

        抛异常能抛出什么花样来？所以这个星期天不管了，一边去，根本用不上

新建一个线程池的时候，一般只用5个参数的构造函数。

。
创建方法：

ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

源码：
public static ExecutorService newCachedThreadPool() { 
return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
 }
 
 
 FixedThreadPool()

定长线程池：

    1可控制线程最大并发数（同时执行的线程数）
    2超出的线程会在队列中等待
	public static ExecutorService newFixedThreadPool(int nThreads) { 
	return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()); }


ScheduledThreadPool()
public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) { return new ScheduledThreadPoolExecutor(corePoolSize); } //ScheduledThreadPoolExecutor(): public ScheduledThreadPoolExecutor(int corePoolSize) { super(corePoolSize, Integer.MAX_VALUE, DEFAULT_KEEPALIVE_MILLIS, MILLISECONDS, new DelayedWorkQueue()); }


SingleThreadExecutor()
public static ExecutorService newSingleThreadExecutor() { return new FinalizableDelegatedExecutorService (new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>())); }


作者：LiuZh_
链接：https://www.jianshu.com/p/210eab345423
來源：简书
简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
		*
		*
		*
		*
		*
		*
		*
		*
		*
		*
		*
		*
		*/
		
		
		ThreadPoolExecutor pool =
				new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2));
//		new ThreadPoolExecutor(6, 6, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
//		new ThreadPoolExecutor(3, 6, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
//		new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(2));
		
		MyTaskThreadPoolDemo t1=new MyTaskThreadPoolDemo(1, "����1");
		MyTaskThreadPoolDemo t2=new MyTaskThreadPoolDemo(2, "����2");
		MyTaskThreadPoolDemo t3=new MyTaskThreadPoolDemo(3, "����3");
		MyTaskThreadPoolDemo t4=new MyTaskThreadPoolDemo(4, "����4");
		MyTaskThreadPoolDemo t5=new MyTaskThreadPoolDemo(5, "����5");
		MyTaskThreadPoolDemo t6=new MyTaskThreadPoolDemo(6, "����6");
		
		
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
//		pool.execute(t6);
		
		
		

		/*pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		System.out.println("---�ȿ�����---");
		System.out.println("�����߳���" + pool.getCorePoolSize());
		System.out.println("�̳߳���" + pool.getPoolSize());
		System.out.println("����������" + pool.getQueue().size());*/
	
/*		try {
			Thread.currentThread().sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
//		pool.execute(t4);
//		pool.execute(t5);
//		pool.execute(t6);
/*		System.out.println("---�ڿ�����---");
		System.out.println("�����߳���" + pool.getCorePoolSize());
		System.out.println("�̳߳���" + pool.getPoolSize());
		System.out.println("����������" + pool.getQueue().size());
		try {
			Thread.currentThread().sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----8��֮��----");
		System.out.println("�����߳���" + pool.getCorePoolSize());
		System.out.println("�̳߳���" + pool.getPoolSize());
		System.out.println("����������" + pool.getQueue().size());*/
	    pool.shutdown();	
		
		
	}

}
