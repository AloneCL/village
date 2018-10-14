<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--_meta 作为公共模版分离出去-->
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
        .tableImg{
           position:absolute;
           display:none;
        }
</style>
<title>添加数据字典</title>
<meta name="keywords" content="筑梦工作室村村通项目后台管理网站">
<meta name="description" content="本网站为筑梦工作室自主改良第一套后台管理模板">
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="name" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>种类：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<select class="select" id="type" name="type">
			    <option value="0">粮食</option>
			    <option value="1">蔬菜</option>
			    <option value="2">水果</option>
			    <option value="3">牲畜</option>
		</select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>成熟所需时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="大概成熟需要的月数" name="growTime" id="growTime" onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">封面图：</label>
			<div class="formControls col-xs-8 col-sm-9"> <!-- <span class="btn-upload form-group"> -->
			
		    <input type="button" class="btn btn-primary radius tableButton" value="设置封面" id="uploadButton"/>
			<img class="tableImg" src="" width="180" height="110" name="flag"/>
			<input type="text" name="imgURL" id="imgURL" hidden>
								
				<!-- <input class="input-text upload-url" type="text" name="" id="" readonly nullmsg="请添加附件！" style="width:200px">
				<img class="tableImg" src=imgurl1 width="200" height="130" name="flag"/>
				<a href="javascript:void();" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
				</span>  --></div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">商品介绍：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="introduce" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
	<div hidden>
		<!--    input[file]标签的accept属性可用于指定上传文件的 MIME类型 。 -->
		<input type="file" name="upfile" id="file" accept="image/*"
			onchange="upload()">
	</div>
</article>


	<script type="text/javascript">
		var imgTarget;
		var inputTarget;

		function upload() {
			var fd = new FormData();
			fd.append('upfile', $('#file')[0].files[0]);
			$.ajax({
				url : 'lib/ueditor/1.4.3/jsp/controller.jsp?action=uploadimage',
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
			//     	var path = System.getProperty("evan.webapp");

			let obj = JSON.parse(data);
			//         var url = path+"/"+obj.url;
			if (obj.state === "SUCCESS") {
				inputTarget.val(obj.url);
				imgTarget.attr('src', obj.url);
			} else {
				notify('#add .modal-body', '上传封面失败!', 'warning');
			}
		}
 </script>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$(function(){
	$('#uploadButton').click(function() {
		imgTarget = $(this).next();
		inputTarget = $('#imgURL');
		$('#file').click();
	});
	
	$('.tableButton').mouseover(function() {
		$(this).next().show(100);
	}).mouseout(function() {
		$(this).next().hide(100);
	});
	
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").validate({
		rules:{
			name:{
				required:true,
				minlength:2,
				maxlength:16
			},
			growTime:{
				required:true,
			},
			uploadfile:{
				required:true,
			},
			
		} ,
		submitHandler:function(form){
			save();
			alert("增加成功");
		}
	});
	
	function save(){    
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/addDictionary.action",
            data: $("#form-member-add").serialize(),//序列化表单数据
            complete: function() {
            	window.parent.location.reload();//关闭弹窗
            }
        });
    }

});
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>