package com.springMVC.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="OrderLast")
public class OrderLast {
	@Id
	@Column(name="id")
	private String id;
	 
	@Column(name="total")
	private double total;
	
	@Column(name="address")
	private String address;
	
	@Column(name="tel")
	private String tel;
	
	@Column(name="kind")
	private String kind;//订单完成种类：取消、完成
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@ManyToMany
	@JoinTable(name="Goods_Order",joinColumns=@JoinColumn(name="orderLast_id"),
			inverseJoinColumns=@JoinColumn(name="good_id"))
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

	public OrderLast(String id, double total, String address, String tel, String kind, Set<Goods> goods) {
		super();
		this.id = id;
		this.total = total;
		this.address = address;
		this.tel = tel;
		this.kind = kind;
		this.goods = goods;
	}

	public OrderLast() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
