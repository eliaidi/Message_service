package com.springMVC.entity;

import java.sql.Blob;
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
@Table(name="ordering")
public class Ordering {
	@Id
	@Column(name="id")
	private String id;
	 
	@Column(name="total")
	private double total;
	
	@Column(name="address")
	private String address;
	
	@Column(name="tel")
	private String tel;
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private String price;
	@Column(name="thumbail")
	private Blob thumbail;
	
	@Column(name="description")
	private String description;

	
	@Column(name="kind")
	private String kind;//订单完成种类：取消、完成

	@ManyToMany
	@JoinTable(name="Goods_Ordering",joinColumns=@JoinColumn(name="order_id"),
			inverseJoinColumns=@JoinColumn(name="goods_id"))
	private Set<Goods> goods=new HashSet<Goods>();

	public Ordering() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ordering(String id, double total, String address, String tel, String sku, String name, String price,
			Blob thumbail, String description, String kind, Set<Goods> goods) {
		super();
		this.id = id;
		this.total = total;
		this.address = address;
		this.tel = tel;
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.thumbail = thumbail;
		this.description = description;
		this.kind = kind;
		this.goods = goods;
	}

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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Blob getThumbail() {
		return thumbail;
	}

	public void setThumbail(Blob thumbail) {
		this.thumbail = thumbail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	

	

	
}
