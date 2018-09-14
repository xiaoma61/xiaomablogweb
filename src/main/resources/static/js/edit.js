/**
 * 
 */
function formsubmit()
{
	
	var title=document.getElementById("title").value;
	var introduction=document.getElementById("introduction").value;
	var label=document.getElementById("label").value;
	var content=document.getElementById("content").value;
	document.getElementById('articles').value=tinyMCE.activeEditor.getContent();
	alert(tinyMCE.activeEditor.getContent());
	if(title==null||title==""||introduction==null||introduction==""||lable==""||lable==null||content==""||content==null){
	
		return false;
		}else
			{
			
			 alert("提交成功");
			return true;
			
		}
		
}
