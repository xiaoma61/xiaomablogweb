
   
 $('.commentAll').on('click','.plBtn',function(){
    	alert("点击评论创建评论条");
    	
    	 var comment=  document.getElementById("comment").value;
    	 /*  document.getElementById("comment").value; */
		var ARTICLEid=document.getElementById("ARTICLEid").value; 
		 var oThis = $(this);
		$.ajax({
			 type:'post',
			 url:'/User/Comment?comments='+comment+"&ARTICLEid="+ARTICLEid,
			 contentType: "application/json; charset=utf-8",
			 dataType:"json",
			/* data:'comments='+comment+"&ARTICLEid="+ARTICLEid,*/
			 async:false,
			 success:function(data)
			 {
				 var datas=JSON.stringify(data);
				 var dataString=data.data;
				 if(dataString == "lose")
					 {
					 //跳转到注册页面
					  window.open("/User/Login");
					 alert("a    "+dataString);
					 }else
					{
					
						  var name=dataString.usermsg.name;
						  var content=dataString.articlecomment.content;
						  var time=dataString.articlecomment.time;
						  var image=dataString.usermsg.image;
						  var praisenums=dataString.articlecomment.praisenums;
						  alert("a    "+name);
			
						  var oHtml = '<div class="comment-show-con clearfix"><div class="comment-show-con-img pull-left"><img src="" alt=""/></div> <div class="comment-show-con-list pull-left clearfix"><div class="pl-text clearfix"> <a href="#" class="comment-size-name">'+
						  name+' : </a> <span class="my-pl-con">&nbsp;'+ content +'</span> </div> <div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+
						  time+'</span> <div class="date-dz-right pull-right comment-pl-block"><a href="javascript:;" class="removeBlock">删除</a> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">'+
						  praisenums +'</i>)</a> </div> </div><div class="hf-list-con"></div></div> </div>';
						 //插入
						  oThis.parents('.reviewArea ').siblings('.comment-show').prepend(oHtml);
						  oThis.siblings('.flex-text-wrap').find('.comment-input').prop('value','').siblings('pre').find('span').text('');
						  
				   
					}
				//加入数据 
			 },
			 error:function(data)
			 {
				 
			 }
			
			
		})
	
    });


function comment()
{
	var comment=document.getElementById("comment").value;
	var ARTICLEid=document.getElementById("ARTICLEid").value;
	commentAjax(comment, ARTICLEid);
}
function commentAjax(comment, ARTICLEid)
{
	//一级 用户+
	$.ajax({
		 type:'post',
		 url:'/User/Comment',
		 contentType: "application/json; charset=utf-8",
		 dataType:"json",
		 data:'comments='+comment+"&ARTICLEid="+ARTICLEid,
		 async:false,
		 success:function(data)
		 {
			 var datas=JSON.stringify(data);
			 var dataString=data.data;
			 if(dataString == "lose")
				 {
				 //跳转到注册页面
				  window.open("/User/Login");
				 alert("a    "+dataString);
				 }else
				{
				
					  var name=dataString.usermsg.name;
					  var content=dataString.articlecomment.content;
					  var time=dataString.articlecomment.time;
					  var image=dataString.usermsg.image;
					  var praisenums=dataString.articlecomment.praisenums;
					  alert("a    "+name);
					  var c=document.createElement('div');
					  c.className="comment-show";
					  c.innerHTML='<div class="comment-show-con clearfix"><div class="comment-show-con-img pull-left"><img src="" alt=""/></div> <div class="comment-show-con-list pull-left clearfix"><div class="pl-text clearfix"> <a href="#" class="comment-size-name">'+
					  name+' : </a> <span class="my-pl-con">&nbsp;'+ content +'</span> </div> <div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+
					  time+'</span> <div class="date-dz-right pull-right comment-pl-block"><a href="javascript:;" class="removeBlock">删除</a> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">'+
					  praisenums+'</i>)</a> </div> </div><div class="hf-list-con"></div></div> </div>';
					  /*var oHtml = '<div class="comment-show-con clearfix"><div class="comment-show-con-img pull-left"><img src="" alt=""/></div> <div class="comment-show-con-list pull-left clearfix"><div class="pl-text clearfix"> <a href="#" class="comment-size-name">'+
					  name+' : </a> <span class="my-pl-con">&nbsp;'+ content +'</span> </div> <div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+
					  time+'</span> <div class="date-dz-right pull-right comment-pl-block"><a href="javascript:;" class="removeBlock">删除</a> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a> </div> </div><div class="hf-list-con"></div></div> </div>';*/
					 //插入
					  var main = document.getElementById('main'); 
					  main.appendChild(c);
					  
			   
				}
			//加入数据 
		 },
		 error:function(data)
		 {
			 
		 }
		
		
	})
	
	}