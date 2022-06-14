package com.yk.servlet;

import com.google.gson.Gson;
import com.yk.entity.MapProvince;
import com.yk.util.XmlProvinceParse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class IndexServlet extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		XmlProvinceParse xmlDomParse = new XmlProvinceParse();
		List<MapProvince> provinceList = xmlDomParse.getMapProvinceList();
		request.getSession().setAttribute("provinces", new Gson().toJson(provinceList));
		request.getRequestDispatcher("map.jsp").forward(request, response);
//		response.sendRedirect("index.jsp");
	}

}
