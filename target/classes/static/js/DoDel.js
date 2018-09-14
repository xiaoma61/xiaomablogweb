/**
 * 
 */
 function del(id,isshow)
        {
        	$.ajax({
        	type:"post",
        	url:"/articles/dodelete?id="+id+"&isshow="+isshow,
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
         function delALL()
        {
        	$.ajax({
        	type:"post",
        	url:"/articles/dodeleteALL",
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
         function delRealID(id)
         {
         	$.ajax({
         	type:"post",
         	url:"/articles/dodeleteReal?ID="+id,
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
        
        