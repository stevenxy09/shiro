package cn.bts.dao;
/**
* @author stevenxy E-mail:random_xy@163.com
* @Date 2018年6月7日
* @Description 
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import cn.bts.entity.User;


public class UserDao {
	
	public User getByUserName(Connection connection,String userName)throws Exception {
		User resultUser=null;
		String sql="select * from t_user where userName=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1, userName);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		
		return resultUser;
	}

	public Set<String> getRoles(Connection connection, String userName) throws Exception{
		Set<String> roles=new HashSet<>();
		String sql="select * from t_user u,t_role r where u.roleId=r.id and u.userName=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1, userName);
		ResultSet rSet=ps.executeQuery();
		while (rSet.next()) {
			roles.add(rSet.getString("roleName"));
		}
		
		return roles;
	}

	public Set<String> getPermissions(Connection connection, String userName) throws Exception{
		Set<String> permissions=new HashSet<>();
		String sql="SELECT * FROM t_user u,t_role r,t_permission p WHERE u.roleId=r.id AND p.roleId=r.id AND u.userName=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1, userName);
		ResultSet rSet=ps.executeQuery();
		while (rSet.next()) {
			permissions.add(rSet.getString("permission"));
		}
		
		return permissions;
	}
}
