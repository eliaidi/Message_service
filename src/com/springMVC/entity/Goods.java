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
@Table(name="goods")
public class Goods {
	@Id
	@Column(name="sku")
	private String sku;
	
	@Column(name="name")
	private String name;
	
	@Column(name="marketPrice")
	private double marketPrice;
	
	@Column(name="shopPrice")
	private double shopPrice;
	
	@Column(name="introduction")
	private String introduction;
	
	@Column(name="description")
	private String description;
	
	@Column(name="thumbail")
	private Blob thumbail;
	
	@Column(name="smallImage")
	private Blob smallImage;
	
	@Column(name="bigImage")
	private Blob bigImage;
	
	@Column(name="isOnSale")
	private int isOnSale;
	
	@Column(name="kind")
	private String kind;
	
	@Column(name="stock")
	private int stock;
	

	public Goods(String sku, String name, double marketPrice, double shopPrice, String introduction, String description,
			Blob thumbail, Blob smallImage, Blob bigImage, int isOnSale, String kind, int stock) {
		super();
		this.sku = sku;
		this.name = name;
		this.marketPrice = marketPrice;
		this.shopPrice = shopPrice;
		this.introduction = introduction;
		this.description = description;
		this.thumbail = thumbail;
		this.smallImage = smallImage;
		this.bigImage = bigImage;
		this.isOnSale = isOnSale;
		this.kind = kind;
		this.stock = stock;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
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

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getThumbail() {
		return thumbail;
	}

	public void setThumbail(Blob thumbail) {
		this.thumbail = thumbail;
	}

	public Blob getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(Blob smallImage) {
		this.smallImage = smallImage;
	}

	public Blob getBigImage() {
		return bigImage;
	}

	public void setBigImage(Blob bigImage) {
		this.bigImage = bigImage;
	}

	public int getIsOnSale() {
		return isOnSale;
	}

	public void setIsOnSale(int isOnSale) {
		this.isOnSale = isOnSale;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	}
