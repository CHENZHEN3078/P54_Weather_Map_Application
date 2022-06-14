package com.yk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yk.entity.City;
import com.yk.util.XmlCityParse;


public class QueryCity extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		XmlCityParse xmlCityParse = new XmlCityParse();
		int id = Integer.parseInt(request.getParameter("pid"));
		List<City> cities = xmlCityParse.getCityList(id);
		
		System.out.println(cities);
//		Gson gson = new Gson();
//		String citiesStr = gson.toJson(cities);
//		System.out.println(citiesStr);
		
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-Control","no-cache");
		response.setContentType("text/xml");
		out.println("<response>");
		for(int i=0;i<cities.size(); i++) {
			out.println("<id>"+ cities.get(i).getId() + "</id>");  
			out.println("<name>"+ cities.get(i).getName() + "</name>");
		}  
		out.println("</response>");  
		out.flush();
		out.close();

	}

}
