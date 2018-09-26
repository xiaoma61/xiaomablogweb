/**
 * 
 */
function LikeAndFollow(FOL)
{
	var follow=document.getElementById("follow").innerHTML;
	var like=document.getElementById("like").innerHTML;
	var TOID=document.getElementById("usermsg").innerHTML;
	if(FOL=="1")
		{
		//点击了关注
		if(follow=="已关注")
		{
			//取消关注
			follow="1";
			document.getElementById("follow").innerHTML="关注";
			
		}
		if(follow=="关注")
		{
			
			follow="2";
			document.getElementById("follow").innerHTML="已关注";
		}	
		if(like=="已喜欢")
		{
			like="2";
		}else{
			like="1";
		}
			
		
		}else
		{
			
			if(follow=="已关注")
			{
				//取消关注
				follow="2";
				
			}else
			{
				follow="1";
			}	
			if(like=="已喜欢")
			{
				like="1";
				document.getElementById("like").innerHTML="喜欢";
			}else{
				like="2";
				document.getElementById("like").innerHTML="已喜欢";
			}
		}
	$.ajax({
    	type:"post",
    	url:"/User/Follow?ISLIKE="+like+"&ISFOLLOW="+follow+"&TOID="+TOID,
    	async:false,
    	success:function()
    	{
    		/* alert("成功"); */
    	},
    	error:function()
    	{
    		/* alert("失败"); */
    	}
    	
    	
    	})
	}