package com.j1805.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j1805.dao.BmiDao;
import com.j1805.pojo.BmiBean;
import com.j1805.utils.BaseDao;

public class BmiDaoImpl extends BaseDao implements BmiDao {

	@Override
	public List<BmiBean> findAll() {
		List<BmiBean> li = new ArrayList<>();
		// 1、加载驱动
		// 2、获取连接
		// 3、编写sql指令
		// 4、创建执行体
		// 5、执行sql指令
		// 6、处理执行结果
		// 7、释放资源

		try {
			super.getConnection();
			String sql = "select * from bmi";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BmiBean bmi = new BmiBean();
				bmi.setBmi(rs.getString("BMI"));
				bmi.setHeight(rs.getString("height"));
				bmi.setWeight(rs.getString("weight"));
				bmi.setId(rs.getInt("ID"));
				bmi.setMydate(rs.getString("mydate"));
				bmi.setSign(rs.getString("sign"));
				bmi.setUsername(rs.getString("username"));
				li.add(bmi);
			}
			return li;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return null;
	}
   

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addBmi(BmiBean bmi) {
		// TODO Auto-generated method stub
		return false;
	}

}
