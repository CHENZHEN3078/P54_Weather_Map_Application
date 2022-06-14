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

import com.yk.entity.MapProvince;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.yk.entity.Province;


public class XmlProvinceParse {

	public List<MapProvince> getMapProvinceList() {
		List<MapProvince> provinceList = new ArrayList<MapProvince>();

		try {

			File file = new File("province.xml");
			URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getRegionProvince");
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
				MapProvince province = new MapProvince();
				Node node = nodeList.item(i);
//				System.out.println(node.getFirstChild().getNodeValue());
				String content = node.getFirstChild().getNodeValue();
				String[] str = content.split(",");
				province.setValue(Integer.valueOf(str[1]));
				province.setName(str[0]);
				provinceList.add(province);
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
		return provinceList;
	}

	
	public List<Province> getProvinceList() {
		List<Province> provinceList = new ArrayList<Province>();
		
		try {
			
			File file = new File("province.xml");
			URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getRegionProvince");
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
				Province province = new Province();
				Node node = nodeList.item(i);
//				System.out.println(node.getFirstChild().getNodeValue());
				String content = node.getFirstChild().getNodeValue();
				String[] str = content.split(",");
				province.setId(str[1]);
				province.setName(str[0]);
				provinceList.add(province);
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
		return provinceList;
	}
	
	public static void main(String[] args) {
		XmlProvinceParse xmlDomParse = new XmlProvinceParse();
		List<Province> list = xmlDomParse.getProvinceList();
		for(Province province : list) {
			System.out.println(province);
		}
	}

}
