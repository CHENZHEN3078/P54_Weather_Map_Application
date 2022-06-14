package com.yk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yk.entity.City;
import com.yk.entity.WeatherInfo;
import com.yk.util.XmlCityParse;
import com.yk.util.XmlWeatherParse;


public class QueryWeather extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		XmlWeatherParse xmlWeatherParse = new XmlWeatherParse();
		int id = Integer.parseInt(request.getParameter("cid"));
		WeatherInfo weatherInfo = xmlWeatherParse.getWeatherInfo(id);
		PrintWriter out = response.getWriter();

		response.setHeader("Cache-Control", "no-cache"); 
		response.setContentType("text/xml");
		out.println("<response>");
		out.println("<str1>"+ weatherInfo.getStr1() + "</str1>");
		out.println("<str2>"+ weatherInfo.getStr2() + "</str2>");  
		out.println("<str5>"+ weatherInfo.getStr5() + "</str5>");
		out.println("<str6>"+ weatherInfo.getStr6() + "</str6>");  
		out.println("<str8>"+ weatherInfo.getStr8() + "</str8>");  
		out.println("<str9>"+ weatherInfo.getStr9() + "</str9>");
		out.println("<str10>"+ weatherInfo.getStr10() + "</str10>");
		out.println("<str11>"+ weatherInfo.getStr11() + "</str11>");
		out.println("<str12>"+ weatherInfo.getStr12() + "</str12>");
		out.println("<str13>"+ weatherInfo.getStr13() + "</str13>");  
		out.println("<str14>"+ weatherInfo.getStr14() + "</str14>");
		out.println("<str15>"+ weatherInfo.getStr15() + "</str15>"); 
		out.println("<str16>"+ weatherInfo.getStr16() + "</str16>");  
		out.println("<str17>"+ weatherInfo.getStr17() + "</str17>");
		out.println("<str18>"+ weatherInfo.getStr18() + "</str18>");  
		out.println("<str19>"+ weatherInfo.getStr19() + "</str19>");
		out.println("<str20>"+ weatherInfo.getStr20() + "</str20>");  
		out.println("<str21>"+ weatherInfo.getStr21() + "</str21>");  
		out.println("<str22>"+ weatherInfo.getStr22() + "</str22>");  
		out.println("<str23>"+ weatherInfo.getStr23() + "</str23>");  
		out.println("<str24>"+ weatherInfo.getStr24() + "</str24>");
		out.println("<str25>"+ weatherInfo.getStr25() + "</str25>");
		out.println("<str26>"+ weatherInfo.getStr26() + "</str26>");
		out.println("<str27>"+ weatherInfo.getStr27() + "</str27>");
		out.println("<str28>"+ weatherInfo.getStr28() + "</str28>");  
		out.println("<str29>"+ weatherInfo.getStr29() + "</str29>");
		out.println("<str30>"+ weatherInfo.getStr30() + "</str30>");  
		out.println("<str31>"+ weatherInfo.getStr31() + "</str31>");
		out.println("<str32>"+ weatherInfo.getStr32() + "</str32>");  
		out.println("</response>");  
		out.flush();
		out.close();
	}

}
