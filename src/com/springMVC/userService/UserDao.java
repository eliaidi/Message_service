package com.springMVC.userService;

import java.util.ArrayList;

import com.springMVC.entity.User_basic;
import com.springMVC.entity.User_service;

public interface UserDao {
	/**
	 * 用户基础表操作
	**/
	//增加一个用户（级联到user_service）
	public int AddUser(User_basic user);
	//删除一个用户（级联到user_member、user_service）
	public int DeleteUser(String id);
	//修改用户基础信息
	public int UpdateUser(User_basic user);
	//查找一个用户
	public User_basic FindOne(String id);
	//查找多个用户
	public ArrayList<User_basic> FindAll();
	//修改权限值
	public int updatePower(int power,String id);
	//修改密码
	public int updatePwd(String Pwd,String id);
	//分页选项保留
	/**
	 *用户服务表操作 
	 **/
	//修改用户服务信息
	public int UpdateUserService(User_service suser);
	//查找一个用户服务信息
	public User_service FindOneService(String id);
	//查找多个用户服务信息
	public ArrayList<User_service>  FindAllService();
	//分页选项保留
	/**
	 *会员表操作 
	 **/
	//添加一个会员
	public int AddMember(String id);
	//删除一个会员
	public int DeleteMember(String id);
	//修改会员服务信息
	
	//查找一个会员服务信息
	
	//查找多个会员服务信息
	
}
