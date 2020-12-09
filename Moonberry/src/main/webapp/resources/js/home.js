/**
 * 
 */

window.onload=function(){
	console.log("window");
	getVillain();

}

function getVillain(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange= function(){
		
		console.log("the ready state has changed");
		if(xhttp.readyState==4 && xhttp.status==200){
			let user = JSON.parse(httpresponse.text);
			console.log(user);
		}
	}
	xhttp.open("GET","http://localhost:8080/MoonberryTRMS/getsession.json");
	xhttp.send();
}