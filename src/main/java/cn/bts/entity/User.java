package cn.bts.entity;

import java.io.Serializable;

/**
* @author stevenxy E-mail:random_xy@163.com
* @Date 2018年6月7日
* @Description 
*/
public class User implements Serializable{
	
	private static final long serialVersionUID = 4569129571435959287L;
	
	private Integer id;
	private String userName;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
