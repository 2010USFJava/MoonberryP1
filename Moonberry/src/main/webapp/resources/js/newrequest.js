/**
 * Handling form stuff.
 */
alert("i work!");
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