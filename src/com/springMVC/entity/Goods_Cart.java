package com.springMVC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Goods_Count")
public class Goods_Cart {
	@Id
	@Column(name="cart_id")
	private String id;
	@Column(name="goods_id")
	private String sku;
	@Column(name="count")
	private int count;
	public Goods_Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods_Cart(String id, String sku, int count) {
		super();
		this.id = id;
		this.sku = sku;
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


}
