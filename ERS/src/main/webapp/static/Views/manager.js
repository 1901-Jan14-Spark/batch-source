let empsURL = "http://localhost:8080/ERS/api/employees";
let expsURL = "http://localhost:8080/ERS/api/reimbursements";

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
//	ajaxRequest("GET", expsURL, displayReimbursements);
	ajaxRequest("GET", empsURL, displayEmployees);
//	ajaxRequest("GET", customerURL, displayCustomerChoice);
}

function displayEmployees(xhr){
	let employeeArr = JSON.parse(xhr.response);
	for(employee of employeeArr){
		addEmployee(employee.id, employee.email, employee.fname, employee.lname, employee.reportsto);
	}
}

function addEmployee(id, email, fname, lname, reportsto){

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
	cell2.innerHTML=fname;
	cell3.innerHTML=lname;
	cell4.innerHTML=email;
	cell5.innerHTML=reportsto;
	
	document.getElementById("allEmployees").appendChild(row);	
}



