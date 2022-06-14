# P54_Weather_Map_Application
EE181FZ[A] — Critical Skills Project (Robotics) (2021-22:Semester 2)
天气预报查询系统

采用技术：servlet
前后端数据的传输采用json方式
数据源采用定义的文件json格式获取
将所有格式编码转化为UTF-8

> 线上访问地址：http://localhost:8080/weather/

json数据格式化的转化采用谷歌组件gson


读取所有省份访问接口文件province.xml，建立数据源的访问
File file = new File("province.xml");
URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getRegionProvince");
URLConnection con = url.openConnection();
con.connect();


读取所有省份所对应的城市访问接口文件City.xml，建立数据源的访问
File file = new File("City.xml");
URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getSupportCityDataset?theRegionCode="+provinceId);
URLConnection con = url.openConnection();
con.connect();

读取城市对应的天气访问接口文件weather.xml，建立数据源的访问
File file = new File("weather.xml");
URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode="+cityId+"&theUserID=");
URLConnection con = url.openConnection();
con.connect();

发送请求函数
function sendRequest() {
    createXMLHttpRequest();
    var objS = document.getElementById("pid");
    // var value = objS.options[objS.selectedIndex].value;
    var value = $('#pid').val()
    var url = "queryCity?pid=" + value;
    XMLHttpReq.onreadystatechange = getCities;//指定响应函数
    XMLHttpReq.open("GET", url, true);
    XMLHttpReq.send(null);  
}
createXMLHttpRequest();方法
请求后端参数

1、项目介绍

系统实现了展示所有省份信息，及对应的城市信息，通过点击城市信息，可以获取当前所对应的天气信息。
系统采用servlet框架结构，json作为数据读取的数据源。

2、项目技术

后端架构：servlet+json

前端技术：JavaScript+jQUery+Ajax+CSS+HTML


3、开发环境
系统环境：Windows 10

JDK版本：JDK 1.7

服务器：Tomcat 7.0

开发工具：Eclipse


-----English Version-----

Weather forecast query system

Adopted technology: Servlet
The front and back end data are transmitted in JSON mode
The data source is obtained in the defined file JSON format
Convert all format encoding to UTF-8
>Online access address: http://localhost:8080/weather/

The transformation of JSON data format adopts Google component gson


Read all province provider files province XML, establishing access to data sources
File file = new File("province.xml");
URL url = new URL(" http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getRegionProvince ");
URLConnection con = url. openConnection();
con. connect();

Read the city provider file city XML, establishing access to data sources
File file = new File("City.xml");
URL url = new URL(" http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getSupportCityDataset?theRegionCode= "+provinceId);
URLConnection con = url. openConnection();
con. connect();
Read the weather provider file corresponding to the city weather XML, establishing access to data sources
File file = new File("weather.xml");
URL url = new URL(" http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode= "+cityId+"&theUserID=");
URLConnection con = url. openConnection();
con. connect();

Send request function
function sendRequest() {
createXMLHttpRequest();
var objS = document. getElementById("pid");
// var value = objS. options[objS.selectedIndex]. value;
var value = $('#pid'). val()
var url = "queryCity?pid=" + value;
XMLHttpReq. onreadystatechange = getCities;// Specify response function
XMLHttpReq. open("GET", url, true);
XMLHttpReq. send(null);  
}
createXMLHttpRequest(); method
Request backend parameters

1. Project introduction
The system displays the information of all provinces and the corresponding city information. By clicking on the city information, you can obtain the current corresponding weather information.
The system adopts servlet framework structure, and JSON is used as the data source for data reading.
2. Project technology
Back end architecture: servlet+json
Front end technology: javascript+jqury+ajax+css+html
3. Development environment
System environment: Windows 10
JDK version: JDK 1.7
Server: Tomcat 7.0
Development tool: Eclipse


