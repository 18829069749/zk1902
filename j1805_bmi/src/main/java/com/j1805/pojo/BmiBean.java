package com.j1805.pojo;

public class BmiBean {
	
	private int id;//主键
	private String mydate;//创建时间 年-月
	private String height;//身高  cm
	private String weight; //体重 kg
	private String bmi;//体脂指数
	private String sign;//标识：时间的整型数字
	private String username;//用户
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMydate() {
		return mydate;
	}
	public void setMydate(String mydate) {
		this.mydate = mydate;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	

}
