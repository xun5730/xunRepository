package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.common.SpringContextUtil;
import com.demo.dao.OrderDao;
import com.demo.entity.Order;
import com.demo.entity.User;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public void concurrentDemo1() {

	}

	public void batchDataDemo() {
		List<Order> data=new ArrayList<Order>();
		
		
		long beginTime= System.currentTimeMillis();
//		SqlSessionFactory sqlSessionFactory = ctx.getBean(SqlSessionFactory.class);
		SqlSessionFactory sqlSessionFactory=   SpringContextUtil.getBean("sqlSessionFactory");
		SqlSession sqlSession=null;
		try{
		 sqlSession=  sqlSessionFactory.openSession(ExecutorType.BATCH,false);
		
		int a=2000;//每次提交2000条
		int loop = (int) Math.ceil(data.size() / (double) a);
		
		List<Order> tempList=new ArrayList<Order>(a);
		int start ,stop;
		for(int i=0;i<loop;i++){
			
			tempList.clear();
			start=i*a;
			stop=Math.min(i*a+a-1,data.size()-1 );
			System.out.println("range:"+start+"---"+stop);
			for(int j=start;i<=stop;j++){
				tempList.add(data.get(j));
			}
			sqlSession.insert("", tempList);
			sqlSession.commit();
			sqlSession.clearCache();
			System.out.println("已经插入"+(stop+1)+"条");
			
		}
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
			
		}
		long endTime = System.currentTimeMillis();
		System.out.println("插入完成，耗时 " + (endTime - beginTime) + " 毫秒！");
		
	}
	 /**
	      * 批量提交数据
	      * @param sqlSessionFactory
	      * @param mybatisSQLId SQL语句在Mapper XML文件中的ID
	      * @param commitCountEveryTime 每次提交的记录数
	      * @param list 要提交的数据列表
	      * @param logger 日志记录器
	      */
	   /*  private <T> void batchCommit(SqlSessionFactory sqlSessionFactory, String mybatisSQLId, int commitCountEveryTime, List<T> list, Logger logger) {
	         SqlSession session = null;
	         try {
	             session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
	             int commitCount = (int) Math.ceil(list.size() / (double) commitCountEveryTime);
	             List<T> tempList = new ArrayList<T>(commitCountEveryTime);
	             int start, stop;
	             Long startTime = System.currentTimeMillis();
	             for (int i = 0; i < commitCount; i++) {
	                 tempList.clear();
	                 start = i * commitCountEveryTime;
	                 stop = Math.min(i * commitCountEveryTime + commitCountEveryTime - 1, list.size() - 1);
	                 for (int j = start; j <= stop; j++) {
	                     tempList.add(list.get(j));
	                 }
	                 session.insert(mybatisSQLId, tempList);
	                 session.commit();
	                 session.clearCache();
	             }
	             Long endTime = System.currentTimeMillis();
	             logger.debug("batchCommit耗时：" + (endTime - startTime) + "毫秒");
	         } catch (Exception e) {
	             logger.error("batchCommit error!", e);
	             e.printStackTrace();
	             session.rollback();
	         } finally {
	             if (session != null) {
	                 session.close();
	             }
	         }
	     }*/

	public void batchVoucherDemo() {

		
		
		
	}

	public int batchUserDemo() {

		
		 Long start=  System.currentTimeMillis();
		int batchCount=10000;
		List<User> userList=new ArrayList<User>(  batchCount);
		for(int i=1;i<=batchCount;i++){
			User u=new User();
			u.setName("name"+i);
			u.setInfo("这是第"+i+"条数据");
			userList.add(u);
		}
		int changeNumber=  orderDao.insertBatchUser(userList);
		/*for(int i=500;i<=1000;i++){
			User u=new User();
			u.setName("name"+i);
			
			u.setInfo("这是第"+i+"条数据");
			userList.add(u);
		}

		int changeNumber2=  orderDao.insertBatchUser(userList);*/
		 Long end=  System.currentTimeMillis();
		 System.out.println("插入时间总计"+(end-start));
		return changeNumber;
		
	}
	public int batchUserDemo(List<User> listData) {
		int changeNumber=  orderDao.insertBatchUser(listData);
		return changeNumber;
	}
	
	
	public int insertUser(User u) {
		return orderDao.insertUser(u);
	}


	
	
/*	<insert id="insertBatch" parameterType="java.util.List">
	 2         DECLARE
	 3         base_id INTEGER ;
	 4         detail_id INTEGER ;
	 5         <foreach collection="list" item="item" index="index" open="begin" close="end;">
	 6             select seq_t_base.nextval into base_id from dual;
	 7             insert into t_base(id, fee) values(base_id, #{item.baseEntity.fee,jdbcType=DECIMAL});
	 8             <foreach collection="item.details" item="detail" index="index">
	 9                 select seq_t_detail.nextval into detail_id from dual;
	10                 insert into t_detail(id, base_id, fee) values(detail_id,base_id,#{detail.fee,jdbcType=DECIMAL});
	11             </foreach>
	12         </foreach>
	13     </insert>
	*/
	

}
