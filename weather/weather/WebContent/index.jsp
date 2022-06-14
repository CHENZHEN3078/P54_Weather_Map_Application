<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>天气查询</title>
    <meta charset="utf-8">
    <style type="text/css">
        * {
            margin: 0px auto;
            padding: 0px;
        }

        .ul1 {
            padding-top: 30px;
        }

        .ul1 li {
            list-style: none;
            float: left;
            width: 150px;
            height: 30px;
            padding-left: 25px;
        }

        .ul2 li {
            list-style: none;
            float: left;
            padding-left: 10px;
        }

        .ul2 li select {
            width: 100px;
            height: 20px;
        }

        .ul3 {
            clear: both;
            padding-top: 10px;
        }

        .ul3 li {
            list-style: none;
            padding-left: 26px;
            margin-top: 20px;

        }

        .ul3 li input {
            width: 500px;
            height: 20px;
        }

        #weather {
            width: 800px;
            height: 600px;
            background: skyblue;
            border: 10px skyblue solid;
        }

        #top {
            width: 800px;
            height: 400px;
            background-size: auto;
            background: url(images/blue.jpg) no-repeat;
        }

        #bottom {
            width: 800px;
            height: 200px;
            background: bluesky;
        }

        #bottom ul {
            padding-top: 25px;
            padding-left: 20px;
        }

        #bottom ul li {
            list-style: none;
            float: left;
            padding-left: 10px;
        }

        #bottom ul li div {
            width: 140px;
            height: 150px;
            background-color: white;
        }

        .weatherinfo {
            list-style: none;
            line-height: 150%;
            font-size: 12px;
            text-align: center;
        }
    </style>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        /* function provinceChange() {
            var objS = document.getElementById("pid");
            var value = objS.options[objS.selectedIndex].value;
            var nowProvince = objS.options[objS.selectedIndex].innerHTML;
            window.location = "queryCity?pid="+value+"&pname="+nowProvince;
        } */

        function getWeather() {
            createXMLHttpRequest();
            var objS = document.getElementById("myselect");
			var option = $('#myselect option:selected');
			console.log(option)
			var value = option.val()
			console.log('111' + value)
			console.log(objS.selectedIndex)
            var value = objS.options[objS.selectedIndex].value;
            var url = "queryWeather?cid=" + value;
            XMLHttpReq.open("GET", url, true);
            XMLHttpReq.onreadystatechange = DisplayWeather;
            XMLHttpReq.send(null);  
        }

        function DisplayWeather() {
            if (XMLHttpReq.responseXML != null) {
                var text1 = XMLHttpReq.responseXML.getElementsByTagName("str1")[0].firstChild.nodeValue;
                var text2 = XMLHttpReq.responseXML.getElementsByTagName("str2")[0].firstChild.nodeValue;
                var text3 = XMLHttpReq.responseXML.getElementsByTagName("str5")[0].firstChild.nodeValue;
                var text4 = XMLHttpReq.responseXML.getElementsByTagName("str6")[0].firstChild.nodeValue;

                var day11 = XMLHttpReq.responseXML.getElementsByTagName("str8")[0].firstChild.nodeValue;
                var day12 = XMLHttpReq.responseXML.getElementsByTagName("str9")[0].firstChild.nodeValue;
                var day13 = XMLHttpReq.responseXML.getElementsByTagName("str10")[0].firstChild.nodeValue;
                var day14 = XMLHttpReq.responseXML.getElementsByTagName("str11")[0].firstChild.nodeValue;
                var day15 = XMLHttpReq.responseXML.getElementsByTagName("str12")[0].firstChild.nodeValue;

                var day21 = XMLHttpReq.responseXML.getElementsByTagName("str13")[0].firstChild.nodeValue;
                var day22 = XMLHttpReq.responseXML.getElementsByTagName("str14")[0].firstChild.nodeValue;
                var day23 = XMLHttpReq.responseXML.getElementsByTagName("str15")[0].firstChild.nodeValue;
                var day24 = XMLHttpReq.responseXML.getElementsByTagName("str16")[0].firstChild.nodeValue;
                var day25 = XMLHttpReq.responseXML.getElementsByTagName("str17")[0].firstChild.nodeValue;

                var day31 = XMLHttpReq.responseXML.getElementsByTagName("str18")[0].firstChild.nodeValue;
                var day32 = XMLHttpReq.responseXML.getElementsByTagName("str19")[0].firstChild.nodeValue;
                var day33 = XMLHttpReq.responseXML.getElementsByTagName("str20")[0].firstChild.nodeValue;
                var day34 = XMLHttpReq.responseXML.getElementsByTagName("str21")[0].firstChild.nodeValue;
                var day35 = XMLHttpReq.responseXML.getElementsByTagName("str22")[0].firstChild.nodeValue;

                var day41 = XMLHttpReq.responseXML.getElementsByTagName("str23")[0].firstChild.nodeValue;
                var day42 = XMLHttpReq.responseXML.getElementsByTagName("str24")[0].firstChild.nodeValue;
                var day43 = XMLHttpReq.responseXML.getElementsByTagName("str25")[0].firstChild.nodeValue;
                var day44 = XMLHttpReq.responseXML.getElementsByTagName("str26")[0].firstChild.nodeValue;
                var day45 = XMLHttpReq.responseXML.getElementsByTagName("str27")[0].firstChild.nodeValue;

                var day51 = XMLHttpReq.responseXML.getElementsByTagName("str28")[0].firstChild.nodeValue;
                var day52 = XMLHttpReq.responseXML.getElementsByTagName("str29")[0].firstChild.nodeValue;
                var day53 = XMLHttpReq.responseXML.getElementsByTagName("str30")[0].firstChild.nodeValue;
                var day54 = XMLHttpReq.responseXML.getElementsByTagName("str31")[0].firstChild.nodeValue;
                var day55 = XMLHttpReq.responseXML.getElementsByTagName("str32")[0].firstChild.nodeValue;

                $("#province").val(text1);
                $("#city").val(text2);
                $("#text1").val(text3);
                $("#text2").val(text4);

                $(".day1").empty();
                $(".day2").empty();
                $(".day3").empty();
                $(".day4").empty();
                $(".day5").empty();

                $(".day1").html("<li class='weatherinfo'>" + "<img src='images/" + day14 + "'/>" + "&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/" + day15 + "'/>" + "</li>" + "<li class='weatherinfo'>" + day11 + "</li>" + "<li class='weatherinfo'>" + day12 + "</li>" + "<li class='weatherinfo'>" + day13 + "</li>");
                $(".day2").html("<li class='weatherinfo'>" + "<img src='images/" + day24 + "'/>" + "&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/" + day25 + "'/>" + "</li>" + "<li class='weatherinfo'>" + day21 + "</li>" + "<li class='weatherinfo'>" + day22 + "</li>" + "<li class='weatherinfo'>" + day23 + "</li>");
                $(".day3").html("<li class='weatherinfo'>" + "<img src='images/" + day34 + "'/>" + "&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/" + day35 + "'/>" + "</li>" + "<li class='weatherinfo'>" + day31 + "</li>" + "<li class='weatherinfo'>" + day32 + "</li>" + "<li class='weatherinfo'>" + day33 + "</li>");
                $(".day4").html("<li class='weatherinfo'>" + "<img src='images/" + day44 + "'/>" + "&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/" + day45 + "'/>" + "</li>" + "<li class='weatherinfo'>" + day41 + "</li>" + "<li class='weatherinfo'>" + day42 + "</li>" + "<li class='weatherinfo'>" + day43 + "</li>");
                $(".day5").html("<li class='weatherinfo'>" + "<img src='images/" + day54 + "'/>" + "&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/" + day55 + "'/>" + "</li>" + "<li class='weatherinfo'>" + day51 + "</li>" + "<li class='weatherinfo'>" + day52 + "</li>" + "<li class='weatherinfo'>" + day53 + "</li>");
            }

        }

        var XMLHttpReq;

       
        function createXMLHttpRequest() {
            if (window.XMLHttpRequest) { 
                XMLHttpReq = new XMLHttpRequest();
            } else if (window.ActiveXObject) { 
                try {
                    XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                    }
                }
            }
        }

        
        function sendRequest() {
            createXMLHttpRequest();
            var objS = document.getElementById("pid");
          
            var value = $('#pid').val()
            var url = "queryCity?pid=" + value;
            XMLHttpReq.onreadystatechange = getCities;
            XMLHttpReq.open("GET", url, true);
            XMLHttpReq.send(null);  
        }

        
        function getCities() {
            if (XMLHttpReq.readyState == 4) { 
                if (XMLHttpReq.status == 200) {
                    DisplayHot();
                } else { 
                    window.alert("您所请求的页面有异常。");
                }
            }
        }

        function DisplayHot() {
            var info = "";
            var len = XMLHttpReq.responseXML.getElementsByTagName("name").length;
            $("#myselect").empty();
            info += "<option>" + "请输入区县" + "</option>";
            var cityId = ${cityId}
            for (var i = 0; i < len; i++) {
                var id = XMLHttpReq.responseXML.getElementsByTagName("id")[i].firstChild.nodeValue;
                var name = XMLHttpReq.responseXML.getElementsByTagName("name")[i].firstChild.nodeValue;
                if (cityId != undefined && (cityId + '') === id) {
                    info += "<option value='" + id + "' id='cid_'" + (i + 1) + " selected>" + name + "</option>";
                } else {
                    info += "<option value='" + id + "' id='cid_'" + (i + 1) + ">" + name + "</option>";
                }
            }
            $("#myselect").html(info);
        }
    </script>
</head>

<body>
<div id="weather">
    <div id="top">
        <ul class="ul1">
            <li><input type="text" id="province" placeholder="省级"/></li>
            <li><input type="text" id="city" placeholder="市/县"/></li>
        </ul>
        <ul class="ul2">
            <li>&nbsp;&nbsp;&nbsp;&nbsp;省级：
                <select id="pid" onchange="sendRequest()">
                    <option>请选择省份</option>
                    <c:forEach items="${provinces}" var="pro">
                       <option id="provinceId" value="${pro.id }">${pro.name }</option>
                    </c:forEach>
                </select>
            </li>
            <li>市/县：
                <select id="myselect">
                    <c:forEach items="${cities}" var="city">
                        option id="cityId"></option>
                    </c:forEach>
                </select>
            </li>
            <li><input type="button" name="query" value="实时查询" onclick="getWeather()"></li>
        </ul>
        <ul class="ul3">
            <li><input type="text" id="text1" placeholder="今日天气实况"/></li>
            <li><input type="text" id="text2" placeholder="紫外线强度"/></li>
        </ul>
    </div>
    <div id="bottom">
        <ul>
            <li>
                <div>
                    <ul class="day1"></ul>
                </div>
            </li>
            <li>
                <div>
                    <ul class="day2"></ul>
                </div>
            </li>
            <li>
                <div>
                    <ul class="day3"></ul>
                </div>
            </li>
            <li>
                <div>
                    <ul class="day4"></ul>
                </div>
            </li>
            <li>
                <div>
                    <ul class="day5"></ul>
                </div>
            </li>
        </ul>
    </div>
</div>

</body>
<script>
    $(function () {
        
        const proId = ${proId}
        if (proId != undefined) {
            $('#pid').val(proId);
            sendRequest()
            
            var wait = setInterval(function(){
                var city = $("#myselect").val();
                if (city !== null && city !== undefined) {
                    clearInterval(wait);
                    getWeather()
                }
            },100);

        }
    })
</script>
</html>