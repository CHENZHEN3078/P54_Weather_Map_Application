package com.yk.servlet;

import com.google.gson.Gson;
import com.yk.entity.City;
import com.yk.entity.MapCity;
import com.yk.util.XmlCityParse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class QueryCityByProvince extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		XmlCityParse xmlCityParse = new XmlCityParse();
		int id = Integer.parseInt(request.getParameter("pid"));
		List<MapCity> cities = xmlCityParse.getMapCityList(id);
		
		System.out.println(cities);
		Gson gson = new Gson();
//		String citiesStr = gson.toJson(cities);
//		System.out.println(citiesStr);

		PrintWriter out = response.getWriter();
		out.write(gson.toJson(cities));
		out.flush();
		out.close();

	}

}
