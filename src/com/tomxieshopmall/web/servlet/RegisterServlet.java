package com.tomxieshopmall.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tomxieshopmall.domain.User;
import com.tomxieshopmall.service.UserService;
import com.tomxieshopmall.utils.CommonUtils;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isRegisterSuccessful ;
		
		request.setCharacterEncoding("UTF-8");
		
		//1. get info from forms
		Map<String,String[]> paramterMap = request.getParameterMap();
		
		//2. 封装到User实体当中,字段要和数据库中相同滴
		User user = new User();
		try {
			//自己去注册或者指定一个类型转换器，将string转成data类型
			//映射封装 自己制定一个类型转换器
			BeanUtils.populate(user, paramterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
		
		user.setUid(CommonUtils.getUuid());
		user.setTelephone("8888888");
		
		//3.将user传递到service层中  ==》在user service中操作dao层
		UserService userService = new UserService();
		isRegisterSuccessful = userService.register(user);
		
		if (isRegisterSuccessful) {
			// if the customer registered successfully

			response.sendRedirect(request.getContextPath() + "/registerSuccess.jsp");
		} else {
			// if the registration failed,just jump to "registerFail.jsp"
			response.sendRedirect(request.getContextPath() + "/registerFail.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
