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
<!--/meta 作为公共模版分离出去-->

<title>编辑土地 - H-ui.admin v3.1</title>
<meta name="keywords"
	content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
	<article class="page-container">
	<form action="modifyLand.action" method="post"
		class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>ID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${land.id}"
					placeholder="" name="id" readonly="readonly">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${land.name}"
					placeholder="" name="name" id="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">土地拥有者：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box"> <select class="select" size="1"
					name="userId" id="userId">
						<option value="${land.userId}"selected>${land.userId}</option>
						<option value="">ID&emsp;&emsp;&emsp;&emsp;&emsp;用户名称
							&emsp;&emsp;&emsp;&emsp;&emsp;电话号码</option>
						<c:forEach items="${land_user}" var="user">
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
				<input type="text" class="input-text" value="${land.size}" placeholder=""
					id="size" name="size">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地未使用大小：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${land.unusedSize}" placeholder=""
					id="unusedSize" name="unusedSize">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>最小租赁面积：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${land.minLease}" placeholder=""
					id="minLease" name="minLease">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地基本价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${land.basicPrice}" placeholder=""
					id="basicPrice" name="basicPrice">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">土地类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box"> <select class="select" size="1"
					name="type" id="type">
						<c:if test="${land.type eq 1}">
							<option value="1" selected>耕地</option>
							<option value="2">养殖地</option>
						     <option value="3">池塘</option>
						</c:if>
						<c:if test="${land.type eq 2}">
							<option value="2" selected>养殖地</option>
							<option value="1">耕地</option>
						     <option value="3">池塘</option>
						</c:if>
						<c:if test="${land.type eq 3}">
							<option value="3" selected>池塘</option>
							<option value="1">耕地</option>
						     <option value="2">养殖地</option>
						</c:if>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">是否整体出售：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box"> <select class="select" size="1"
					name="split" id="split">
						<c:if test="${land.split eq 0}">
							<option value="0" selected>否</option>
							<option value="1">是</option>
						</c:if>
						<c:if test="${land.split eq 1}">
							<option value="1" selected>是</option>
							<option value="0">否</option>
						</c:if>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">是否可种植：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box"> <select class="select" size="1"
					name="status" id="status">
						<c:if test="${land.status eq 0}">
							<option value="0" selected>否</option>
							<option value="1">是</option>
						</c:if>
						<c:if test="${land.status eq 1}">
							<option value="1" selected>是</option>
							<option value="0">否</option>
						</c:if>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div data-toggle="distpicker">
					<select data-province="${land.province}" name="province"></select> 
					<select data-city="${land.city}" name="city"></select> 
					<select data-district="${land.district}" name="district"></select>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地详细地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${land.address}" placeholder=""
					id="address" name="address">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">土地简介：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="introduce"  value="${land.introduce}"  cols="" rows="" class="textarea"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>最早时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${land.startTime}" placeholder=""
					id="date1" name="startTime">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>最晚时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${land.endTime}" placeholder=""
					id="date2" name="endTime">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地纬度：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${land.latitude}" 
				id="latitude" name="latitude">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>土地经度：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${land.longitude}" 
				id="longitude" name="longitude">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red"></span>图片显示</label>
			<div class="formControls col-xs-8 col-sm-9">
				<ul id="uploadimg">
				<c:forTokens items="${land.imgURL}" delims="&" var="MouGe">
				<li style="list-type:none">
				<img alt="" src="${MouGe}" style="float:left; width:150px; height:100px; text-align:center;">
				</li>
				</c:forTokens>
				</ul>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" id="submit"
					value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
	</article>
	<div hidden>
		<!--    input[file]标签的accept属性可用于指定上传文件的 MIME类型 。 -->
		<input type="file" name="upfile" id="file" accept="image/*"
			onchange="upload()">
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
	<!--/_footer 作为公共模版分离出去-->

	<script type="text/javascript">
		var imgTarget;
		var inputTarget;

		$('#uploadButton').click(function() {
			imgTarget = $(this).next();
			inputTarget = $('#imgurl');
			$('#file').click();
		});

		$("#imgurl").click(function() {

			imgTarget = $(this).next();
			inputTarget = $('#imgurl');
			$('#file').click();
		});
		function upload() {
			var fd = new FormData();
			fd.append('upfile', $('#file')[0].files[0]);
			$.ajax({
				url : 'lib/ueditor/jsp/controller.jsp?action=uploadimage',
				data : fd,
				processData : false,
				contentType : false,
				type : 'POST',
				success : function(data) {
					let temp = data;
					updatePage(temp);
				}
			});
		}

		function updatePage(data) {
			let obj = JSON.parse(data);
			if (obj.state === "SUCCESS") {
				inputTarget.val(obj.url);
				imgTarget.attr('src', obj.url);

			} else {
				notify('#add .modal-body', '上传封面失败!', 'warning');
			}

			if (imgTarget.attr('name') === 'flag') {
				let id = imgTarget.parent().parent().find('input[name="id"]')
						.val();
				$.ajax({
					url : "modifyLand.action",
					data : {
						id : id,
						imagePath : obj.url
					},
					fail : function() {
						notify('.cont-right', '设置失败', 'warning');
					},
					success : function() {
						notify('.cont-right', '设置成功', 'success');
					}
				})
			}
		}
	</script>

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
		$(function() {
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
					unusedSize : {
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
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
	
	<!-- distpicker地址插件-->
	<script type="text/javascript"
		src="lib/distpicker/dist/distpicker.min.js"></script>
</body>
</html>