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
		 data:"json",
		 url:"/articles/dofindtitle?Title="+title,
		 async:false,
		 success:function(data)
		 {
			 for(var i=0; i<data.length();i++){
				 var title=data[i].firstChild.nodeValue;
				 var sDiv = "<div class='out' onmouseover='mover(this);' onmouseout='mout(this);' onclick='setSuggest(this)'>"+title+"</div>";
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
       para.className="over";
       }
        function mout(para){
       para.className="out";
       }