package com.springMVC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class User_member {
	@Id
	@Column(name="user_id")
	private String id;

	public User_member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User_member(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
