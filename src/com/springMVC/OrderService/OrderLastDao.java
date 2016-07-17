package com.springMVC.OrderService;

import java.util.List;

import com.springMVC.entity.OrderLast;
import com.springMVC.entity.Ordering;

public interface OrderLastDao {
	//增加一个历史订单
	public int addOrder(OrderLast order);
	//查看一个历史订单
	public OrderLast findOrder(String id);
	//查看所有的历史订单
	public List<OrderLast> findAllOrder();

}
