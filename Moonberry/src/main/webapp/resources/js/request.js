window.onload=function(){
    console.log("window");
	getReqs();
	

}

function getReqs(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange= function(){
		
		console.log("the ready state has changed");
		if(xhttp.readyState==4 && xhttp.status==200){
			var reqList = JSON.parse(xhttp.responseText);
			console.log(reqList);
            CreateTableFromJSON(reqList);   
            displayOptions('#sreq', reqList);
            displayActions();
		}
	}
	xhttp.open("GET","http://localhost:8080/MoonberryTRMS/getrsession.json");
	xhttp.send();

	
}

function displayOptions(id, reqList){  //pass in already parsed json
    //console.log("I was called!");
    var obj = reqList;//this is kind of useless but obj is shorter lol
    //console.log(obj); //print to  check!
    $.each(obj, function(key,value) { //for each object in reqList:(index, json )
        console.log(key);
        console.log(value.requestId); //javaobject.parameter, will pass in the value associated with the parameter
        optionText = value.requestId; //stores the seen text in option
        optionValue = value.requestId; //stores a value that is passed in when this option is chosen
        $(`${id}`).append(`<option value="${optionValue}">${optionText}</option>`);
        //^^^ id of the select tag in yout form
        //                ^^^^^^^^ appends a new option
        

    });
}
function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}
function displayActions(){
    // // var u = document.getElementsByTagName("currentu"), currentuser;
    // // urrentuser = u.getAttribute("currentuser")
    // var currentu = '<%= session.getAttribute("currentuser") %>';
    // // var currentuser = JSON.parse(currentu);
    var u ="utype";
    var utype= readCookie(u);
    console.log(utype);
    if (utype) {
        if (utype==="SUPERVISOR") {
            $('#action').append(`<option value="3">"Request additional details"</option>`);
            $('#action').append(`<option value="5">"Give Super Level Approval"</option>`);
            $('#action').append(`<option value="9">"Reject"</option>`);
        
        } else if (utype==="DEPARTMENT_HEAD"){
            $('#action').append(`<option value="3">"Request additional details"</option>`);
            $('#action').append(`<option value="5">"Give Super Level Approval"</option>`);
            $('#action').append(`<option value="9">"Reject"</option>`);
            $('#action').append(`<option value="6">"Give Department Head Level Approval"</option>`);
            $('#action').append(`<option value="13">"Reject"</option>`);
        
        }else if (utype==="BEN_CO"){
            $('#action').append(`<option value="3">"Request additional details"</option>`);
            $('#action').append(`<option value="5">"Give Super Level Approval"</option>`)
            $('#action').append(`<option value="7">"Make request changes"</option>`);//this should work but....
            $('#action').append(`<option value="6">"Give Department Head Level Approval"</option>`);
            $('#action').append(`<option value="8">"Give Ben_Co Level Approval|Grade"</option>`);
            $('#action').append(`<option value="9">"Give Ben_Co Level Approval|Present"</option>`);
            $('#action').append(`<option value="12">"Escalate Request"</option>`);
            $('#action').append(`<option value="13">"Reject"</option>`);
            $('#action').append(`<option value="14">"Approve and Award"</option>`);
        }else {
            $('#action').append(`<option value="4">"Provide additional details"</option>`);
            $('#action').append(`<option value="10">"Submit final grade"</option>`);
            $('#action').append(`<option value="11">"Submit final presentation"</option>`);
            $('#action').append(`<option value="13">"Reject"</option>`);
        }
    }
}

function CreateTableFromJSON(howdy) {
    //console.log(howdy);
	//let abc = JSON.parse(howdy)
	let abc = howdy;
    // EXTRACT VALUE FOR HTML HEADER. 
    // ('Book ID', 'Book Name', 'Category' and 'Price')
    var col = [];
    for (var i = 0; i < abc.length; i++) {
        for (var key in abc[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }
    // CREATE DYNAMIC TABLE.
	var table = document.createElement("table");
	table.classList.add("table");
	table.classList.add("table-striped");
	table.classList.add("table-bordered");
    // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.
    var tr = table.insertRow(-1);                   // TABLE ROW.
    for (var i = 0; i < col.length; i++) {
		var th = document.createElement("th");   // TABLE HEADER.
        th.innerHTML = col[i];
        tr.appendChild(th);
    }
    // ADD JSON DATA TO THE TABLE AS ROWS.
    for (var i = 0; i < abc.length; i++) {
        tr = table.insertRow(-1);
        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = abc[i][col[j]];
        }
    }
    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    var divContainer = document.getElementById("reqview");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}

/* attach a submit handler to the form */
$("#actionsform").submit(function(event) {

    /* stop form from submitting normally */
    event.preventDefault();
  
    
    //var myform = $(this);;
    $.ajax({
        url:'http://localhost:8080/MoonberryTRMS/actionform.json',
        data: $('#actionsform').serialize(),
        type: 'POST',
        dataType: 'json',
        success: function (fd) {
            alert("Action was successfully submitted!");
        }
    });
  
    
});

