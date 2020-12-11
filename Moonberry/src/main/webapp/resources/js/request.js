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
		}
	}
	xhttp.open("GET","http://localhost:8080/MoonberryTRMS/getrsession.json");
	xhttp.send();

	
}

function displayUser(){


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
		var th = document.createElement("th"); 
		th.classList.add("thead-dark");  // TABLE HEADER.
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