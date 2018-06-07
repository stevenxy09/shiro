package cn.bts.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
* @author stevenxy E-mail:random_xy@163.com
* @Date 2018年6月7日
* @Description shiro加密解密
*/
public class CryptographyUtil {
	
	/**
	 * base64加密
	 * @param str
	 * @return
	 */
	public static String encBase64(String str) {
		
		return Base64.encodeToString(str.getBytes());
	}
	
	/**
	 * base64解密
	 * @param str
	 * @return
	 */
	public static String decBase64(String str) {
		
		return Base64.decodeToString(str);
	}
	
	/**
	 * md5加密
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String md5(String str,String salt) {
		
		return new Md5Hash(str,salt).toString();
	} 
	
	public static void main(String[] args) {
		String password="123456";
		System.out.println("base64加密:"+CryptographyUtil.encBase64(password));
		System.out.println("base64解密:"+CryptographyUtil.decBase64("MTIzNDU2"));
		System.out.println("base64加密:"+CryptographyUtil.md5(password,"嘻嘻"));
	}
}
