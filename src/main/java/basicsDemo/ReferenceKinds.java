package basicsDemo;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceKinds {
	
	
	/**
	 * 引用、软引用、弱引用、虚引用的概念
	 * @param args
	 */
	public static void main(String[] args) {
		
		
//		new ReferenceKinds().stringReference();
//		new ReferenceKinds().softReference();
		new ReferenceKinds().weakRefrernce();
		
		
	}
	
	/**
	 * 强引用就是指在程序代码之中普遍存在的
	 * 只要某个对象有强引用与之关联，JVM必定不会回收这个对象，即使在内存不足的情况下，
	 * JVM宁愿抛出OutOfMemory错误也不会回收这种对象。
	 */
	 public void stringReference(){
		
		Object object=new Object();
		Object objArr=new Object[1000];
		/*当运行至Object[] objArr = new Object[1000];这句时，如果内存不足，JVM会抛出OOM错误也不会回收object指向的对象。不过要注意的是，当fun1运行完之后，object和objArr都已经不存在了，所以它们指向的对象都会被JVM回收。

		如果想中断强引用和某个对象之间的关联，可以显示地将引用赋值为null，这样一来的话，JVM在合适的时间就会回收该对象。*/
		
	}
	 /**
	  * 软引用是用来描述一些有用但并不是必需的对象，在Java中用java.lang.ref.SoftReference类来表示。
	  * 对于软引用关联着的对象，只有在内存不足的时候JVM才会回收该对象。
	  * 因此，这一点可以很好地用来解决OOM的问题，并且这个特性很适合用来实现缓存：比如网页缓存、图片缓存等。
	  * 
	  */
	 public void softReference(){
		 SoftReference<String> sr=new SoftReference<String>(new String("hello"));
		 System.out.println(sr.get());
		 System.gc();//通知JVM的gc进行垃圾回收
		 System.out.println(sr.get());
	 }
	/**
	 * 弱引用也是用来描述非必需对象的，当JVM进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象。
	 * 在java中，用java.lang.ref.WeakReference类来表示。下面是使用示例：
	 */
	 public void weakRefrernce(){
		 WeakReference<String> wr=new WeakReference<String>(new String("hello"));
		 
		 System.out.println(wr.get());
		 try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         System.gc();
         System.out.println(wr.get());
		 
	 }
	 
	

}
