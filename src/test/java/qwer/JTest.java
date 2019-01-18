package qwer;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.entity.Asdf;
import com.demo.service.AsdfService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class JTest {

	
	
	/**工厂模式
	 * https://www.cnblogs.com/java-my-life/archive/2012/03/28/2418836.html
	 * 
	 * Mybatis源码解读-设计模式总结
	 * http://www.crazyant.net/2022.html
	 * https://blog.csdn.net/Dwade_mia/article/details/78883045
	 * https://www.cnblogs.com/baizhanshi/p/6187537.html
	 * https://www.cnblogs.com/java-my-life/archive/2012/06/08/2538146.html
	 https://www.cnblogs.com/V1haoge/p/6489827.html
	 */
	
	
	/**
	 * 迭代器模式
	 * http://www.cnblogs.com/java-my-life/archive/2012/05/22/2511506.html
	 * 
	 * 责任链模式
	 * https://www.cnblogs.com/ysw-go/p/5432921.html
	 * https://www.cnblogs.com/java-my-life/archive/2012/05/28/2516865.html
	 * https://www.cnblogs.com/java-my-life/archive/2012/05/28/2516865.html
	 * https://www.cnblogs.com/ysw-go/p/5432921.html
	 * 
	 */
	
	/**
	 * 设计模式 和jvm虚拟机学习资料
	 * https://www.cnblogs.com/java-my-life/archive/2012/06/01/2526972.html
	 */
	/**
	 * redis学习资料
	 * http://www.cnblogs.com/EasonJim/p/7803067.html#autoid-2-6-0
	 * https://blog.csdn.net/bcqtt/article/details/72286359
	 * https://www.cnblogs.com/red-code/p/6657517.html
	 * https://www.cnblogs.com/edwinchen/p/3816938.html
	 */
	
	/**
	 *  redis ��zset�� 10W���������������������ʧ�ܹ���
	 * http://www.importnew.com/7099.html#comment-668384
	 * http://www.importnew.com/26461.html#comment-668381
	 * http://www.importnew.com/7099.html#comment-668384
	 * 
	 */
	
	
	/**rocketMQ
	 * http://www.iocoder.cn/categories/RocketMQ/?cnblog
	 */
	/*算法学习资料
	 * https://blog.csdn.net/xiazdong/article/details/8462393?utm_source=blogkpcl10
	 * 
	 */
	/*
	 * 
	 * CountDownLatch学习资料
	 * http://www.importnew.com/15731.html
	 */
	
	/*
	 * https://blog.csdn.net/d1562901685/article/details/54881862
	 * while(jedis.setnx(lock, now+��ʱʱ��)==0��{
	    if(now>jedis.get(lock) && now>jedis.getset(lock, now+��ʱʱ��)){
	        break;
	    }else{
	        Thread.sleep(300);
	    }
	}
	ִ��ҵ�����;
	jedis.del(lock);*/
	
	
	
	
	
	
	/**
	 * 
	 * 浏览器的书签保存
	 * https://blog.csdn.net/kleguan/article/details/73440777
	 * https://www.cnblogs.com/fangjian0423/p/springMVC-directory-summary.html
	 * http://www.cnblogs.com/heavenyes/p/3905844.html
	 * https://www.cnblogs.com/eastday/p/8124580.html
	 * https://www.cnblogs.com/java1024/p/8556519.html
	 * https://blog.csdn.net/dream_broken/article/details/72911148
	 * https://www.cnblogs.com/lanhzbupt/p/6346680.html
	 * https://blog.csdn.net/fumushan/article/details/80090947
	 * http://www.importnew.com/15731.html
	 * https://blog.csdn.net/wendingzhulu/article/details/52708472
	 * https://www.cnblogs.com/xudong-bupt/p/3433643.html
	 * https://gitee.com/1028125449/miaosha
	 * https://gitee.com/shuzheng/zheng
	 * https://github.com/CyC2018/CS-Notes
	 * http://www.crazyant.net/2022.html
	 * https://gitee.com/duxiaod/irs-maven
	 * http://www.imooc.com/learn/632
	 */
	@Autowired
	public AsdfService asdfService;

	/* public SqlSessionTemplate batchSqlSessionTemplate ; */
	@Test
	public void getAsdf() {

		List<Asdf> list = asdfService.findAsdf();
		System.out.println(list);
		for (Asdf a : list) {
			System.out.println(a.getName());
		}

	}

	public void insertAopDemo() {
		
		Integer i = asdfService.insertAopDemo();
		System.out.println(i);
	}

	@Test
	public void plusValidSetPeriod(){
		asdfService.plusValidSetPeriod();
	}
	@Test
	public void plusValidAddPeriod(){
		asdfService.plusValidAddPeriod();
	}
	@Test
	public void investLoan(){
		asdfService.investLoan();
	}
	
	@Test
	public void asdfasdf(){
		asdfService.c1();
	}
	
	
	
	@Test
	public void qiang() {
		ExecutorService es = Executors.newFixedThreadPool(10);

		Runnable r1 = new Runnable() {

			public void run() {
				asdfService.c1();
			}
		};
		Runnable r2 = new Runnable() {

			public void run() {
				asdfService.c1();
			}
		};
		Runnable r3 = new Runnable() {

			public void run() {
				asdfService.c1();
			}
		};
		Runnable r4 = new Runnable() {

			public void run() {
				asdfService.c1();
			}
		};
		Runnable r5 = new Runnable() {

			public void run() {
				asdfService.c1();
			}
		};
		Runnable r6 = new Runnable() {

			public void run() {
				asdfService.c1();
			}
		};
		Runnable r7 = new Runnable() {

			public void run() {
				asdfService.c1();
			}
		};
		Runnable r8 = new Runnable() {

			public void run() {
				asdfService.c1();
			}
		};
		Runnable r9 = new Runnable() {

			public void run() {
				asdfService.c1();
			}
		};
		Runnable r10 = new Runnable() {

			public void run() {
				asdfService.c1();
			}
		};
		
		
		
		
		es.execute(r1);//r1
		es.execute(r2);//
		es.execute(r3);
		es.execute(r4);
		es.execute(r5);
		es.execute(r6);
		es.execute(r7);
		es.execute(r8);
		es.execute(r9);
		es.execute(r10);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		es.shutdown();
		System.out.println("�ر������");

	}


	public static void main(String[] args) {
		BigDecimal startMoney=new BigDecimal("4000");
		for(int i=0;i<10;i++){
			startMoney= startMoney.add( startMoney.multiply(new BigDecimal("0.04")));
		}
		System.out.println(startMoney);
	}
	
	
	
}
