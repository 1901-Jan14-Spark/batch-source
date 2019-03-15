let employeeURL = "http://localhost:9393/Project1/api/employees";
let reimbAllURL = "http://localhost:9393/Project1/api/reimbursements/all";

document.addEventListener("DOMContentLoaded", searchEmployees);
document.addEventListener("DOMContentLoaded", searchReimbursements);
//document.addEventListener("DOMContentLoaded", hideOptions);
document.getElementById("showEmployees").addEventListener("click", unhideEmpTable);
//document.getElementById("showEmployees").addEventListener("click", hideReimbTable);
document.getElementById("showReimbursements").addEventListener("click", unhideReimbTable);
document.getElementById("showReimbursements").addEventListener("click", createButtonEvents);

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
function addReimbursementRow(reimbId, empId, content, reimbAmt, resolvedMess){
	let row = document.createElement("tr");
	row.setAttribute("id", "reimRow"+reimbId);
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
    
    cell1.innerHTML = reimbId;
    cell2.innerHTML = empId;
    cell3.innerHTML = content;
    cell4.innerHTML = "$"+reimbAmt;
    let reimbButton = document.createElement("button");
    reimbButton.setAttribute("class", "btn pendingReim");
    reimbButton.setAttribute("id", "pend"+reimbId);
    reimbButton.innerHTML = resolvedMess;
    cell5.appendChild(reimbButton);

    document.getElementById("reimbursements").appendChild(row);

    var hidingRow = document.createElement("tr");
    var hidingCell1 = document.createElement("td");
    var hidingCell2 = document.createElement("td");
    var contents = document.createElement("div");
    var contents2 = document.createElement("div");
    
    hidingCell1.setAttribute("colspan", "100%");
    let approveBtn = document.createElement("button");
    let rejectBtn = document.createElement("button");
    let holdingDiv = document.createElement("div");
    holdingDiv.setAttribute("class", "holdDiv");
    
    approveBtn.setAttribute("class", "btn btn-success");
    rejectBtn.setAttribute("class", "btn btn-success");
    
    hidingRow.setAttribute("hidden", true);
    
    approveBtn.setAttribute("id", "app"+reimbId);
    rejectBtn.setAttribute("id", "rej"+reimbId);
    
    approveBtn.innerHTML = "Approve Reimbursement";
    rejectBtn.innerHTML = "Reject Reimbursement";
    
    hidingRow.appendChild(hidingCell1);
    hidingRow.appendChild(hidingCell2);

    hidingCell1.appendChild(contents);
    hidingCell2.appendChild(contents2);
    
    contents.appendChild(approveBtn);
    contents2.appendChild(rejectBtn);
    
    hidingRow.setAttribute("id", "row"+reimbId);
    hidingRow.setAttribute("class", "rowClass");

    insertAfter(hidingRow, row);
}

function createButtonEvents(){
	var buttons = document.getElementsByClassName("pendingReim");
	for (let btn of buttons){
		var input = btn.id.substring(4);
		console.log(input);
		document.getElementById("pend"+input).addEventListener("click", unHideOptions);
	}
}

function unHideOptions(input){
	var id = this.id.substring(4);
	console.log('unhideOptions ' +id);
	var hiddenRow = document.getElementById("row"+id);
	console.log(hiddenRow);
	console.log('doot');
	if(hiddenRow.hidden == true){
		hiddenRow.hidden = false;
		} else {
			hiddenRow.hidden = true;
		}
	}

//function to place hidden div underneath each row
function insertAfter(newNode, referenceNode){
	 referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
}


//callback function for showing reimbursements
function searchReimbursements(){
	sendAjaxGet(reimbAllURL, displayAllReimbursements);
}

function displayAllReimbursements(xhr){
	let reimbursements = JSON.parse(xhr.response);
	console.log(reimbursements);
	for (reimb of reimbursements){
		addReimbursementRow(reimb.reimbursementId, reimb.emp_id, reimb.content, reimb.reimbursementAmount, reimb.resolvedMessage);
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
