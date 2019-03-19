/**
 * 
 */

window.onload=function(){
	ajaxGetRequest( populateTable);
	
}

function ajaxGetRequest( process) {

	let xhr = new XMLHttpRequest();

	xhr.open("get", "http://localhost:8080/ReimbursementApp/api/employees");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status >= 200 && xhr.status < 300) {
				process(JSON.parse(xhr.response));
			} else {
				console.log(xhr.statusText);
			}
		}
	}
	xhr.send();
}

function populateTable(employees){
	for(e of employees){
		let row = document.createElement("tr");

		let id = document.createElement("td");
		id.innerHTML = e.id;
		let firstname = document.createElement("td");
		firstname.innerHTML = e.firstname;
		let lastname = document.createElement("td");
		lastname.innerHTML = e.lastname;
		let email = document.createElement("td");
		email.innerHTML = e.email;
		
		row.appendChild(id);
		row.appendChild(firstname);
		row.appendChild(lastname);
		row.appendChild(email);
		document.getElementById("EmployeeBody").appendChild(row);
	}
}