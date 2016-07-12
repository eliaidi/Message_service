package com.springMVC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_service")
public class User_service {
	@Id
	@Column(name="user_id")
	private String id;

}
