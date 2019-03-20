


const selectOption = document.getElementById("accessOption");
const submitAccess = document.getElementById("submitAccess");
const rTable = document.getElementById("rTable");
const rBody = document.getElementById("rTableBody");
const update = document.getElementById("updateBtn");
const logout = document.getElementById("logout");



sendAjaxGet("http://localhost:8080/HelloWorld/api/reimbursements/id", display);

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

function sendAjaxPut(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 202){
			func(this);
		}
	}
	xhr.open("PUT", url);
	xhr.send();
}

function employee(xhr){
	employee = JSON.parse(xhr.response);
	
}

function display(xhr){
	reimbursements = JSON.parse(xhr.response);
	let table = rBody;
	for(i in reimbursements){
		let nextRow = document.createElement("tr");
		
		nextRow.innerHTML = `<td>${reimbursements[i].id}</td>
							<td>${reimbursements[i].username}</td>
							<td>${reimbursements[i].password}</td>
							<td>${reimbursements[i].email}</td>
							<td>${reimbursements[i].address}</td>
							<td>${reimbursements[i].phone}</td>`;
		table.appendChild(nextRow);
	}
}