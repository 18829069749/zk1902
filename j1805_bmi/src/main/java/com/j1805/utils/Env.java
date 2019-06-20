package com.j1805.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Env extends Properties{
	
	/**
	 * 1\构造私有
	 * 2、提供static对外的共有访问途径
	 */
	private static Env env= null;
	private  Env(){
		this.mkkk();
	}
	
	public  synchronized static  Env newInstance(){
		if(env==null){
			env = new Env();
		}
		return env;
	}
	
	private void mkkk(){
		InputStream is = this.getClass().getResourceAsStream("/com/j1805/utils/db.properties");
		try {
			load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
