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
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		系统管理 <span class="c-gray en">&gt;</span> 数据字典 <a id="btn-refresh"
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.reload();" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>

	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l"> <a href="javascript:;" onclick="datadel()"
			class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
				批量删除</a> <a href="javascript:;"
			onclick="member_add('添加数据',' ${pageContext.request.contextPath}/addDictionary.jsp','','510')"
			class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
				添加字典</a>
		 <span style="margin:0 300px;"></span> 
		</span> 按类型筛选: <span class="select-box inline"> 
		<form action="${pageContext.request.contextPath}/getDictionaryByType.action" id="selectForm" method="post">
		<select class="select"
			id="selecttype" name="type" onblur="selectType(this.value)">
				<option value="-1">选择类型</option>
				<option value="0">粮食</option>
				<option value="1">蔬菜</option>
				<option value="2">水果</option>
				<option value="3">牲畜</option>
				<option value="4">所有类型</option>
		</select>
		<!-- <input type="submit" name="g" value="Submit提交" id="g" /> -->
		</form>
		</span> <span class="r">共有数据：<strong>${dataNum}</strong> 条
		</span>
	</div>
	<div class="mt-20">
		<form action="deleteDictionary.action" id="deleteform" method="post">
			<table
				class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="80">ID</th>
						<th width="90">名称</th>
						<th width="90">类型</th>
						<th width="95">图片</th>
						<th width="80">成熟时间</th>
						<th>介绍</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dictionary}" var="dictionary">
						<tr class="text-c">
							<td><input type="checkbox" value="${dictionary.id}"
								name="id"></td>
							<td>${dictionary.id}</td>
							<td>${dictionary.name}</td>
							<td><c:choose>
									<c:when test="${dictionary.type==0}">粮食</c:when>
									<c:when test="${dictionary.type==1}">蔬菜</c:when>
									<c:when test="${dictionary.type==2}">水果</c:when>
									<c:when test="${dictionary.type==3}">牲畜</c:when>
									<c:otherwise>其他</c:otherwise>
								</c:choose></td>
							<%-- <td>${dictionary.imgURL}</td> --%>
							<td><input type="button"
								class="btn btn-primary radius tableButton modifyImg"
								value="设置封面" /> 
								<img class="tableImg" src="${dictionary.imgURL}"
								width="180" height="110" name="flag" /> 
								<input type="text" name="imgURL" hidden></td>

							<td>${dictionary.growTime}</td>
							<td>${dictionary.introduce}</td>
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
		<input type="file" name="upfile" id="file" accept="image/*"
			onchange="upload()">
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
			//${"#deletefrom"}.submit();

		}
		
		function system_category_del(obj,code){
			//var code = document.getElementByName("id").value;
			//alert(code);
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
			/* 	$.ajax({
					type:'post',
					url:'getDictionaryByType.action',
					data:value,
					async:false,
				    success:function(){
				    	alert("刷新成功！");
				    	 window.location.href = '${pageContext.request.contextPath}/backer/dictionary.jsp';
				    },
				    error:function(){
				    	alert("刷新失败!");
				    }
				}); */
			
		}
		function myfun()
		　　{
		 　　   document.getElementById('selecttype').options[${type}].selected = true;
		　　}
		window.onload = myfun;
	</script>
</body>
</html>