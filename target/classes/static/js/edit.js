/**
 * 
 */
function formsubmit()
{
	
	var title=document.getElementById("title").value;
	var introduction=document.getElementById("introduction").value;
	var label=document.getElementById("label").value;
	var content=document.getElementById("content").value;
	if(title==null||title==""||introduction==null||introduction==""||lable==""||lable==null||content==""||content==null){
	
		return false;
		}else
			{
		
			return true;
			
			}
		
}
