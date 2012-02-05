function postVote(id,cid)
{
   if (!fbuserid)
   {
  		window.location = "/Vote?cid=" + cid;
   }
   else
   {
	   FB.api('/'+fbuserid+'/hartcode:vote_for', 'post',{access_token:'161596347286085|Rthw3WvIOWP1XNO815yzuXPpxLM',wallpaper:'http://www.hartcode.com/Vote',image:'http://www.hartcode.com/photos/thumb/'+ id +'/image.jpg'},
        function(response) {
        if (!response || response.error) {
                alert(response.error.message);
        } else {
            //alert('Post was successful! Action ID: ' + response.id);
        		window.location = "/Vote?cid=" + cid;        	
            }
    });
   }   
}

function toggle(showHideDiv,checkboxele) {
	var chk = document.getElementById(checkboxele);
	var ele = document.getElementById(showHideDiv);
	 if (chk.checked == 1)
		 {
 			ele.style.display = "block";		 
		 }
	else {
		ele.style.display = "none";
	}
} 

function generatePassword()
{
var xmlhttp;
if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
xmlhttp=new XMLHttpRequest();
}
else
{// code for IE6, IE5
xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
var url = encodeURI("/PasswordGenerator");
xmlhttp.open("POST",url,true);

var mysize;
var myAlpha;
var myNumeric;
var mySpecial;
var myCaseOp;
mySize = document.getElementById("size").value;
myAlpha = document.getElementById("Alpha").checked;
myNumeric = document.getElementById("Numeric").checked;
mySpecial = document.getElementById("Special").checked;
myCaseOp = getCheckedValue(document.getElementsByName("caseop"));
var params = encodeURI("size="+mySize+"&Alpha="+myAlpha+"&Numeric="+myNumeric+"&Special="+mySpecial+"&caseop="+myCaseOp);
//Send the proper header information along with the request
xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xmlhttp.setRequestHeader("Content-length", params.length);
xmlhttp.setRequestHeader("Connection", "close");
xmlhttp.onreadystatechange=function()
  {
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    	document.getElementById("pass").value=xmlhttp.responseText;  
    }
  }
xmlhttp.send(params);
}

function getCheckedValue(radioObj) {
	if(!radioObj)
		return "";
	var radioLength = radioObj.length;
	if(radioLength == undefined)
		if(radioObj.checked)
			return radioObj.value;
		else
			return "";
	for(var i = 0; i < radioLength; i++) {
		if(radioObj[i].checked) {
			return radioObj[i].value;
		}
	}
	return "";
}

