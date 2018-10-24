(function(){
		var file = {
			upload: function(e){
			var m_file = e.target.files;
				var name='', div='',image='';
				for(var i=0;i<m_file.length;i++){
					var z = m_file[i];
					var reader = new FileReader();// 这里可能会有坑
					reader.readAsDataURL(z); 
					// console.log(z.name);
			    	reader.onloadend = (function(i){
			    		return function(){
			    			console.log();
			    			console.log(i);
			    			div = '<p>Name: '+i.name+'</p><p>Size: '+Math.round(i.size / 1024)+'kb</p>';
			    			image = '<img src="'+ this.result +'"/>';
					        var imglist = '<div class="img_box"><span class="delete">X</span>'+image + div+'</div>';
					        $(".img_holder").append(imglist);
			    		};
			    	})(z);
		    	};
			},
			m_upload: function(e){
				var m_file = e.target.files;
				var name='', div='',image='';
				for(var i=0;i<m_file.length;i++){
					var z = m_file[i];
					var reader = new FileReader();// 这里可能会有坑
					reader.readAsDataURL(z); 
					// console.log(z.name);
			    	reader.onloadend = (function(i){
			    		return function(){
			    			console.log();
			    			console.log(i);
			    			div = '<p>Name: '+i.name+'</p><p>Size: '+Math.round(i.size / 1024)+'kb</p>';
			    			image = '<img src="'+ this.result +'"/>';
					        var imglist = '<div class="img_box"><span class="delete">X</span>'+image + div+'</div>';
					        $(".m_img_holder").append(imglist);
			    		};
			    	})(z);
		    	};
			},
			event: function(){
				$("#upload").change(function(e){
					$(".progress").removeClass("none");
					file.upload(e);
				});
				$("#m_upload").change(function(e){
					file.m_upload(e);
				});
				// 删除文件
				$(".file_upload").delegate(".delete","click",function(){
					var o = $(this);
					o.parents(".img_box").remove();// 并没有清空input里面的值
					$(".progress").addClass("none");
					$("#upload,#m_upload").val('');// 这下就删除了
				})
			},
			init: function(){
				this.event();
			}
		}
		file.init();
	}());