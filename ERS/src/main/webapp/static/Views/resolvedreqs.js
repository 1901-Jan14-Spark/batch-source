let expsURL = "http://localhost:8080/ERS/api/reimbursements";
let sessionURL = "http://localhost:8080/ERS/session"

var session;


function ajaxRequest(method, url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open(method, url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			callback(this);
		}
	}
	xhr.send();
}

function ajaxPOST(url, approveReq){
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 201){
			console.log("It's working!!");
		}
	}
	xhr.setRequestHeader("Content-Type", "application/json");
	let flightJSON = JSON.stringify(newFlightObj);
	xhr.send(flightJSON);
}

window.onload = function(){
	ajaxRequest("GET", expsURL, displayReimbursements);
	ajaxRequest("GET", sessionURL, getSession);
}

function getSession(xhr){
	session = JSON.parse(xhr.response);
}

function displayReimbursements(xhr){
	let expsArr = JSON.parse(xhr.response);
	for(exp of expsArr){
		if(exp.email == session.email){
			if(exp.resolvedby != null)
		addExps(exp.id, exp.email, exp.price, exp.status, exp.resolvedby);
		}
	}
}

function addExps(id, email, price, status, resolvedby){

	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
	let cell5 = document.createElement("td");
	
	row.appendChild(cell1);
	row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
	row.appendChild(cell5);
	
	cell1.innerHTML=id;
	cell2.innerHTML=email;
	cell3.innerHTML=price;
	cell4.innerHTML=status;
	cell5.innerHTML=resolvedby;
	
	document.getElementById("allMyExps").appendChild(row);	
}

