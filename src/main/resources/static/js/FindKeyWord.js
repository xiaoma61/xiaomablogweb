/**
 * 
 */
function hiddenSuggest()
{
	 document.getElementById('suggest').style.display="none";    
	}

function clearSuggest(){
    document.getElementById('suggest').innerHTML="";  
 }
function displaySuggest(){
    document.getElementById('suggest').style.display="block";
    }
function sendRequest()
{
	 clearSuggest();
	 var title= document.getElementById('title').value;
	 if(title==""){
		  	hiddenSuggest();
		  	return ;
		  	}
 
	 $.ajax({
		 type:"post",
		 url:"/articles/dofindtitle?Title="+title,
		 contentType: "application/json; charset=utf-8",
		 dataType:"json",
		 data:{},
		 async:false,
		 success:function(data)
		 {
			
			 var datas=JSON.stringify(data);
			 var jsonObj =  JSON.parse(datas);
	
	
			 for(var i=0; i<jsonObj.length;i++){
		
				 var  title = jsonObj[i].title; 
				 var sDiv = "<div class='outs' onmouseover='mover(this);' onmouseout='mout(this);' onclick='setSuggest(this)'>"+title+"</div>";
  				 document.getElementById('suggest').innerHTML+=sDiv;
			 }
			 displaySuggest();
		 },
		 error:function(data)
		 {
			 hiddenSuggest();//设置智能提示列表不可见 
		 }
		 
		 
		 
	 })
}



function setSuggest(para){
    document.getElementById('title').value=para.firstChild.nodeValue;
    hiddenSuggest();
    }
     function mover(para){
       para.className="overs";
       }
        function mout(para){
       para.className="outs";
       }