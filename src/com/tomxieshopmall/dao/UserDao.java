package com.tomxieshopmall.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.tomxieshopmall.domain.User;
import com.tomxieshopmall.utils.DataSourceUtils;

public class UserDao {

	/**
	 * 执行sql语句，将数据放到数据库中
	 * 
	 * @param user
	 * @return
	 */
	public int regist(User user) {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		int row = 0; // 默认值是0 更新成功则为>0
		try {
			row = runner.update(sql,
					user.getUid(), 
					user.getUsername(), 
					user.getPassword(), 
					user.getName(),
					user.getEmail(), 
					user.getTelephone(), 
					user.getBirthday(), 
					user.getSex(), 
					"test_state", 
					"test_code");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return row;
	}

}
