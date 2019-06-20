package com.j1805.dao.factory;

import com.j1805.dao.BmiDao;
import com.j1805.dao.impl.BmiDaoImpl;

public class BmiDaoFactory {

	public static BmiDao  getBmiDao(){
		return new BmiDaoImpl();
		
	}
}
