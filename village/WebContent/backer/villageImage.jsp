<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
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
<title>轮播图管理</title>
<style type="text/css">
 .tableImg {display: none;position: absolute;}
</style>
</head>
<body>
    <div><jsp:include page="_header.jsp" /></div>
    <div><jsp:include page="_menu.jsp"/></div>
	<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i> 首页
	<span class="c-gray en">&gt;</span> 轮播图中心 <span class="c-gray en">&gt;</span>
	轮播图管理 <a class="btn btn-success radius r"
		style="line-height: 1.6em; margin-top: 3px"
		href="javascript:location.replace(location.href);" title="刷新"><i
		class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div class="text-c">
			日期范围： <input type="text"
				onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })"
				id="datemin" class="input-text Wdate" style="width: 120px;">
			- <input type="text"
				onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })"
				id="datemax" class="input-text Wdate" style="width: 120px;">
			<input type="text" class="input-text" style="width: 250px"
				placeholder="输入会员名称、电话、邮箱" id="" name="">
			<button type="submit" class="btn btn-success radius" id="" name="">
				<i class="Hui-iconfont">&#xe665;</i> 搜用户
			</button>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="25">
						<th width="100">轮播图片1</th>
						<th width="100">轮播图片2</th>
						<th width="100">轮播图片3</th>
					</tr>
				</thead>
				<tbody>
						<tr class="text-c">
							<td><input name="id" type="checkbox" value="${villageImages.id}" /></td>
							<td>
                                <input type="button" class="modifyImg1 btn-primary btn tableButton1" value="设置轮播图片1"/>
                                <img class="tableImg img1" src="${villageImages.image1URL }" width="200" height="130" name="flag1"/>
                                <input type="text" name="imgurl" hidden>
                            </td>
                            
                            <td>
                                <input type="button" class="modifyImg2 btn-primary btn tableButton2" value="设置轮播图片2"/>
                                <img class="tableImg img2" src="${villageImages.image2URL }" width="200" height="130" name="flag2"/>
                                <input type="text" name="imgurl" hidden>
                            </td>
                            
                            <td>
                                <input type="button" class="modifyImg3 btn-primary btn tableButton3" value="设置轮播图片3"/>
                                <img class="tableImg img3" src="${villageImages.image3URL }" width="200" height="130" name="flag3"/>
                                <input type="text" name="imgurl" hidden>
                            </td>
						</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
    
    <div hidden>
<!--    input[file]标签的accept属性可用于指定上传文件的 MIME类型 。 -->
    <input type="file" name="upfile1" id="file1" accept="image/*" onchange="upload1()">
</div>
    
    <div hidden>
<!--    input[file]标签的accept属性可用于指定上传文件的 MIME类型 。 -->
    <input type="file" name="upfile2" id="file2" accept="image/*" onchange="upload2()">
</div>

<div hidden>
<!--    input[file]标签的accept属性可用于指定上传文件的 MIME类型 。 -->
    <input type="file" name="upfile3" id="file3" accept="image/*" onchange="upload3()">
</div>
<script>
    var imgTarget;
    var inputTarget;

    $('.modifyImg1').click(function () {
        imgTarget = $(this).next();
        inputTarget = imgTarget.next();
        $('#file1').click();
    });

    function upload1() {
        var fd = new FormData();
        fd.append( 'upfile1', $( '#file1' )[0].files[0] );
        $.ajax({
            url: 'lib/ueditor/jsp/controller.jsp?action=uploadimage',
            data: fd,
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (data) {
                let temp = data;
                updatePage1(temp);
            }
        });
    }

    function updatePage1(data) {
    	
        let obj = JSON.parse(data);

        if(obj.state === "SUCCESS"){
            inputTarget.val( obj.url );
            imgTarget.attr( 'src', obj.url );
        }
        else {
            notify('#add .modal-body','上传封面失败!', 'warning');
        }

        if (imgTarget.attr('name') === 'flag1'){
            let id = imgTarget.parent().parent().find('input[name="id"]').val();
            $.ajax({
                url: "modifyVillageImage.action",
                data: {Id:id, image1URL:obj.url},
                fail:function () {
                    notify('.cont-right', '设置失败','warning');
                },
                success: function () {
                    notify('.cont-right', '设置成功','success');
                    window.location.url = '/backer/villageImage.jsp';
                }
            })
        }
    }
    
    $('.modifyImg2').click(function () {
        imgTarget = $(this).next();
        inputTarget = imgTarget.next();
        $('#file2').click();
    });

    function upload2() {
        var fd = new FormData();
        fd.append( 'upfile2', $( '#file2' )[0].files[0] );
        $.ajax({
            url: 'lib/ueditor/jsp/controller.jsp?action=uploadimage',
            data: fd,
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (data) {
                let temp = data;
                updatePage2(temp);
            }
        });
    }

    function updatePage2(data) {
    	
        let obj = JSON.parse(data);

        if(obj.state === "SUCCESS"){
            inputTarget.val( obj.url );
            imgTarget.attr( 'src', obj.url );
        }
        else {
            notify('#add .modal-body','上传封面失败!', 'warning');
        }

        if (imgTarget.attr('name') === 'flag2'){
            let id = imgTarget.parent().parent().find('input[name="id"]').val();
            $.ajax({
                url: "modifyVillageImage.action",
                data: {Id:id, image2URL:obj.url},
                fail:function () {
                    notify('.cont-right', '设置失败','warning');
                },
                success: function () {
                    notify('.cont-right', '设置成功','success');
                    window.location.url = '/backer/villageImage.jsp';
                }
            })
        }
    }
    $('.modifyImg3').click(function () {
        imgTarget = $(this).next();
        inputTarget = imgTarget.next();
        $('#file3').click();
    });

    function upload3() {
        var fd = new FormData();
        fd.append( 'upfile3', $( '#file3' )[0].files[0] );
        $.ajax({
            url: 'lib/ueditor/jsp/controller.jsp?action=uploadimage',
            data: fd,
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (data) {
                let temp = data;
                updatePage3(temp);
            }
        });
    }

    function updatePage3(data) {
    	
        let obj = JSON.parse(data);

        if(obj.state === "SUCCESS"){
            inputTarget.val( obj.url );
            imgTarget.attr( 'src', obj.url );
        }
        else {
            notify('#add .modal-body','上传封面失败!', 'warning');
        }

        if (imgTarget.attr('name') === 'flag3'){
            let id = imgTarget.parent().parent().find('input[name="id"]').val();
            $.ajax({
                url: "modifyVillageImage.action",
                data: {Id:id, image3URL:obj.url},
                fail:function () {
                    notify('.cont-right', '设置失败','warning');
                },
                success: function () {
                    notify('.cont-right', '设置成功','success');
                    window.location.url = '/backer/villageImage.jsp';
                }
            })
        }
    }
</script>
<!-- 配置文件 -->
<script type="text/javascript" src="lib/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="lib/ueditor/ueditor.all.js"></script>
<script type="text/javascript">
    $(function () {
        $(".tableButton1").mouseover(function () {
            $(this).next().show(100);
        }).mouseout(function () {
            $(this).next().hide(100);
        });
        
        $(".tableButton2").mouseover(function () {
            $(".img2").show(100);
        }).mouseout(function () {
        	$(".img2").hide(100);
        });
        
        $(".tableButton3").mouseover(function () {
            $(".img3").show(100);
        }).mouseout(function () {
        	$(".img3").hide(100);
        });
        
//         $(".tableButton3").mouseover(function () {
//             $(this).next().show(100);
//         }).mouseout(function () {
//             $(this).next().hide(100);
//         });

    });

    var ue = UE.getEditor('content', {
        autoHeightEnabled: false
    });

    function notify(container, result, modal) {
        $(container).prepend(
            '<div class="alert alert-'
            + modal +' alert-dismissible" role="alert"> <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> <strong>'
            + result+'</strong>&nbsp; ' + message +'</div>'
        );
    }
</script>
</body>
</html>