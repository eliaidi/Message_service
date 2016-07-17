package com.springMVC.OrderService;

import java.util.List;

import com.springMVC.entity.Goods;
import com.springMVC.entity.ShoppingCart;

public interface ShoppingCartDao {
	//删除购物车
	public int DeleteCart(String id);
	//增加购物车
	public int AddCart(String id);
	//查找购物车
	public ShoppingCart FindCart(String id);
	//修改购物车总金额
	public int UpdateTotal();
	/**
	 *购物车商品操作 
	 **/
	//增加一个商品
	public int addGoodToCart(String id,String sku);
	//增加多个商品
	public int  addGoodsToCart(String id,String sku[]);
	//删除一个商品
	public int deleteGoodFromCart(String id,String sku);
	//删除多个商品
	public int deleteGoodsFromCart(String id,String sku[]);
	//查找所有商品
	public List<Goods> FindAllGoods(String id);
}
