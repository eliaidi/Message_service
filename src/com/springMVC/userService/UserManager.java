package com.springMVC.userService;

import java.sql.Blob;
import java.util.ArrayList;

import com.springMVC.entity.User_basic;

public interface UserManager {
	//增加学生
	public int AddUser(String name, String pwd, int age, Blob image, String sex, String mail,String tel);
	//删除学生
	public int DeleteUser(String id);
	//查找一个学生
	public User_basic FindOne(String id);
	//查找所有学生
	public ArrayList<User_basic> FindAll();
	//用户转会员
	public int UserToMember(String id);
	//修改权限值
	public int UpdatePower(String id);
	//修改密码
	public int UpdatePwd(String pwd,String id);
}
