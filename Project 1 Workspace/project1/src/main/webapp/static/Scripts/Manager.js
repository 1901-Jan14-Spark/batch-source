
const employeeBody = document.getElementById("employeeBody");
const employeeSelect = document.getElementById("employeeSelect");
const updatebtn = document.getElementById("updateBtn");
const tableBodyM = document.getElementById("tableBodyM");

function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}


function makeAjaxPost(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 201){
			func(this);
		}
	}
	xhr.open("POST", url);
	xhr.send();
}

function makeAjaxPut(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.open("PUT", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 202){
			func(this);
		}
	}
	xhr.setRequestHeader("Content-Type", "application/json");
	let jsonReimbursement = JSON.stringify(newReimbursement);
	console.log(jsonReimbursement);
	xhr.send(jsonReimbursement);
}

sendAjaxGet("http://localhost:8080/HelloWorld/api/employees", displayEmployees);

function displayEmployees(xhr){
	employees = JSON.parse(xhr.response);
	let table = employeeBody;
	let select = employeeSelect;
	for(i in employees){
		let nextRow = document.createElement("tr");
		let nextOption = document.createElement("option");
		
		nextOption.innerHTML = `${employees[i].id}`;
		select.appendChild(nextOption);
		
		nextRow.innerHTML = `<td>${employees[i].id}</td>
							<td>${employees[i].username}</td>
							<td>${employees[i].password}</td>
							<td>${employees[i].email}</td>
							<td>${employees[i].address}</td>
							<td>${employees[i].phone}</td>`;
		table.appendChild(nextRow);
	}
}


let newReimbursement = {
		r_id: 0,
		e_id: 0,
		amount: 0,
		status: "",
		r_Type: "",
		submitted: "",
		resolved: null,
		m_id: 0
}
function displayReimbursements(xhr){
	reimbursements = JSON.parse(xhr.response);
	let tableM = tableBodyM;
	for(i in reimbursements){
		let nextRow = document.createElement("tr");
		
		nextRow.innerHTML = `<td>${reimbursements[i].r_id}</td>
							<td>${reimbursements[i].e_id}</td>
							<td>${reimbursements[i].amount}</td>
							<td>${reimbursements[i].status}</td>
							<td>${reimbursements[i].r_Type}</td>
							<td>${reimbursements[i].submitted}</td>
							<td>${reimbursements[i].resolved}</td>
							<td>${reimbursements[i].m_id}</td>`;
		tableM.appendChild(nextRow);
	}
}
sendAjaxGet("http://localhost:8080/HelloWorld/api/reimbursements", displayReimbursements);
function grabReimbursement(){
		let rValue = document.getElementById("r_Id").value
		reimbursements = JSON.parse(xhr.response);
		console.log(reimbursements);
		for(i in reimbursements){
			if(reimbursements[i].r_id == rValue){
				newReimbursement.r_id = reimbursements[i].r_id;
				newReimbursement.e_id = reimbursements[i].e_id;
				newReimbursement.amount = reimbursements[i].amount;
				newReimbursement.status = reimbursements[i].status;
				newReimbursement.r_Type = reimbursements[i].r_Type;
				newReimbursement.submitted = reimbursements[i].submitted;
				newReimbursement.resolved = reimbursements[i].resolved;
				newReimbursement.m_id = reimbursements[i].m_id;
		}
		console.log(newReimbursement);
	}
}

updatebtn.addEventListener("click", updateReimbursement);

function updateReimbursement(){
	console.log(newReimbursement);
	sendAjaxGet("http://localhost:8080/HelloWorld/api/reimbursements", grabReimbursement);
	console.log(newReimbursement);
	newReimbursement.r_Type = document.getElementById("status").value;
	newReimbursement.submitted = document.getElementById("resolved").value;
	newReimbursement.m_id = document.getElementById("m_id").value;
	console.log(newReimbursement);
	makeAjaxPut("http://localhost:8080/HelloWorld/api/reimbursements", newReimbursement);

}