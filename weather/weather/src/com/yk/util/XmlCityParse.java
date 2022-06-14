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

import com.yk.entity.MapCity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.yk.entity.City;


public class XmlCityParse {
	
	public List<City> getCityList(int provinceId) {
		List<City> cityList = new ArrayList<City>();
		
		try {
			
			File file = new File("City.xml");
			URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getSupportCityDataset?theRegionCode="+provinceId);
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
			
			NodeList nodeList = doc.getElementsByTagName("City");
			
			int len = nodeList.getLength();
//			System.out.println(len);
			for(int i=0; i<len; i++) {
				City City = new City();
				Node node = nodeList.item(i);
				
				int len2 = node.getChildNodes().getLength();
				for(int j=0; j<len2; j++) {
					Node node2 = node.getChildNodes().item(j);
					if(node2.getNodeType() == 1) {
						String content = node2.getFirstChild().getNodeValue();
						String elementName = node2.getNodeName();
						if("CityID".equals(elementName)) {
							City.setId(content);
						} else if("CityName".equals(elementName)) {
							City.setName(content);
						} 
					}
				}
				cityList.add(City);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return cityList;
	}

	public List<MapCity> getMapCityList(int provinceId) {
		List<MapCity> cityList = new ArrayList<MapCity>();

		try {

			File file = new File("City.xml");
			URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getSupportCityDataset?theRegionCode="+provinceId);
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

			NodeList nodeList = doc.getElementsByTagName("City");

			int len = nodeList.getLength();
//			System.out.println(len);
			for(int i=0; i<len; i++) {
				MapCity city = new MapCity();
				Node node = nodeList.item(i);

				int len2 = node.getChildNodes().getLength();
				for(int j=0; j<len2; j++) {
					Node node2 = node.getChildNodes().item(j);
					if(node2.getNodeType() == 1) {
						String content = node2.getFirstChild().getNodeValue();
						String elementName = node2.getNodeName();
						if("CityID".equals(elementName)) {
							city.setValue(Integer.valueOf(content));
						} else if("CityName".equals(elementName)) {
							city.setName(content);
						}
					}
				}
				cityList.add(city);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return cityList;
	}

	public static void main(String[] args) {
		XmlCityParse xmlCityParse = new XmlCityParse();
		List<City> cityList = xmlCityParse.getCityList(31118);
		for(City city : cityList) {
			System.out.println(city);
		}
	}

}
