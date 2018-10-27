package com.demo.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.demo.common.SpringContextUtil;
import com.demo.entity.User;

public class InsertUserThreadDemo   implements Runnable{

	private static final Log log = LogFactory.getLog(InsertUserThreadDemo.class);
	private List<User> list;
	
	
	
	

	





	@Override
	public void run() {

	
		
		SqlSessionFactory sqlSessionFactory=   SpringContextUtil.getBean("sqlSessionFactory");

		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession(ExecutorType.BATCH,false);
			/**
			 * changeNumber返回是负数并不是影响行数，原因是？
			 * 答案：
			 * 获取mybatis的update行数，总是返回负数。后来在官网上找到原因，是由于defaultExecutorType的引起的，defaultExecutorType有三个执行器SIMPLE、REUSE和BATCH。
			 * 其中BATCH可以批量更新操作缓存SQL以提高性能，但是有个缺陷就是无法获取update、delete返回的行数。defaultExecutorType的默认执行器是SIMPLE。
			 */
			int changeNumber= sqlSession.insert("com.demo.dao.OrderDao.insertBatchUser",list);
			sqlSession.commit();
			log.info("以及插入了"+(changeNumber)+"条");
			System.out.println("插入了"+changeNumber+"条");
			
		} catch (Exception e) {
			sqlSession.rollback();//回滚事务
			e.printStackTrace();
			
		}finally{
			sqlSession.close();
		}
		
	}




	public List<User> getList() {
		return list;
	}




	public void setList(List<User> list) {
		this.list = list;
	}

	

}
