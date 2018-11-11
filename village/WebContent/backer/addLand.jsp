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
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />

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
<link href="lib/upload/upload.css" rel="stylesheet" type="text/css" />

<title>添加土地 - H-ui.admin v3.1</title>
<meta name="keywords"
	content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">

</head>
<body>
	<article class="page-container">
	<form action="addLand.action" method="post"
		class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder=""
					id="name" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">土地拥有者：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box"> <select class="select" size="1"
					name="userId" id="userId">
						<option value="" selected>请选择用户</option>
						<option value="">ID&emsp;&emsp;&emsp;&emsp;&emsp;用户名称
							&emsp;&emsp;&emsp;&emsp;&emsp;电话号码</option>
						<c:forEach items="${land_users}" var="user">
							<option value="${user.id}">${user.id}&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;
								${user.name}&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${user.telephone}</option>
						</c:forEach>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地大小：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder=""
					id="size" name="size">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>最小租赁面积：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder=""
					id="minLease" name="minLease">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地基本价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder=""
					id="basicPrice" name="basicPrice">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">土地类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box"> <select class="select" size="1"
					name="type" id="type">
						<option value="" selected>请选择类型</option>
						<option value="1">耕地</option>
						<option value="2">养殖地</option>
						<option value="3">池塘</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">是否整体出售：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box"> <select class="select" size="1"
					name="split" id="split">
						<option value="" selected>请选择是否</option>
						<option value="1">是</option>
						<option value="0">否</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">是否可种植：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box"> <select class="select" size="1"
					name="status" id="status">
						<option value="" selected>请选择是否</option>
						<option value="1">是</option>
						<option value="0">否</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div id="target">
					<select id="eprovinceName" name="province"></select> <select
						id="ecityName" name="city"></select> <select id="edistrictName"
						name="district"></select>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地详细地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder=""
					id="address" name="address">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>最早时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder=""
					id="date1" name="startTime">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>最晚时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder=""
					id="date2" name="endTime">
			</div>
		</div>

        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地纬度：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" 
				id="latitude" name="latitude">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地经度：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" 
				id="longitude" name="longitude">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<a href="javascript:;" class="file">上传土地图片 <input type="text"
					name="imgURL" id="imgurl"></a>
				<div class="gallery" id="gallery"></div>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地证书图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<a href="javascript:;" class="file">上传土地证书图片 <input type="text"
					name="certificateURL" id="certificateURL"></a>
				<div class="gallery" id="gallery1"></div>
			</div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit"
					value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
	</article>
	<div hidden>
		<!--    input[file]标签的accept属性可用于指定上传文件的 MIME类型 。 -->
		<input type="file" name="upfile" id="file" accept="image/*"
			multiple="multiple" />
	</div>

	<div hidden>
		<!--    input[file]标签的accept属性可用于指定上传文件的 MIME类型 。 -->
		<input type="file" name="upfile" id="file1" accept="image/*"
			multiple="multiple" />
	</div>

	<script src="lib/laydate/laydate.js"></script>
	<script>
		laydate.render({
			elem : '#date1',
			type : 'datetime'
		});
		laydate.render({
			elem : '#date2',
			type : 'datetime'
		});
	</script>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
	<script type="text/javascript" src="lib/upload/upload-ueditor.js"></script>

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript">
		//document.getElementById("form-member-add").onsubmit = function() {upload()};
		$(function() {
			$('#target').distpicker({
				province : '--请选择省份--',
				city : '--请选择市--',
				district : '--请选择区/县--',
				autoSelect:false
			});
			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});

			$("#form-member-add").validate({
				rules : {
					name : {
						required : true,
						minlength : 2,
						maxlength : 16
					},
					type : {
						required : true
					},
					latitude : {
						number : true
					},
					longitude : {
						number : true
					},
					size : {
						number : true
					},
					minLease : {
						number : true
					},
					basicPrice : {
						number : true
					},
					userId : {
						required : true
					},
					status : {
						required : true
					}

				},
				onkeyup : false,
				focusCleanup : true,
				success : "valid",
				submitHandler : function(form) {
					$(form).ajaxSubmit(function() {
						window.parent.location.reload();
						var index = parent.layer.getFrameIndex(window.name);
						parent.layer.close(index);
					});
				}
			});
		});
		document.getElementById("form-member-add").onsubmit = function() {
			//$("#form-member-add").valid()
			if ($("#form-member-add").validate().form()) {
				upload();
				upload1();
			}
		};
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
	
	<!-- distpicker地址插件-->
	<script type="text/javascript"
		src="lib/distpicker/dist/distpicker.min.js"></script>

</body>
</html>