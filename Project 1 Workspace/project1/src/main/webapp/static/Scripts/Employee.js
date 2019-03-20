


const all = document.getElementById("ALL");
const pending = document.getElementById("PENDING");
const other = document.getElementById("RESOLVED/DENIED");
const submitAccess = document.getElementById("submitAccess");
const rTable = document.getElementById("rTable");
const rBody = document.getElementById("rTableBody");
const updatebtn = document.getElementById("updateBtn");
const profileBody = document.getElementById("profileBody");

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
	xhr.open("PUT", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 202){
			console.log(xhr.response);
		}
	}
	xhr.setRequestHeader("Content-Type", "application/json");
	let jsonEmployee = JSON.stringify(currentEmployee);
	console.log(jsonEmployee);
	xhr.send(jsonEmployee);
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

//logout.addEventListener("click", logoutApp);
//function logoutApp(){
//	sendAjaxGet("http://localhost:8080/HelloWorld/logout", displayProfile);
//}


let currentEmployee = {
	id: 0,
	username: "",
	password: "",
	email: "",
	address: "",
	phone: "",
	isManager: 0
}

function saveEmployee(xhr){
	emp = JSON.parse(xhr.response);
	currentEmployee.id = emp.id;
	currentEmployee.username = emp.username;
	currentEmployee.password = emp.password;
	currentEmployee.email = emp.email;
	currentEmployee.address = emp.address;
	currentEmployee.phone = emp.phone;
	currentEmployee.isManager = emp.isManager;
}
sendAjaxGet("http://localhost:8080/HelloWorld/api/employees/id", saveEmployee)

updatebtn.addEventListener("click", updateEmployee);

function updateEmployee(){
//	if(document.getElementById("username").value != ""){
		currentEmployee.username = document.getElementById("username").value;
		console.log(document.getElementById("username").value);
//	}
	if(document.getElementById("password").value != ""){
		currentEmployee.username = document.getElementById("password").value;
	}
	if(document.getElementById("email").value != ""){
		currentEmployee.username = document.getElementById("email").value;
	}
	if(document.getElementById("address").value != ""){
		currentEmployee.username = document.getElementById("address").value;
	}
	if(document.getElementById("phone").value != ""){
		currentEmployee.username = document.getElementById("phone").value;
	}
	console.log(currentEmployee);
	sendAjaxPut("http://localhost:8080/HelloWorld/api/employees", currentEmployee);
}
