package com.springMVC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Goods_Cart")
public class Goods_Cart {
	@Id
	@Column(name="cart_id")
	private  String cart_id;
	@Id
	@Column(name="googs_id")
	private String googs_id;
	 
	@Column(name="count")
	private String count;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	
}
