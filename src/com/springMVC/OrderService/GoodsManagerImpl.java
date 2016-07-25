package com.springMVC.OrderService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springMVC.Config.UserBeanConfiguration;
import com.springMVC.entity.Goods;

public class GoodsManagerImpl implements GoodsManager {
	private static AnnotationConfigApplicationContext applicationContext;
	static{
		 applicationContext=
					new AnnotationConfigApplicationContext();
	}
	@Override
	public int addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGoods(String sku) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Goods findById(String sku) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goods findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int UpdateName(String name, String sku) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdatePrice(String sku, double price) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdateCount(String sku, int count) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdateIsOnSale(String sku, String isOnSale) {
		// TODO Auto-generated method stub
		return 0;
	}

}
