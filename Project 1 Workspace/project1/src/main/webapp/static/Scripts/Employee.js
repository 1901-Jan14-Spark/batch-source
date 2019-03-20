


const all = document.getElementById("ALL");
const pending = document.getElementById("PENDING");
const other = document.getElementById("RESOLVED/DENIED");
const submitAccess = document.getElementById("submitAccess");
const rTable = document.getElementById("rTable");
const rBody = document.getElementById("rTableBody");
const update = document.getElementById("updateBtn");
const logout = document.getElementById("logout");
const profileBody = document.getElementById("profileBody");

//window.onload = function(){
//	all.addEventListener("click", sendAjaxGet("http://localhost:8080/HelloWorld/api/reimbursements/empId", displayReimbursements));
//	pending.addEventListener("click", sendAjaxGet("http://localhost:8080/HelloWorld/api/reimbursements/pending/id", displayReimbursements));
//	other.addEventListener("click", sendAjaxGet("http://localhost:8080/HelloWorld/api/reimbursements/resolved/id", displayReimbursements));
//}

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

function displayReimbursements(xhr){
	reimbursements = JSON.parse(xhr.response);
	while(rBody.hasChildNodes()){
		rBody.removeChild(rBody.firstChild);
	}
	let table = rBody;
	for(i in reimbursements){
		let nextRow = document.createElement("tr");
		
		nextRow.innerHTML = `<td>${reimbursements[i].r_id}</td>
							<td>${reimbursements[i].amount}</td>
							<td>${reimbursements[i].status}</td>
							<td>${reimbursements[i].r_Type}</td>
							<td>${reimbursements[i].submitted}</td>
							<td>${reimbursements[i].resolved}</td>`;
		table.appendChild(nextRow);
	}
}
function displayPending(xhr){
	
}

function displayProfile(xhr){
	employee = JSON.parse(xhr.response);
	let tableRow = profileBody;
	let newRow = document.createElement("tr");
	
	newRow.innerHTML = `<td>${employee.id}</td>
		<td>${employee.username}</td>
		<td>${employee.password}</td>
		<td>${employee.email}</td>
		<td>${employee.address}</td>
		<td>${employee.phone}</td>`;
	tableRow.appendChild(newRow);
}

sendAjaxGet("http://localhost:8080/HelloWorld/api/employees/id", displayProfile);




function runall(){
	sendAjaxGet("http://localhost:8080/HelloWorld/api/reimbursements/empId", displayReimbursements);
}
function rPending(){
	sendAjaxGet("http://localhost:8080/HelloWorld/api/reimbursements/pending/id", displayReimbursements);
}
function rOther(){
	sendAjaxGet("http://localhost:8080/HelloWorld/api/reimbursements/resolved/id", displayReimbursements);
}

all.addEventListener("click", runall);
pending.addEventListener("click", rPending);
other.addEventListener("click", rOther);
