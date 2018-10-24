var imgTarget;
var inputTarget;
var imgTarget1;
var inputTarget1;
var files=new Array();
var files1=new Array();
var id = 0;
var k  = 0;

		 $("#imgurl").click(function() {
			imgTarget = $(this).next();
			inputTarget = $('#imgurl');
			$('#file').click();
		});
		 
		 $("#certificateURL").click(function() {
				imgTarget1 = $(this).next();
				inputTarget1 = $('#certificateURL');
				$('#file1').click();
			});
		
		 $("#file").change(function() {
				// 获取所有图片
				var img = document.getElementById("file").files;
				// 遍历
				for (var i = 0; i < img.length; i++) {
					// 得到图片
					var file = img[i];
					// 把图片存到数组中
					files[id] = file;
					id++;
					// 获取图片路径
					var url = URL.createObjectURL(file);
					// 创建img
					var box = document.createElement("img");
					box.setAttribute("src", url);
					box.setAttribute("style", "width:100px;margin:20px;");
					//box.className = 'img';
					// 创建div
				    var imgBox = document.createElement("div");
					imgBox.style.display = 'inline-block';
					imgBox.className = 'img-item';
					// 创建span
					var deleteIcon = document.createElement("span");
					deleteIcon.className = 'delete';
					deleteIcon.innerText = 'x';
					// 把图片名绑定到data里面
					deleteIcon.id = img[i].name;
					// 把img和span加入到div中
					imgBox.appendChild(deleteIcon);
				    imgBox.appendChild(box);
					// 获取id=gallery的div
					var body = document.getElementsByClassName("gallery")[0];
					body.appendChild(imgBox);
					// 点击span事件
					$(deleteIcon).click(function() {
						// 获取data中的图片名
						var filename = $(this).attr('id');
						// 删除父节点
						$(this).parent().remove();
						var fileList = Array.from(files);
						// 遍历数组
						for (var j = 0; j < fileList.length; j++) {
						// 通过图片名判断图片在数组中的位置然后删除
						if (fileList[j].name == filename) {
								fileList.splice(j, 1);
								id--;
								break;
							}
						}
						files = fileList;	
					});
				}
			});
		 
		 $("#file1").change(function() {
				// 获取所有图片
				var img = document.getElementById("file1").files;
				// 遍历
				for (var i = 0; i < img.length; i++) {
					// 得到图片
					var file = img[i];
					// 把图片存到数组中
					files1[k] = file;
					k++;
					// 获取图片路径
					var url = URL.createObjectURL(file);
					// 创建img
					var box = document.createElement("img");
					box.setAttribute("src", url);
					box.setAttribute("style", "width:100px;margin:20px;");
					//box.className = 'img';
					// 创建div
				    var imgBox = document.createElement("div");
					imgBox.style.display = 'inline-block';
					imgBox.className = 'img-item';
					// 创建span
					var deleteIcon = document.createElement("span");
					deleteIcon.className = 'delete';
					deleteIcon.innerText = 'x';
					// 把图片名绑定到data里面
					deleteIcon.id = img[i].name;
					// 把img和span加入到div中
					imgBox.appendChild(deleteIcon);
				    imgBox.appendChild(box);
					// 获取id=gallery的div
					var body = document.getElementsByClassName("gallery")[1];
					body.appendChild(imgBox);
					// 点击span事件
					$(deleteIcon).click(function() {
						// 获取data中的图片名
						var filename = $(this).attr('id');
						// 删除父节点
						$(this).parent().remove();
						var fileList = Array.from(files1);
						// 遍历数组
						for (var j = 0; j < fileList.length; j++) {
						// 通过图片名判断图片在数组中的位置然后删除
						if (fileList[j].name == filename) {
								fileList.splice(j, 1);
								k--;
								break;
							}
						}
						files1 = fileList;	
					});
				}
			});
		 
		function upload() {
			var fd = new FormData();
			//files = document.getElementById("file").files; $('#file')[0].files[i]
		    
			for (var i = 0; i < files.length; i++) {
				fd.append('upfile', files[i]);
				$.ajax({
					url : 'lib/ueditor/jsp/controller.jsp?action=uploadimage',
					data : fd,
					processData : false,
					contentType : false,
					type : 'POST',
					async : false,
					success : function(data) {
						let temp = data;
						updatePage(temp);
					}
				});
				fd.delete("upfile");
			}
		}

		function updatePage(data) {
			let obj = JSON.parse(data);
			if (obj.state === "SUCCESS") {
				var input = inputTarget.val();
				if(input != "" && input != undefined){ 
					inputTarget.val(input+"&"+obj.url);
				}
				else{
					inputTarget.val(obj.url);
				}
			} else {
				notify('#add .modal-body', '上传封面失败!', 'warning');
			}

		}
		
		function upload1() {
			var fd = new FormData();
			for (var i = 0; i < files1.length; i++) {
				fd.append('upfile', files1[i]);
				$.ajax({
					url : 'lib/ueditor/jsp/controller.jsp?action=uploadimage',
					data : fd,
					processData : false,
					contentType : false,
					type : 'POST',
					async : false,
					success : function(data) {
						let temp = data;
						updatePage1(temp);
					}
				});
				fd.delete("upfile");
			}
		}
		
		function updatePage1(data) {
			let obj = JSON.parse(data);
			if (obj.state === "SUCCESS") {
				var input = inputTarget1.val();
				if(input != "" && input != undefined){ 
					inputTarget1.val(input+"&"+obj.url);
				}
				else{
					inputTarget1.val(obj.url);
				}
			} else {
				notify('#add .modal-body', '上传封面失败!', 'warning');
			}

		}
		
		
		var ue_arr = UE.getEditor('editor_arr', {
			toolbars: [["insertimage"]],
		});