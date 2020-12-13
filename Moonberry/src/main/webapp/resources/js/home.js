/**
 * 
 */

window.onload=function(){
	console.log("window");
	getUser();

}

function getUser(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange= function(){
		
		console.log("the ready state has changed");
		if(xhttp.readyState==4 && xhttp.status==200){
			
		}
	}
	xhttp.open("GET","http://localhost:8080/MoonberryTRMS/getsession.json");
	xhttp.send();
}

function displayUser(){


}