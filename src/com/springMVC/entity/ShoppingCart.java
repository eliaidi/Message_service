package com.springMVC.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="shoppingCart")
public class ShoppingCart {
	@Id
	@Column(name="id")
	private String id;
	 
	@Column(name="total")
	private double total;
	
	@ManyToMany
	@JoinTable(name="Goods_Cart",joinColumns=@JoinColumn(name="cart_id"),
			inverseJoinColumns=@JoinColumn(name="googs_id"))
	private Set<Goods> goods=new HashSet<Goods>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	public ShoppingCart(String id, double total, Set<Goods> goods) {
		super();
		this.id = id;
		this.total = total;
		this.goods = goods;
	}

	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
