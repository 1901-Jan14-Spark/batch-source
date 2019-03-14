let employeeURL = "http://localhost:9393/Project1/api/employees";
let reimbAllURL = "http://localhost:9393/Project1/api/reimbursements/all";

document.addEventListener("DOMContentLoaded", searchEmployees);
document.addEventListener("DOMContentLoaded", searchReimbursements);
document.getElementById("showEmployees").addEventListener("click", unhideEmpTable);
//document.getElementById("showEmployees").addEventListener("click", hideReimbTable);
document.getElementById("showReimbursements").addEventListener("click", unhideReimbTable);

function unhideEmpTable(){
	let table = document.getElementById("empTable");
	table.removeAttribute("hidden");
	
	let reimbTable = document.getElementById("reimbTable");
	reimbTable.setAttribute("hidden", true);
}

function unhideReimbTable(){
	let table = document.getElementById("reimbTable");
	table.removeAttribute("hidden");
	
	let empTable = document.getElementById("empTable");
	empTable.setAttribute("hidden", true);
}


//Making reimbursement table
function addReimbursementRow(reimbId, empId, content, reimbAmt, isResolved, resolvedMess, mngResolved){
	let row = document.createElement("tr");
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    let cell5 = document.createElement("td");
    let cell6 = document.createElement("td");
    let cell7 = document.createElement("td");
    
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);
    
    cell1.innerHTML = reimbId;
    cell2.innerHTML = empId;
    cell3.innerHTML = content;
    cell4.innerHTML = "$"+reimbAmt;
    if (isResolved == 0) {
    	cell5.innerHTML = "No";
    } else {
    	cell5.innerHTML = "Yes";
    }
    cell6.innerHTML = resolvedMess;
    if (mngResolved == 0){
    	 cell7.innerHTML = "Unresolved";
    } else {
    	cell7.innerHTMl = mngResolved;
    }
   
    
    document.getElementById("reimbursements").appendChild(row);    
}

//callback function for showing reimbursements
function searchReimbursements(){
	sendAjaxGet(reimbAllURL, displayAllReimbursements);
}

function displayAllReimbursements(xhr){
	let reimbursements = JSON.parse(xhr.response);
	console.log(reimbursements);
	for (reimb of reimbursements){
		addReimbursementRow(reimb.reimbursementId, reimb.emp_id, reimb.content, reimb.reimbursementAmount, reimb.isResolved, reimb.resolvedMessage, reimb.mngResolved);
	}
}

//Making the table of Employees
//an addRow function that appends rows to table.
function addRow(id, firstName, lastName, email, reportsTo){
    let row = document.createElement("tr");
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    
    cell1.innerHTML = id;
    cell2.innerHTML = firstName+" "+lastName;
    cell3.innerHTML = email;
    if(reportsTo == 0){
    	cell4.innerHTML = "Manager";
    } else {
    	cell4.innerHTML = reportsTo;
    }
    
    document.getElementById("employees").appendChild(row);
}

function searchEmployees(){
	sendAjaxGet(employeeURL, displayAllEmployees);
}

function displayAllEmployees(xhr){
	let employees = JSON.parse(xhr.response);
	for (emps of employees){
		addRow(emps.id, emps.firstName, emps.lastName, emps.email, emps.reportsTo);
	}
}

function sendAjaxGet(url, funct){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function (){
		if(this.readyState === 4){
			funct(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

sendAjaxGet("http://localhost:9393/Project1/session", runWelcome);

function runWelcome(xhr){
	let response = JSON.parse(xhr.response);
	console.log(response);
	
	if(response.email != null){
		document.getElementById("greeting").innerHTML = `Welcome back, ${response.email} <i class="	fa fa-angle-double-down" style="font-size:20px"></i>`;
	} else {
		window.location = "http://localhost:9393/Project1/login";
	}
}
