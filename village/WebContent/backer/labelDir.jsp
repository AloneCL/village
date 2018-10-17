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
<title>数据字典</title>
</head>
<body>
	<div><jsp:include page="_header.jsp" /></div>
	<div><jsp:include page="_menu.jsp" /></div>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		系统管理 <span class="c-gray en">&gt;</span> 标签管理 <a id="btn-refresh"
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.reload();" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l"> <a href="javascript:;" onclick="datadel()"
			class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
				批量删除</a> <a href="javascript:;"
			onclick="member_add('添加标签',' ${pageContext.request.contextPath}/addLabelDir.jsp','','200')"
			class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
				添加标签</a>
		 <span style="margin:0 300px;"></span> 
		</span> <span class="r">共有数据：<strong>${dataNum}</strong> 条
		</span>
	</div>
	<div class="mt-20">
		<form action="deleteLabelDir.action" id="deleteform" method="post">
			<table
				class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="80">ID</th>
						<th>标签名称</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${labelDir}" var="labeldir" varStatus="idxStatus">
						<tr class="text-c">
							<td><input type="checkbox" value="${labeldir.id}" name="id"></td>
							<td>${labeldir.id }</td>
							<td class="text-l">${labeldir.name }</td>
							<td class="f-14"><a title="编辑" href="javascript:;"
								onclick="confirmUpdateAward(this)" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe6df;</i></a> <a title="删除"
								href="javascript:;"
								onclick="system_category_del(this,$(this).parent().prev().prev().prev().children(':input').val())"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe6e2;</i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	</div>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
	
		$('.table-sort').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 2 ]
			} // 制定列不参与排序
			]
		});
		/*标签-编辑*/
		function system_data_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		
		function confirmUpdateAward(obj) {
			//获得前一列输出的值 
			var oldName = $(obj).parent().prev().text();
			var i = $(obj).parent().prev().prev().prev().children(':input').val();
			//alert(num);
		    layer.open({
		        type: 1,
		        closeBtn: false,
		        shift: 7,
		        shadeClose: true,
		        content: "<div style='width:350px;'><div style='width:320px;margin-left: 3%;' class='text-c'><p>请输入新的名称</p><input type='text' class='input-text' value="+oldName+" placeholder='新标签名称' id='updateName' name='updateName'></div>" +
		        "<button style='margin-top:5%;' type='button' class='btn btn-block btn-success btn-lg' onclick='updateAward("+i+")'>提交</button></div>"
		    });
		}
		
			function updateAward(awardId){
		        var awardName = $("#updateName").val();
		        $.ajax({
		            type: "post",
		            url :"${pageContext.request.contextPath}/submitEditLabelDir.action",
		            dataType:'text',
		            data: {
		                id:awardId,
		                name:awardName
		            },
		            success: function(data){
		                //var updateSuccess = data.data;
		                //if(updateSuccess){
		                    layer.msg('修改成功', {
		                        time: 500, //0.5s后自动关闭
		                        // btn: ['明白了', '知道了']
		                    });
		                    //refreshPage();
		                    setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                              window.location.reload();//页面刷新
                              },500)
		                    /* } else{
		                    layer.msg('修改失败', {
		                        time: 500, //20s后自动关闭
		                        // btn: ['明白了', '知道了']
		                    });
		                } */
		            }
		        });
		        //layer.closeAll();
		}
		

		/*标签-添加*/
		function member_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}

		/*标签-删除*/
		function datadel() {
			var a = document.getElementsByName('id');
			var n = a.length;
			var k = 0 ;
			for (var i=0; i<n; i++){
		        if(a[i].checked){
		            k = 1;
		        }
		    }
		        if(k==0){
		        alert("请选择要删除的记录!");
		        return;
		    }else{
			layer.confirm('确认要删除这几条记录吗？', function(index) {
				document.getElementById('deleteform').submit();
			});
			//${"#deletefrom"}.submit();
		}
		}
		
		function system_category_del(obj,code){
			//var code = document.getElementByName("id").value;
			//alert(code);
			layer.confirm('确认要删除吗？',function(index){
				$.ajax({
					type: 'POST',
					url: '${pageContext.request.contextPath}/delLabelDir.action',
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
		
	</script>
</body>
</html>