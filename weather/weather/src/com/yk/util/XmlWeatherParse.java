package com.yk.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.yk.entity.Province;
import com.yk.entity.WeatherInfo;


public class XmlWeatherParse {
	
	public WeatherInfo getWeatherInfo(int cityId) {
		WeatherInfo weather = new WeatherInfo();
		try {
			
			File file = new File("weather.xml");
			URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode="+cityId+"&theUserID=");
			URLConnection con = url.openConnection();
			con.connect();
				
			InputStream is = con.getInputStream();
			OutputStream os = new FileOutputStream(file, false);
				
			byte[] data = new byte[1024];
			int length;
			while(-1 != (length=is.read(data))) {
				os.write(data, 0, length);
			}
			os.flush();
			os.close();
			is.close();
			
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document doc = documentBuilder.parse(file);
			
			Element element = doc.getDocumentElement();
			
			NodeList nodeList = doc.getElementsByTagName("string");
			
			int len = nodeList.getLength();
//			System.out.println(len);
			for(int i=0; i<len; i++) {
				Node node = nodeList.item(i);
				String content = node.getFirstChild().getNodeValue();
				switch (i) {
				case 0: weather.setStr1(content); break;
				case 1: weather.setStr2(content); break;
				case 2: weather.setStr3(content); break;
				case 3: weather.setStr4(content); break;
				case 4: weather.setStr5(content); break;
				case 5: weather.setStr6(content); break;
				case 6: weather.setStr7(content); break;
				case 7: weather.setStr8(content); break;
				case 8: weather.setStr9(content); break;
				case 9: weather.setStr10(content); break;
				case 10: weather.setStr11(content); break;
				case 11: weather.setStr12(content); break;
				case 12: weather.setStr13(content); break;
				case 13: weather.setStr14(content); break;
				case 14: weather.setStr15(content); break;
				case 15: weather.setStr16(content); break;
				case 16: weather.setStr17(content); break;
				case 17: weather.setStr18(content); break;
				case 18: weather.setStr19(content); break;
				case 19: weather.setStr20(content); break;
				case 20: weather.setStr21(content); break;
				case 21: weather.setStr22(content); break;
				case 22: weather.setStr23(content); break;
				case 23: weather.setStr24(content); break;
				case 24: weather.setStr25(content); break;
				case 25: weather.setStr26(content); break;
				case 26: weather.setStr27(content); break;
				case 27: weather.setStr28(content); break;
				case 28: weather.setStr29(content); break;
				case 29: weather.setStr30(content); break;
				case 30: weather.setStr31(content); break;
				case 31: weather.setStr32(content); break;
				default: break;
				}
				
			}
				
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weather;
	}
	
	public static void main(String[] args) {
		XmlWeatherParse xmlWeatherParse = new XmlWeatherParse();
		WeatherInfo weatherInfo = xmlWeatherParse.getWeatherInfo(1780);
		System.out.println(weatherInfo);
	}

}
