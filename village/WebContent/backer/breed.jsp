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
<title>养殖管理</title>
</head>
<body>
    <div><jsp:include page="_header.jsp" /></div>
    <div><jsp:include page="_menu.jsp"/></div>
	<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i> 首页
	<span class="c-gray en">&gt;</span> 养殖中心 <span class="c-gray en">&gt;</span>
	养殖管理 <a class="btn btn-success radius r"
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
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;" onclick="datadel()"
				class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
					批量删除</a> <a href="javascript:;"
				onclick="breed_add('添加养殖','submitEditBreed.action','','510')"
				class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
					添加养殖</a></span> <span class="r">共有数据：<strong>88</strong> 条
			</span>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="25">
						<th width="100">字典ID</th>
						<th width="100">土地Id</th>
						<th width="100">单位价格</th>
						<th width="100">最小保证重量</th>
						<th width="100">最大保证重量</th>
						<th width="50">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${breeds}" var="breed">
						<tr class="text-c">
							<td><input name="id" type="checkbox" value="${breed.id}" /></td>
							<td>${breed.dirId}</td>
							<td>${breed.landId}</td>
							<td>${breed.price}</td>
							<td>${breed.minWeight}</td>
							<td>${breed.maxWeight}</td>
							<td class="td-manage"><a title="编辑" href="javascript:;"
								onclick="breed_edit('编辑','editBreed.action?id=${breed.id}')"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe6df;</i></a> <a title="删除"
								href="javascript:;"
								onclick="breed_del(this,'deleteBreed.action?id=${breed.id}')"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe6e2;</i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<!-- <script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> -->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
		$(function() {
			$('.table-sort').dataTable({
				"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
				"bStateSave" : true,//状态保存
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0, 6 ]
				} // 制定列不参与排序
				]
			});

		});
		/*养殖-添加*/
		function breed_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*养殖-查看*/
		function breed_show(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*养殖-编辑*/
		function breed_edit(title, url) {
			var index = layer.open({
				type: 2,
				title: title,
				content: url
			});
			layer.full(index);
		}
		
		function datadel(){
			obj = document.getElementsByName("id"); 
		    check_val = []; 
		    for(k in obj){ 
		        if(obj[k].checked) 
		            check_val.push(obj[k].value); 
		    }
		    if(check_val!=0){
		    	layer.confirm('确认要删除吗？', function(index) {
					$.ajax({
						type : 'POST',
						url : 'deleteManyBreed.action?id='+check_val,
						success : function() {
							layer.msg('已删除!', {
								icon : 1,
								time : 2000
							});
							window.location.reload();
						},
						error : function() {
							console.log(data.msg);
						},
					});
				});
		    }
		    else{
		    	layer.alert('请选择要删除的用户!', {
					icon : 6,
				});
		    }
		}
		
		/*养殖-删除*/
		function breed_del(obj, url) {
			layer.confirm('确认要删除吗？', function(index) {
				$.ajax({
					type : 'POST',
					url : url,
					success : function(data) {
						layer.msg('已删除!', {
							icon : 1,
							time : 2000
						});
						window.location.reload();
					},
					error : function(data) {
						console.log(data.msg);
					},
				});
			});
		}
	</script>
</body>
</html>