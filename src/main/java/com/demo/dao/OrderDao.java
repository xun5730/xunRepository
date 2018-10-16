package com.demo.dao;

import java.util.List;

import com.demo.entity.Order;
import com.demo.entity.User;

public interface OrderDao {

	void insertOrderRecord(Order order);

	void insertOrderRecord2(Order order);
	
	int insertUser(User user);

	int insertBatchUser(List<User> userList);

}
