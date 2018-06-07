package cn.bts.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author stevenxy E-mail:random_xy@163.com
* @Date 2018年6月6日
* @Description 
*/
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = -4687821948346063108L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Admin service");
	}
	
}
