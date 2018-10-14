
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet"
	type="text/css" />
<link href="static/h-ui.admin/css/H-ui.login.css" rel="stylesheet"
	type="text/css" />
<link href="static/h-ui.admin/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet"
	type="text/css" />

<title>后台登录</title>
<meta name="keywords" content="筑梦工作室村村通项目后台管理网站">
<meta name="description" content="本网站为筑梦工作室自主改良第一套后台管理模板">
</head>
<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header"></div>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal" action="submitLogin.action"
				method="post" id="loginForm">
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input id="username" name="username" type="text" placeholder="账户"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input id="password" name="password" type="password"
							placeholder="密码" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"></label>
					<div class="formControls col-xs-8 col-xs-offset-3" >
						<select id="type" name="type">
							<option value="1">管理员登录</option>
							<option value="0">审核员登录</option>
						</select>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input id="validateCode" name="validateCode"
							class="input-text size-L" type="text" placeholder="验证码"
							onblur="if(this.value!=''){checkImg(this.value)}" value=""
							style="width: 150px;"> <img id="codeValidateImg"
							src="${pageContext.request.contextPath}/DrawImage/draw.action"
							onclick="changeImg('nl')"> <a id="kanbuq"
							onclick="changeImg('nl')">看不清，换一张</a>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input id="submit" name="" type="submit"
							class="btn btn-success radius size-L"
							value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"> <input
							id="reset" name="" type="reset"
							class="btn btn-default radius size-L"
							value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">Copyright 筑梦工作室 by admin v3.1</div>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
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
		function changeImg(createTypeFlag) {
			document.getElementById("codeValidateImg").src = "${pageContext.request.contextPath}/DrawImage/draw.action?createTypeFlag="
					+ createTypeFlag + "&" + Math.random();
		}

		$(function() {
			$("#loginForm").validate({
				rules : {
					username : {
						required : true,
						minlength : 2,
						maxlength : 16
					},
					password : {
						required : true,
					},
					validateCode : {
						required : true,
					},

				},
				submitHandler : function(form) {
					form.submit();
				}
			});

		});
		/* $('#submit').click(function() {
			alert(11111);
			if (document.getElementById("username").value.length == 0||
					document.getElementById("password").value.length == 0){
				alert("用户名和密码不能为空!!");
				//document.focus();
				return false;
			}
			else 
			$('#loginform').submit();
		});
			
		/*校验验证码输入是否正确*/
		function checkImg(code) {
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/Check/check.action",
				data : {
					validateCode : code
				},
				dataType : "text",
				success : function(data) {
					if (data == "error") {
						$('#validateCode').value = '';
						alert("验证码错误！");
						changeImg("nl");
					}
				},
				error : function(data) {
					if (data == "error") {
						$('#validateCode').value = '';
						changeImg("nl");
					}
				}
			});
			/*  var url = "${pageContext.request.contextPath}/Check/check.action";
			 $.post(url,{"validateCode":code},function(data){
				 alert(111);
			 if(data=="ok"){
			 alert("ok!");
			 }else{
			 alert("error!");
			 changeImg("nl");
			 }
			 });  */
		}
	</script>

</body>
<c:if test="${not empty error }">
	<script type="text/javascript">
		alert('${error}')
	</script>
</c:if>
</html>
