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

function checkValidSubmissionDate() {
	var curDate = new Date(document.getElementById("current_date").value);
	var startDate = new Date(document.getElementById("event_start_date").value);
	var diff = (startDate.getTime() - curDate.getTime()) / (1000 * 3600 * 24); 
	if (diff < 7) {
		return false;
	}
	return true;
}

function checkValidEventDates() {
	var startDate = new Date(document.getElementById("event_start_date").value);
	var endDate = new Date(document.getElementById("event_end_date").value);
	var diff = (endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24); 
	if (diff < 0) {
		return false;
	}
	return true;
}

function validateForm() {
	var formElements = document.getElementsByClassName("form-control");
	var i;
	for (i = 0; i < formElements.length; i++) {
		if (formElements[i].value == "")
			return false;
	}
	return true;
}

function email_show_yes() {
	document.getElementById("attach_email").hidden = false;
}
function email_show_no() {
	document.getElementById("attach_email").hidden = true;
}

const formToJSON = elements => [].reduce.call(elements, (data, element) => {
	data[element.name] = element.value;
	return data;
  }, {});

const button = document.getElementById('submit-btn');
button.addEventListener('click', async _ => {
	console.log("submit form button clicked");
	var alertMsg = "Request submitted.";
	var submit = true;
	if (!validateForm()) {
		submit = false;
		alertMsg = "Please complete the form."
	}
	if (submit) {
		if (!checkValidSubmissionDate()) {
			submit = false;
			alertMsg = "Form must be completed at least one week prior to the start of the event."
		}
		else if (!checkValidEventDates()) {
			submit = false;
			alertMsg = "Event cannot end before it begins."
		}
	}
	if (submit) {
		var formElement = document.querySelector("form");
		//var formData = new FormData(formElement);
		var formData = formToJSON(formElement.elements);
		console.log(formData);
	
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange= function(){
			console.log("the ready state has changed");
		}
		var formString = JSON.stringify(formData);
		let u = new URLSearchParams(formData).toString()
		xhttp.open("POST","http://localhost:8080/MoonberryTRMS/postform.json?"+u, true);
		xhttp.setRequestHeader("Content-Type", "application/json");
		xhttp.send();
	}
	alert(alertMsg); 
});

