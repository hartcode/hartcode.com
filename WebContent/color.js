var xlen = 50;
var ylen = 50;
var maxlen = xlen*ylen;
var hex_alphabets = "0123456789ABCDEF";
var hexsign = "#";
var grouparrays = new Array();
var last = 0;

function createtable()
{
	
	var table = document.getElementById("maintable");
	var tblBody = document.createElement("tbody");
	for(var x=0;x<xlen;x++)
		{
		var row = document.createElement("tr");
		    for(var y=0;y<ylen;y++)
			{
		    	var id = ((x)*xlen) + y+1;
		    	var cell = document.createElement("td");
		    	cell.id = id;
		    	cell.onmouseover = function()
		    	{
		    		mouseone(this.id);
		    	};

		    	var r=0;//Math.floor(Math.random()*256);
				var g=Math.floor(Math.random()*256);
				var b=0;//Math.floor(Math.random()*256);
				var newcolor = num2hex(r,g,b);
				cell.style.backgroundColor= newcolor;
		    	row.appendChild(cell);
			}
		    tblBody.appendChild(row);
		}
	table.appendChild(tblBody);
	
}

function mouseone(id)
{
		var r= Math.floor(Math.random()*256);
		var g=0;//Math.floor(Math.random()*256);
		var b=Math.floor(Math.random()*256);
		var newcolor = num2hex(r,g,b);
		document.getElementById(id).style.backgroundColor= newcolor;
}

function rotateall()
{
	var split = 23;
	var which=last + 1;
	if (which == split)
		{
		which = 1;
		}
	last = which;
	var up=10;
	for (var i=which; i <= maxlen; i=i+split)
	{
		var currentnum = hex2num(document.getElementById(i).style.backgroundColor);
		var r = currentnum[0];
		var g = currentnum[1];
		var b = currentnum[2];

		   if (r > 0 )
		   {
			r = r + (up);
			if (r > 255)
			{
				r = 0;//Math.floor(Math.random()*256);;
			}
			}
			g = g + up;
			if (g > 255)
			{
				g = Math.floor(Math.random()*256);;
			}
			if ( b > 0)
				{
			b = b + (up);
			if (b > 255)
			{
				b = 0;//Math.floor(Math.random()*256);;
			}
				}
		
		document.getElementById(i).style.backgroundColor = num2hex(r,g,b);
	}
}


function hex2num(hex) {
	if(hex.charAt(0) == hexsign) 
		{hex = hex.slice(1);} //Remove the '#' char - if there is one.
	hex = hex.toUpperCase();
	var value = new Array(3);
	var k = 0;
	var int1,int2;
	for(var i=0;i<6;i+=2) {
		int1 = hex_alphabets.indexOf(hex.charAt(i));
		int2 = hex_alphabets.indexOf(hex.charAt(i+1)); 
		value[k] = (int1 * 16) + int2;
		k++;
	}
	return(value);
}
//Give a array with three values as the argument and the function will return
//	the corresponding hex triplet.
function num2hex(r,g,b) {
	var hex = hexsign;
	hex += hex_alphabets.charAt(r / 16) + hex_alphabets.charAt(r % 16); 
	hex += hex_alphabets.charAt(g / 16) + hex_alphabets.charAt(g % 16);
	hex += hex_alphabets.charAt(b / 16) + hex_alphabets.charAt(b % 16);
	return(hex);
}