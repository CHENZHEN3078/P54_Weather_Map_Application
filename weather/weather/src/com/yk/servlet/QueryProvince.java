package com.yk.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yk.entity.Province;
import com.yk.util.XmlProvinceParse;


public class QueryProvince extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		XmlProvinceParse xmlDomParse = new XmlProvinceParse();
		List<Province> provinceList = xmlDomParse.getProvinceList();
		request.getSession().setAttribute("provinces", provinceList);
		if (request.getParameter("provinceId") != null && request.getParameter("cityId") != null) {
			request.getSession().setAttribute("proId", request.getParameter("provinceId"));
			request.getSession().setAttribute("cityId", request.getParameter("cityId"));
			response.sendRedirect("index.jsp");
		} else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
