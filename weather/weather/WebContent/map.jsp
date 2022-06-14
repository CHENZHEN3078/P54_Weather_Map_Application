
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>地图</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <!-- 统计图表Echarts -->
    <script src="static/echarts/echarts.js"></script>
    <script src="static/echarts/theme/default.js"></script>
    <script src="static/echarts/map/china.js"></script>
</head>
<body>
<div id="main" style="height: 600px;width: 1200px;"></div>
<div id="main1" style="height: 400px;width: 1200px;"></div>

<script>
    function randomData() {
        return Math.round(Math.random()*500);
    }
    var mydata = [
        {name: '北京', value: '100'}, {name: '天津', value: randomData()},
        {name: '上海', value: randomData()}, {name: '重庆', value: randomData()},
        {name: '河北', value: randomData()}, {name: '河南', value: randomData()},
        {name: '云南', value: randomData()}, {name: '辽宁', value: randomData()},
        {name: '黑龙江', value: randomData()}, {name: '湖南', value: randomData()},
        {name: '安徽', value: randomData()}, {name: '山东', value: randomData()},
        {name: '新疆', value: randomData()}, {name: '江苏', value: randomData()},
        {name: '浙江', value: randomData()}, {name: '江西', value: randomData()},
        {name: '湖北', value: randomData()}, {name: '广西', value: randomData()},
        {name: '甘肃', value: randomData()}, {name: '山西', value: randomData()},
        {name: '内蒙古', value: randomData()}, {name: '陕西', value: randomData()},
        {name: '吉林', value: randomData()}, {name: '福建', value: randomData()},
        {name: '贵州', value: randomData()}, {name: '广东', value: randomData()},
        {name: '青海', value: randomData()}, {name: '西藏', value: randomData()},
        {name: '四川', value: randomData()}, {name: '宁夏', value: randomData()},
        {name: '海南', value: randomData()}, {name: '台湾', value: randomData()},
        {name: '香港', value: randomData()}, {name: '澳门', value: randomData()}
    ];
    var optionMap = {
        backgroundColor: '#FFFFFF',
        title: {
            text: '全国省份地图',
            subtext: '',
            x: 'center'
        },
        tooltip: {
            trigger: 'item'
        },

       
        visualMap: {
            show: true,
            x: 'left',
            y: 'center',
           
        },

       
        series: [{
            name: '省份',
            type: 'map',
            mapType: 'china',
            roam: true,
            label: {
                normal: {
                    show: true 
                },
                emphasis: {
                    show: false
                }
            },
            data: [] 
        }]
    };

    var XMLHttpReq;
   
    function createXMLHttpRequest() {
        if(window.XMLHttpRequest) { 
            XMLHttpReq = new XMLHttpRequest();
        }
        else if (window.ActiveXObject) { 
            try {
                XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {}
            }
        }
    }

    $(function () {
        const data = ${provinces};
        mydata = data
        optionMap.series[0].data = mydata
       
        var myChart = echarts.init(document.getElementById('main'));
        
        myChart.setOption(optionMap);
       
        myChart.on('click', function (param) {
            console.log(param.data)
            goProvince(param);
        })
    });

   
    function goProvince(param){
        
        $.ajax({
            url: 'queryCityByProvince?pid=' + param.value,
            type: 'post',
            dataType: 'json',
            success: function (data) {
                console.log(data)
                var eName = ''
                if (param.name == '山西') {
                    eName = 'shanxi'
                } else if (param.name == '陕西') {
                    eName = 'shanxi1'
                } else if (param.name == '北京') {
                    eName = 'beijing'
                } else if (param.name == '安徽') {
                    eName = 'anhui'
                } else if (param.name == '澳门') {
                    eName = 'aomen'
                } else if (param.name == ' 重庆') {
                    eName = 'chongqing'
                } else if (param.name == '福建') {
                    eName = 'fujian'
                } else if (param.name == '甘肃') {
                    eName = 'gansu'
                } else if (param.name == '广东') {
                    eName = 'guangdong'
                } else if (param.name == '广西') {
                    eName = 'guangxi'
                } else if (param.name == '贵州') {
                    eName = 'guizhou'
                } else if (param.name == '海南') {
                    eName = 'hainan'
                } else if (param.name == '河北') {
                    eName = 'hebei'
                }else if (param.name == '黑龙江') {
                    eName = 'heilongjiang'
                }else if (param.name == '河南') {
                    eName = 'henan'
                }else if (param.name == '湖北') {
                    eName = 'hubei'
                }else if (param.name == '湖南') {
                    eName = 'hunan'
                }else if (param.name == '江苏') {
                    eName = 'jiangsu'
                }else if (param.name == '江西') {
                    eName = 'jiangxi'
                }else if (param.name == '吉林') {
                    eName = 'jilin'
                }else if (param.name == '辽宁') {
                    eName = 'liaoning'
                }else if (param.name == '内蒙古') {
                    eName = 'neimenggu'
                }else if (param.name == '宁夏') {
                    eName = 'ningxia'
                }else if (param.name == '青海') {
                    eName = 'qinghai'
                }else if (param.name == '山东') {
                    eName = 'shandong'
                }else if (param.name == '上海') {
                    eName = 'shanghai'
                }else if (param.name == '四川') {
                    eName = 'sichuan'
                }else if (param.name == '台湾') {
                    eName = 'taiwan'
                }else if (param.name == '天津') {
                    eName = 'tianjin'
                }else if (param.name == '香港') {
                    eName = 'xianggang'
                }else if (param.name == '新疆') {
                    eName = 'xinjiang'
                }else if (param.name == '西藏') {
                    eName = 'xizang'
                }else if (param.name == '云南') {
                    eName = 'yunnan'
                }else if (param.name == '浙江') {
                    eName = 'zhejiang'
                }
                var myChart1 = echarts.init(document.getElementById('main1'));
                $.getJSON('static/echarts/map/province/' + eName + '.json', function (geoJson) {
                    myChart1.hideLoading();
                    echarts.registerMap((param.name), geoJson);
                    var option = {
                        backgroundColor: '#FFFFFF',
                        tooltip : {
                            trigger: 'item'
                        },
                        title: {
                            text: param.name + '省城市',
                            subtext: '',
                            x: 'center'
                        },
                        
                        visualMap: {
                            left: 'left',
                            top: 'top',
                            show: true,
                           
                        },
                       
                        series: [{
                            name: '城市',
                            type: 'map',
                            mapType: (param.name), 
                            roam: true, 
                            label: {
                                normal: {
                                    show: true  
                                },
                                emphasis: {
                                    show: false
                                }
                            },
                            data: []  
                        }]
                    };
                   
                    myChart1.setOption(option);
                    
                    myChart1.on('click', function (params) {
                        
                        console.log(params)
                        var city = params.name.substring(0, params.name.length-1)
                        console.log(city)
                        
                        var cityId
                        for (var i=0; i<data.length; i++) {
                            if (city === data[i].name) {
                                console.log(data[i])
                                cityId = data[i].value
                                break
                            }
                        }
                        if (cityId != null && cityId != undefined) {
                            window.location.href = 'queryProvince?cityId=' + cityId + '&provinceId=' + param.value
                        }
                    });
                });
            }
        });
    }
</script>
</body>

</html>
