package cn.bts.realm;

import java.sql.Connection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.bts.dao.UserDao;
import cn.bts.entity.User;
import cn.bts.util.DbUtil;

/**
* @author stevenxy E-mail:random_xy@163.com
* @Date 2018年6月7日
* @Description 
*/
public class MyRealm extends AuthorizingRealm {
	
	private UserDao userDao=new UserDao();
	private DbUtil dbUtil=new DbUtil(); 
	
	/**
	 * 为当前登录成功的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String userName=(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		Connection connection=null;
		try {
			connection=dbUtil.getCon();
			authorizationInfo.setRoles(userDao.getRoles(connection,userName));
			authorizationInfo.setStringPermissions(userDao.getPermissions(connection,userName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return authorizationInfo;
	}
	
	/**
	 * 身份认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		String userName=(String)token.getPrincipal();
		Connection connection=null;
		try {
			connection=dbUtil.getCon();
			User user=userDao.getByUserName(connection, userName);
			 if(user!=null) {
				 AuthenticationInfo authcinfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),"xx");
				 return authcinfo;
			 }else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
