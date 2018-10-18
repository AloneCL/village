<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
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
<style type="text/css">
.tableImg {
	display: none;
	position: absolute;
}
</style>
<title>数据字典</title>
</head>
<body>
	<div><jsp:include page="_header.jsp" /></div>
	<div><jsp:include page="_menu.jsp" /></div>
	
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 
		首页 <span class="c-gray en">&gt;</span>
		评论管理 <span class="c-gray en">&gt;</span> 评论列表
		<a id="btn-refresh" class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.reload();" title="刷新">
			<i class="Hui-iconfont">&#xe68f;</i>
		</a>
	</nav>
	
	<div class="text-c">
			<form action="searchEvaluate.action">
				日期范围： 
				<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })"
					id="datemin" class="input-text Wdate" style="width: 120px;" name="startTime">
				- <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })"
					id="datemax" class="input-text Wdate" style="width: 120px;" name="endTime"> &nbsp;&nbsp;
				<input type="text" class="input-text" style="width: 150px" placeholder="用户ID" id="" name="userId"> &nbsp;
				<input type="text" class="input-text" style="width: 50px" placeholder="星级" id="" name="star">
				<button type="submit" class="btn btn-success radius" id="" name="">
					<i class="Hui-iconfont">&#xe665;</i> 检索
				</button>
			</form>
		</div>
	
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l"> 
			<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">
				<i class="Hui-iconfont">&#xe6e2;</i>批量删除
			</a> 
			<span style="margin:0 300px;"></span> 
		</span>
		
		<span class="r">共有数据：<strong>${dataNum}</strong> 条 </span>
	</div>
	
	<div class="mt-20">
		<form action="deleteDictionary.action" id="deleteform" method="post">
			<table class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="80">ID</th>
						<th width="90">卖家ID</th>
						<th width="90">买家ID</th>
						<th width="200">评价时间</th>
						<th width="80">评价星级</th>
						<th>查看详情</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${evaluateList}" var="eva">
						<tr class="text-c">
							<td><input type="checkbox" value="${eva.id}" name="id"></td>
							<td>${eva.id }</td>
							<td>${eva.sellerId }</td>
							<td>${eva.buyerId }</td>
							<td>${eva.createTime }</td>
							<td>${eva.star }</td>
							<td></td>
							<td class="f-14"><a style="text-decoration: none"
								onclick="window.location.href='editDictionary.action?id=${dictionary.id}'"
								href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
								<a title="删除" href="javascript:;" onclick="system_category_del(this,$(this).parent().prev().prev().prev().prev().prev().prev().prev().children(':input').val())" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<div hidden>
		<input type="file" name="upfile" id="file" accept="image/*" onchange="upload()">
	</div>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>


	<script>
		$(function() {
			
			$(".tableButton").mouseover(function() {
				$(this).next().show(100);
			}).mouseout(function() {
				$(this).next().hide(100);
			});

			$('#uploadButton').click(function() {
				imgTarget = $(this).next();
				inputTarget = $('#imgURL');
				$('#file').click();
			});

			$('.modifyImg').click(function() {
				imgTarget = $(this).next();
				inputTarget = imgTarget.next();
				$('#file').click();
			});
		});
	</script>
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
						},
						fail : function() {
							//notify('.cont-right', '设置失败', 'warning');
							alert("faile");
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

			if (imgTarget.attr('name') === 'flag') {
				//         	let scenicid = imgTarget.parent().parent().find('input[name="scenicid"]').val();
				let id = imgTarget.parent().parent().find('input[name="id"]')
						.val();
				$.ajax({
					url : "submitEditDctionary.action",
					data : {
						id : id,
						imgURL : obj.url
					},
					fail : function() {
						notify('.cont-right', '设置失败', 'warning');
						alert("faile");
					},
					success : function() {
						notify('.cont-right', '设置成功', 'success');
						alert("success");
						//window.location.url = '/backer/commonGoods.jsp';
					}
				})
			}
		}
		$('.table-sort').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 5 ]
			} // 制定列不参与排序
			]
		});
		/*数据字典-编辑*/
		function system_data_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}

		/*用户-添加*/
		function member_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}

		/*数据字典-删除*/
		function datadel() {
			layer.confirm('确认要删除这几条记录吗？', function(index) {
				document.getElementById('deleteform').submit();
			});
		}
		
		function system_category_del(obj,code){
			layer.confirm('确认要删除吗？',function(index){
				$.ajax({
					type: 'POST',
					url: '${pageContext.request.contextPath}/delDictionary.action',
					dataType: 'text',
					data:{
						id:code
					},
					success: function(data){
						$(obj).parents("tr").remove();
						layer.msg('已删除!',{icon:1,time:1000});
					},
					error:function(data) {
						$(obj).parents("tr").remove();
						layer.msg('已删除!',{icon:1,time:1000});
					},
				});
			});
		}
		
		/* 数据字典按类别筛选 */
		function selectType(value){
			if(value != -1 && value != 4){
				document.getElementById('selectForm').submit();
			} else if(value == 4){
				window.location.href = '${pageContext.request.contextPath}/dictionarylist.action';
			}
			
		}
		function myfun(){
		 　　   document.getElementById('selecttype').options[${type}].selected = true;
		}
		window.onload = myfun;
	</script>
</body>
</html>