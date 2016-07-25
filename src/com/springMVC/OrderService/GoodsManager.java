package com.springMVC.OrderService;

import com.springMVC.entity.Goods;

public interface GoodsManager {
	//增加商品
	public int addGoods(Goods goods);
	//删除商品
	public int deleteGoods(String sku);
	/**
	 *查找商品 
	 **/
	//按Id查找
	public Goods findById(String sku);
	//按name查找
	public Goods findByName(String name);
	//按条件查找
	
	/**
	 *修改商品信息 
	 **/
	    //修改名称
		public int UpdateName(String name,String sku);
		//修改价格
		public int UpdatePrice(String sku,double price);
		//修改库存
		public int UpdateCount(String sku,int count);
		//修改状态
		public int UpdateIsOnSale(String sku,String isOnSale);
}
