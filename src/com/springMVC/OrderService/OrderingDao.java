package com.springMVC.OrderService;

import java.util.ArrayList;
import java.util.List;

import com.springMVC.entity.Goods;
import com.springMVC.entity.Ordering;

public interface OrderingDao {
	/**
	 * 订单基础操作
	 **/
	//添加一个订单
	public int addOrder(Ordering order);
	//删除一个订单
	public int deleteOrder(String id);
	//修改地址信息
	public int updateOrderAddress(String id,String address);
	//修改电话
	public int updateOrderTel(String id,String tel);
	//查找一个订单
	public Ordering findOne(String id);
	//查找所有订单
	public List<Ordering> findall();
	
	/**
	 *订单生成 
	 **/
	//添加商品
	public int addGoods(ArrayList<Goods> goods);
	
	
}
