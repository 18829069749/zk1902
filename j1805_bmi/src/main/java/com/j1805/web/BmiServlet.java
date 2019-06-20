package com.j1805.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.j1805.dao.BmiDao;
import com.j1805.dao.impl.BmiDaoImpl;
import com.j1805.pojo.BmiBean;

public class BmiServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String action =
	 * request.getParameter("action"); if (action.equals("add")) { add(request,
	 * response); } else if (action.equals("delete")) { delete(request,
	 * response); } else if (action.equals("list")) { list(request, response); }
	 * else {
	 * 
	 * } }
	 */
	private BmiDao bmidao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 通过WebApplicationContextUtils对象的getWebApplicationContext加载spring容器上下文
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(config.getServletContext());
		// 从spring容器中获取指定的对象
		bmidao = webApplicationContext.getBean("bmiDao", BmiDao.class);
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String h = request.getParameter("h");
		String w = request.getParameter("w");
		String bmi = request.getParameter("bmi");
		String sign = request.getParameter("sign");
		String mydate = request.getParameter("mydate");
		String username = request.getParameter("username");
		BmiBean bmiBean = new BmiBean();
		bmiBean.setBmi(bmi);
		bmiBean.setHeight(h);
		bmiBean.setMydate(mydate);
		bmiBean.setSign(sign);
		bmiBean.setUsername(username);
		bmiBean.setWeight(w);
		BmiDao bd = new BmiDaoImpl();
		System.out.println(bmiBean);
		// boolean bl = bd.addBmi(bmiBean);
		boolean bl = true;
		if (bl) {
			PrintWriter out = response.getWriter();
			bmiBean.setId(3);
			String json = new Gson().toJson(bmiBean);
			out.write(json);
			out.flush();
			out.close();
		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

/*	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调用业务方法，是硬编码
		// BmiDao bd =new BmiDaoImpl();
		BmiDao bd = BmiDaoFactory.getBmiDao();// 使用简单工厂解耦controller与dao
		List<BmiBean> all = bd.findAll();
		String json = new Gson().toJson(all);
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		out.close();

	}*/
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调用业务方法，是硬编码
//		// BmiDao bd =new BmiDaoImpl();
//		BmiDao bd = BmiDaoFactory.getBmiDao();// 使用简单工厂解耦controller与dao
		List<BmiBean> all = bmidao.findAll();
		String json = new Gson().toJson(all);
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		out.close();

	}

}
