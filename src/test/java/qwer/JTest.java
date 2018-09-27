package qwer;

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

	
	
	
}
