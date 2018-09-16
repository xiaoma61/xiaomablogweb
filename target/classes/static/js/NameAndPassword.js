/**
 * 
 */
function checkName()
{
	var Name=document.getElementById("Name").value;
	var NameWarning=document.getElementById("NameWarning");
	NameWarning.style="display:block";
	if(Name==null||Name=="")
		{
			//数据不能为空
			
		 	NameWarning.innerHTML="数据不能为空";
		}
	else
		{
			UserCheckName(Name)
		
		}
	
}
function UserCheckName(Name)
{
	
	var NameWarning=document.getElementById("NameWarning");
	$.ajax({
		type:"post",
		url:"/User/Register/CheckName?Name="+Name,
		data:{},
		dataType : "json",
		async:false,
		success:function(data)
		{
/*	  alert(data.data);*/
			var datas=JSON.stringify(data);
			/*var jsonObj =  JSON.parse(datas);*/
			
			var datas=data.data;
			if( datas=="wrong")
				{
			/*	 alert("a    "+jsonObj);*/
				
				 NameWarning.innerHTML="用户名已经被使用";
				}else
				{
				/* alert("aaa   "+jsonObj);*/
				 
				 NameWarning.innerHTML="用户名可以被使用";
				}
		
		}
	}
		)

}
function CheckPassword()
{
	var Password=document.getElementById("Password").value;
	var RePassword=document.getElementById("RePassword").value;
	var RePasswordWarning=document.getElementById("RePasswordWarning");
	RePasswordWarning.style="display:block";
	if(RePassword==null||RePassword=="")
	{
	
	  PasswordWarning.innerHTML="密码不正确";
	
	}
	if(Password!=RePassword)
		{
		
		  RePasswordWarning.innerHTML="密码不正确";
		
		}else
		{
			RePasswordWarning.innerHTML="密码正确";
		}
	
}
function CheckPass()
{
	var Password=document.getElementById("Password").value;
	var RePassword=document.getElementById("RePassword").value;
	var PasswordWarning=document.getElementById("PasswordWarning");
	PasswordWarning.style="display:block";
	if(Password==null||Password=="")
		{
		
		  PasswordWarning.innerHTML="密码不正确";
		
		}else
		{
			PasswordWarning.innerHTML="密码正确";
		}
	
}
function CheckNameAndPassword()
{
	var RePasswordWarning=document.getElementById("RePasswordWarning");
	var PasswordWarning=document.getElementById("PasswordWarning");
	var NameWarning=document.getElementById("NameWarning");
	var Name=document.getElementById("Name").value;
	var Password=document.getElementById("Password").value;
	var RePassword=document.getElementById("RePassword").value;
	NameWarning.style="display:block";
	RePasswordWarning.style="display:block";
	
	if(Name==""||Name==null){
		NameWarning.style="diplay:block";
		NameWarning.innerHTML="用户名不能为空";
		return false;
		
	}
	if(Password==""||Password==null){
		PasswordWarning.style="diplay:block";
		PasswordWarning.innerHTML="密码不能为空";
		return false;
	}
	if(Password!=RePassword){
		RePasswordWarning.style="diplay:block";
		RePasswordWarning.innerHTML="密码错误";
		return false;
	}
	
	return true;
	
	
	
	
}