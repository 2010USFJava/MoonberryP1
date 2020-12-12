/**
 * Handling form stuff.
 */

// This function grabbed off stackoverflow: https://stackoverflow.com/questions/6982692/how-to-set-input-type-dates-default-value-to-today
Date.prototype.toDateInputValue = (function() {
    var local = new Date(this);
    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
    return local.toJSON().slice(0,10);
});
document.getElementById('current_date').value = new Date().toDateInputValue();
document.getElementById("tuition_amount")
		.addEventListener("change", estCost);
document.getElementById("event_type")
		.addEventListener("change", estCost);

function estCost() {
	document.getElementById("tuition_amount").value = parseFloat(
		document.getElementById("tuition_amount").value).toFixed(2);
	let amount = document.getElementById("tuition_amount").value;
	let eventType = document.getElementById("event_type").value;
	
	switch(eventType) {
		case "1": 
			document.getElementById("rmbsment_amount").value = parseFloat(
				(amount * .8)).toFixed(2);
			break;
		case "2":
			document.getElementById("rmbsment_amount").value = parseFloat(
				(amount * .6)).toFixed(2);
			break;
		case "3":
			document.getElementById("rmbsment_amount").value = parseFloat(
				(amount * .75)).toFixed(2);
			break;
		case "4":
			document.getElementById("rmbsment_amount").value = parseFloat(
				(amount)).toFixed(2);
			break;	
		case "5":
			document.getElementById("rmbsment_amount").value = parseFloat(
				(amount * .9)).toFixed(2);
			break;
		case "6":
			document.getElementById("rmbsment_amount").value = parseFloat(
				(amount * .3)).toFixed(2);
			break;
		default:
			console.log("Error calculating reimbursement amount in form.js");
	}
	
}
const button = document.getElementById('submit-btn');
button.addEventListener('click', async _ => {
	console.log("submit form button clicked");

	var formElement = document.querySelector("form");
	var formData = new FormData(formElement);
	
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange= function(){
		console.log("the ready state has changed");
		// if(xhttp.readyState==4 && xhttp.status==200){
		// 	let str = 'Printing xhttp here: '
		// 	console.log(str.concat(xhttp.responseText));
		// 	let user = JSON.parse(xhttp.responseText);
		// 	console.log(user);
		// }
	}
	xhttp.open("POST","http://localhost:8080/MoonberryTRMS/postform.json");
	xhttp.send(formData);
	alert("Submitted successfully."); // FIX THIS LATER
});

