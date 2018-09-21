
   
 $('.commentAll').on('click','.plBtn',function(){
    	alert("点击评论创建评论条");
    	
    	 var comment=  document.getElementById("comment").value;
    	 /*  document.getElementById("comment").value; */
		var ARTICLEid=document.getElementById("ARTICLEid").value; 
		
		//评论清空
		
		 document.getElementById("comment").value="";
		 document.getElementById("ARTICLEid").value="";
		
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


//实现二级评论区
 $('.comment-show').on('click','.hf-pl',function(){
	  var oThis = $(this);
	  var oHfVal = $(this).siblings('.flex-text-wrap').find('.hf-input').val();//输入内容
	  var oHfName = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();//名字
	  var oHID = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-ID').html();//名字
	  
	  var comment=oHfVal;
	  var ARTICLEid=document.getElementById("ARTICLEid").value; 
	  
	  //需要  PARENTID二级      BELONGID一级
	  $.ajax({
			 type:'post',
			 url:'/User/Comment?comments='+comment+"&ARTICLEid="+ARTICLEid+"&PARENTID="+oHID,
			 contentType: "application/json; charset=utf-8",
			 dataType:"json",
			
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
			
						  var oHtml = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix"><a href="#" class="comment-size-name">'+
						  name+' : </a><span class="my-pl-con">'+content
						  +'</span></div><div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+
						  time+'</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="removeBlock">删除</a> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">'+
						  praisenums+'</i>)</a> </div> </div></div>';
						 //插入
						  oThis.parents('.hf-con').parents('.comment-show-con-list').find('.hf-list-con').css('display','block').prepend(oHtml) && oThis.parents('.hf-con').siblings('.date-dz-right').find('.pl-hf2').addClass('hf-con-block') && oThis.parents('.hf-con').remove();
						  
				   
					}
				//加入数据 
			 },
			 error:function(data)
			 {
				 
			 }
			
			
		})
	 
	 
 });
 
 
 $('.comment-show').on('click','.hf-pl1',function(){
	  var oThis = $(this);
	  var oHfVal = $(this).siblings('.flex-text-wrap').find('.hf-input').val();//输入内容
	  var oHfName = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-ID').html();//名字
	  var PARENTName=$(this).parents('.hf-con').parents('.date-dz').parents('.all-pl-con').parents('.hf-list-con').siblings('.pl-text').find('.comment-size-ID').html();
	  var ARTICLEid=document.getElementById("ARTICLEid").value; 
	  
	  //需要  PARENTID二级      BELONGID一级
	  $.ajax({
			 type:'post',
			 url:'/User/Comment?comments='+oHfVal+"&ARTICLEid="+ARTICLEid+"&BELONGID="+oHfName+"&PARENTID="+PARENTName,
			 contentType: "application/json; charset=utf-8",
			 dataType:"json",
			
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
			
						  var oHtml = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix"><a href="#" class="comment-size-name">'+
						  name+' </a><span class="my-pl-con">'+content
						  +'</span></div><div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+
						  time+'</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="removeBlock">删除</a> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">'+
						  praisenums+'</i>)</a> </div> </div></div>';
						 //插入
						  oThis.parents('.hf-con').parents('.comment-show-con-list').find('.hf-list-con').css('display','block').prepend(oHtml) && oThis.parents('.hf-con').siblings('.date-dz-right').find('.pl-hf2').addClass('hf-con-block') && oThis.parents('.hf-con').remove();
						  
				   
					}
				//加入数据 
			 },
			 error:function(data)
			 {
				 
			 }
			
			
		})
	 
	 
});
 
 
 
 
 
 //实现点赞
 $('.comment-show').on('click','.date-dz-z',function(){
     var zNum = $(this).find('.z-num').html();
     var oThis = $(this);
     var ID=$(this).parents('.date-dz-right').parents('.date-dz').siblings('.pl-text').find('.comment-size-articlecomment-ID').html();
     if($(this).is('.date-dz-z-click')){
         zNum--;
        
         
         $.ajax({
			 type:'post',
			 url:'/User/Parise?PRAISENUMS='+zNum+"&ID="+ID,
			 contentType: "application/json; charset=utf-8",
			 dataType:"json",
			
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
						 oThis.removeClass('date-dz-z-click red');
						 oThis.find('.z-num').html(zNum);
						 oThis.find('.date-dz-z-click-red').removeClass('red');
					}
			 },
			 error:function(data)
			 {
				 
			 }
			
			
		})
         
         
     }else {
         zNum++;
         
         
         $.ajax({
			 type:'post',
			 url:'/User/Parise?PRAISENUMS='+zNum+"&ID="+ID,
			 contentType: "application/json; charset=utf-8",
			 dataType:"json",
			
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
						 
						 oThis.addClass('date-dz-z-click');
						 oThis.find('.z-num').html(zNum);
						 oThis.find('.date-dz-z-click-red').addClass('red');
					}
			 },
			 error:function(data)
			 {
				 
			 }
			
			
		})
     }
 });
 
 
 //实现分页二级显示
 
 $('.comment-show').on('click','.date-dz-z',function(){
     var zNum = $(this).find('.z-num').html();
     var oThis = $(this);
     var ID=$(this).parents('.date-dz-right').parents('.date-dz').siblings('.pl-text').find('.comment-size-articlecomment-ID').html();
     if($(this).is('.date-dz-z-click')){
         zNum--;
        
         
         $.ajax({
			 type:'post',
			 url:'/User/Parise?PRAISENUMS='+zNum+"&ID="+ID,
			 contentType: "application/json; charset=utf-8",
			 dataType:"json",
			
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
						 oThis.removeClass('date-dz-z-click red');
						 oThis.find('.z-num').html(zNum);
						 oThis.find('.date-dz-z-click-red').removeClass('red');
					}
			 },
			 error:function(data)
			 {
				 
			 }
			
			
		})
         
         
     }else {
         zNum++;
         
         
         $.ajax({
			 type:'post',
			 url:'/User/SecondComment?PRAISENUMS='+zNum+"&ID="+ID,
			 contentType: "application/json; charset=utf-8",
			 dataType:"json",
			
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
						 
						 oThis.addClass('date-dz-z-click');
						 oThis.find('.z-num').html(zNum);
						 oThis.find('.date-dz-z-click-red').addClass('red');
					}
			 },
			 error:function(data)
			 {
				 
			 }
			
			
		})
     }
 });
 