<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>土地查看</title>
</head>
<body>
	<div class="cl pd-20" style="background-color: #5bacb6">
		<dl style="margin-left: 80px; color: #fff">
		</dl>
	</div>
	<div class="pd-20">
		<table class="table">
			<tbody>
			    <tr>
					<th class="text-r">ID：</th>
					<td>${land.id}</td>
				</tr>
			    <tr>
					<th class="text-r">土地名称：</th>
					<td>${land.name}</td>
				</tr>
				<tr>
					<th class="text-r">土地拥有者：</th>
					<td>${land.userId}</td>
				</tr>
				<tr>
					<th class="text-r">土地大小：</th>
					<td>${land.size}</td>
				</tr>
				<tr>
					<th class="text-r">土地未使用大小：</th>
					<td>${land.unusedSize}</td>
				</tr>
				<tr>
					<th class="text-r">最小租赁面积：</th>
					<td>${land.minLease}</td>
				</tr>
				<tr>
					<th class="text-r">土地基本价格：</th>
					<td>${land.basicPrice}</td>
				</tr>
				<tr>
					<th class="text-r">土地类型类型：</th>
					<c:if test="${land.type eq 1}">
						<td>耕地</td>
					</c:if>
					<c:if test="${land.type eq 2}">
						<td>养殖地</td>
					</c:if>
					<c:if test="${land.type eq 3}">
						<td>池塘</td>
					</c:if>
				</tr>
				<tr>
					<th class="text-r">是否整体出售：</th>
					<c:if test="${land.split eq 0}">
						<td>否</td>
					</c:if>
					<c:if test="${land.split eq 1}">
						<td>是</td>
					</c:if>
				</tr>
				<tr>
					<th class="text-r">是否可种植：</th>
					<c:if test="${land.split eq 0}">
						<td>否</td>
					</c:if>
					<c:if test="${land.split eq 1}">
						<td>是</td>
					</c:if>
				</tr>
				<tr>
					<th class="text-r">省：</th>
					<td>${land.province}</td>
				</tr>
				<tr>
					<th class="text-r">市：</th>
					<td>${land.city}</td>
				</tr>
				<tr>
					<th class="text-r">区：</th>
					<td>${land.district}</td>
				</tr>
				<tr>
					<th class="text-r">土地地址：</th>
					<td>${land.address}</td>
				</tr>
				<tr>
					<th class="text-r">纬度：</th>
					<td>${land.latitude}</td>
				</tr>
				<tr>
					<th class="text-r">经度：</th>
					<td>${land.longitude}</td>
				</tr>
				<tr>
					<th class="text-r">最早时间：</th>
					<td>${land.startTime}</td>
				</tr>
				<tr>
					<th class="text-r">最晚时间：</th>
					<td>${land.endTime}</td>
				</tr>
				<tr>
					<th class="text-r">土地简介：</th>
					<td>${land.introduce}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
</body>
</html>