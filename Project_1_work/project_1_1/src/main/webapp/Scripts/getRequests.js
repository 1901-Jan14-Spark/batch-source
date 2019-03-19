/**
 * 
 */
let rurl = "http://localhost:8080/Project_1//EmployeeRequestApi";
function sendjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			callback(this)
		}
	}
	xhr.open("GET",url);
	xhr.send();
}
function popRTable(xhr){
	let requests = JSON.parse(xhr.response);
	console.log(requests);
	let employeeTable = document.getElementById("employeeReimbursementStatus");
	for(request of requests){
		let bo = request.approved;
		let req = "pending";
		if (bo === true){
			req = "approved"}
			else{
				req = "Pending";
			}
		addRow(req, request.dateSubmitted.substr(0,10));
	}
}

function addRow(name, id){
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	row.appendChild(cell1);
	row.appendChild(cell2);
	cell1.innerHTML=name;
	cell2.innerHTML=id;
	document.getElementById("employeeReimbursementStatus").appendChild(row);
}

document.getElementById("view").addEventListener("click", popRTable);
 sendjaxGet(rurl, popRTable);


