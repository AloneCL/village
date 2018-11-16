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
<title>用户查看</title>
</head>
<body>
	<div class="cl pd-20" style="background-color: #5bacb6">
		<img class="avatar size-XL l" src="${user.imagePath}">
		<dl style="margin-left: 80px; color: #fff">
			<dt>
				ID:<span class="pl-10 f-15">${user.id}</span> <br> 用户名:<span
					class="f-15">${user.name}</span>
			</dt>
		</dl>
	</div>
	<div class="pd-20">
		<table class="table">
			<tbody>
				<tr>
					<th class="text-r">手机：</th>
					<td>${user.telephone}</td>
				</tr>
				<tr>
					<th class="text-r">密码：</th>
					<td>${user.password}</td>
				</tr>
				<tr>
					<th class="text-r">省：</th>
					<td>${user.province}</td>
				</tr>
				<tr>
					<th class="text-r">市：</th>
					<td>${user.city}</td>
				</tr>
				<tr>
					<th class="text-r">区：</th>
					<td>${user.district}</td>
				</tr>
				<tr>
					<th class="text-r">地址：</th>
					<td>${user.address}</td>
				</tr>
				<tr>
					<th class="text-r">注册时间：</th>
					<td>${user.regTime}</td>
				</tr>
				<tr>
					<th class="text-r">类型：</th>
					<c:if test="${user.userType eq 0}">
						<td>农民</td>
					</c:if>
					<c:if test="${user.userType eq 1}">
						<td>买家</td>
					</c:if>
				</tr>
				<tr>
					<th class="text-r">星级：</th>
					<td>${user.starLevel}</td>
				</tr>
				<tr>
					<th class="text-r">真实姓名：</th>

					<td>${user.realName}</td>
				</tr>
				<tr>
					<th class="text-r">身份证号：</th>
					<td>${user.idCardNumber}</td>
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