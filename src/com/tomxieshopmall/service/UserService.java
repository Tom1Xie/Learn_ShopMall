package com.tomxieshopmall.service;

import com.tomxieshopmall.dao.UserDao;
import com.tomxieshopmall.domain.User;

/**
 * UserService
 * 
 * @author yezhu
 *
 */
public class UserService {

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	public boolean register(User user) {
		boolean isRegisterSuccessful = true;

		// 注：dao只是帮你执行语句
		UserDao userDao = new UserDao();
		int row = userDao.regist(user);

		return row > 0 ? true : false;
	}

}
