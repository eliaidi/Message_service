package com.springMVC.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_basic")
public class User_basic {
	@Id
	@Column(name="user_id")
	private String id;
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_pwd")
	private String pwd;
	
	@Column(name="user_age")
	private int age;
	
	@Column(name="user_image")
	private Blob image;
	
	@Column(name="user_sex")
	private String sex;
	
	@Column(name="user_mail")
	private String mail;
	
	@Column(name="user_tel")
	private String tel;
	
	@Column(name="user_power")
	private int power;

	public User_basic() {

	}

	public User_basic( String name, String pwd, int age, Blob image, String sex,String mail, String tel) {
		super();
		this.id = tel;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.image = image;
		this.sex = sex;
		this.mail=mail;
		this.tel = tel;
		this.power = 1;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
		setTel(tel);
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	public  void allset(User_basic user){
		this.name = user.name;
		this.pwd = user.pwd;
		this.age = user.age;
		this.image = user.image;
		this.sex = user.sex;
		this.mail=user.mail;
		this.tel = user.tel;		
	}

	@Override
	public String toString() {
		return "User_basic [id=" + id + ", name=" + name + ", pwd=" + pwd + ", age=" + age + ", image=" + image
				+ ", sex=" + sex + ", mail=" + mail + ", tel=" + tel + ", power=" + power + "]";
	}
	

}
