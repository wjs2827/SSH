<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Highcharts Example</title>

<script src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	$(function() {

		$('#container')
				.highcharts(
						{
							chart : {
								type : 'column'
							},
							title : {
								text : '大脸村蔬菜种植情况'
							},
							subtitle : {
								text : '她是一个废物'
							},
							credits: {
					            enabled: false
					        },
							colors:['#4FC23C','#116BF2','#4dd3b9','#E9F01D','#6966CC','#EA5404','#dfaca8'],
							plotOptions: {
					            column: {
					            	pointPadding: 0.2,
					        		borderWidth: 0,
					        		pointWidth: 30,
					        		stacking: 'percent'
					            }
					        },
					        legend: {
					            reversed: true 
					        },
							xAxis : {
								categories : [ '协会001', '协会002', '协会003','协会004' ]
							},
							yAxis: {
								min: 0,
								title: {
										text: '种植面积'
								}
						    },
							tooltip : {
								pointFormat : '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b>'
										+ '({point.percentage:.0f}%)<br/>',
								//:.0f 表示保留 0 位小数，详见教程：https://www.hcharts.cn/docs/basic-labels-string-formatting
								shared : true
							},
							series : [ {
								name : '小麦',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '棉花',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '玉米',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '番茄',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '谷子',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '油料',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '薯类',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '豆类',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '甜菜',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '苜蓿',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '蔬菜',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '葡萄',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '瓜类',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '果树',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '林地',
								data : [ 10, 22, 33, 44 ]
							}, {
								name : '其他',
								data : [ 10, 22, 33, 44 ]
							} ]
						});
	});
</script>
</head>
<body>
	<script src="js/highcharts.js"></script>
	<script src="js/exporting.js"></script>

	<div id="container"
		style="min-width: 800px; height: 400px; margin: 0 auto"></div>

</body>
</html>
