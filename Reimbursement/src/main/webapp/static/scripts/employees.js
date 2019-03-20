function sendGet(url, callback){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			callback(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

let url ="http://localhost:8080/Reimbursement/api/employeeslist";
sendGet("http://localhost:8080/Reimbursement/api/employeeslist", populate);

function populate(xhr){
	employees = JSON.parse(xhr.response)
	 let table = document.getElementById("EmpTab");
	for (e in employees){
		let nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td>${employees[e].id}</td>
		<td>${employees[e].first}</td><td>${employees[e].last}</td>
		<td>${employees[e].username}</td><td>${employees[e].password}</td>`;
		table.appendChild(nextRow);
	}
	
}