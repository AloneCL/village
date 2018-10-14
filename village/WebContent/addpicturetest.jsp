<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="static/css/testOnline-programmer.css"/>
    <script src="http://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>景区管理</title>
</head>
<body style="background-color: #E5E5E5;padding: 0px;">
<div>
    <style>
        * {color: #262626;}
        .tableImg{
           position:absolute;
           display:none;
        }
    </style>

            <hr/>
            <!-- <input type="text" class="form-input" placeholder="关键字"/>
            <button class="form-button">搜索</button>
            <button class="form-button-default">重置</button>
            <hr /> -->
             <%String imgurl1 = "lsajdfk"; %>
                                <input type="button" class="modifyImg form-button2 tableButton" value="设置封面"/>
                                <img class="tableImg" src=imgurl1 width="200" height="130" name="flag"/>
                                <input type="text" name="imgurl" hidden>
        </div>


</div>


<div hidden>
    <input type="file" name="upfile" id="file" accept="image/*" onchange="upload()">
</div>
<script>
    var imgTarget;
    var inputTarget;

    $('#uploadButton').click(function () {
        imgTarget = $(this).next();
        inputTarget = $('#imgurl');
        $('#file').click();
    });
    $('.modifyImg').click(function () {
        imgTarget = $(this).next();
        inputTarget = imgTarget.next();
        $('#file').click();
    });

    function upload() {
        var fd = new FormData();
        fd.append( 'upfile', $( '#file' )[0].files[0] );
        $.ajax({
            url: 'lib/ueditor/1.4.3/jsp/controller.jsp?action=uploadimage',
            data: fd,
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (data) {
                let temp = data;
                updatePage(temp);
            }
        });
    }

    function updatePage(data) {
        let obj = JSON.parse(data);
        if(obj.state === "SUCCESS"){
            inputTarget.val( obj.url );
            imgTarget.attr( 'src', obj.url );
            alert("上传成功");
        }
        else {
            notify('#add .modal-body','上传封面失败!', 'warning');
        }

    }
    
    $(function(){
    	$(".tableButton").mouseover(function(){
    		$(this).next().show(100);
    	}).mouseout(function(){
    		$(this).next().hide(100);
    	});
    });
</script>

</body>
</html>
