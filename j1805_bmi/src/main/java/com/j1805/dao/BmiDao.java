package com.j1805.dao;

import java.util.List;

import com.j1805.pojo.BmiBean;

public interface BmiDao {
//全查
	public  List<BmiBean> findAll();
//	根据id删除记录
	public boolean deleteById(int id);
//	添加bmi信息
	public boolean addBmi(BmiBean bmi);
	
}
