package com.springMVC.OrderService;

import java.util.ArrayList;
import java.util.List;

import com.springMVC.entity.Goods;

public interface GoodsDao {
	//增加商品
	public int AddGoods(Goods goods);
	//删除商品
	public int DeleteGoods(String sku);
	/**
	 * 查找商品
	 **/
	//查找所有商品
	public List<Goods> FindAll();
	//按名字查找
	public List<Goods> NameFind(String name);
	//按ID查找
	public Goods IdFind(String Id);
	//按条件查找
	
	/**
	 *修改商品
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
