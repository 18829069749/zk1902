package com.j1805.dao;

import java.util.List;

import org.junit.Test;

import com.j1805.dao.impl.BmiDaoImpl;
import com.j1805.pojo.BmiBean;

public class TestBmiDao {

//	@Test
	public void test() {
		BmiDao bd = new BmiDaoImpl();
		List<BmiBean> all = bd.findAll();
		System.out.println(all.size());
		
	}

}
