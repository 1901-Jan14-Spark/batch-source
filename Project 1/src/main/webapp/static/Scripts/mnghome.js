let employeeURL = "http://localhost:9393/Project1/api/employees";
let reimbAllURL = "http://localhost:9393/Project1/api/reimbursements";

document.addEventListener("DOMContentLoaded", searchEmployees);
document.addEventListener("DOMContentLoaded", searchReimbursements);
document.addEventListener("DOMContentLoaded", searchResReimbursements);
document.getElementById("showEmployees").addEventListener("click", unhideEmpTable);
document.getElementById("showReimbursements").addEventListener("click", unhideReimbTable);
document.getElementById("showResolvedReimb").addEventListener("click", unhideResolved);
document.getElementById("showReimbursements").addEventListener("click", createButtonEvents);
document.getElementById("empSelect").addEventListener("change", displayThisEmp)

sendAjaxGet("http://localhost:9393/Project1/session", runWelcome);

function runWelcome(xhr){
	let response = JSON.parse(xhr.response);
	document.getElementById("sessionEmail").innerHTML = `${response.email}`;
	
	if(response.email != null){
		document.getElementById("greeting").innerHTML =  `Welcome back, ${response.email} <i class="	fa fa-angle-double-down" style="font-size:20px"></i>`;
		
	} else {
		window.location = "http://localhost:9393/Project1/login";
	}
}
function unhideResolved(){
	let table = document.getElementById("resolvedTable");
	table.removeAttribute("hidden");
	
	let reimbTable = document.getElementById("reimbTable");
	reimbTable.setAttribute("hidden", true);
	
	let empTable = document.getElementById("empTable");
	empTable.setAttribute("hidden", true);
	
	let div = document.getElementById("select");
	div.setAttribute("hidden", true);
}

function unhideEmpTable(){
	let table = document.getElementById("empTable");
	table.removeAttribute("hidden");
	
	let reimbTable = document.getElementById("reimbTable");
	reimbTable.setAttribute("hidden", true);
	
	let resTable = document.getElementById("resolvedTable");
	resTable.setAttribute("hidden", true);
	
	let div = document.getElementById("select");
	div.setAttribute("hidden", true);
}

function unhideReimbTable(){
	let table = document.getElementById("reimbTable");
	table.removeAttribute("hidden");
	
	let empTable = document.getElementById("empTable");
	empTable.setAttribute("hidden", true);
	
	let resTable = document.getElementById("resolvedTable");
	resTable.setAttribute("hidden", true);
	
	let div = document.getElementById("select");
	div.removeAttribute("hidden");
}

//Making reimbursement table
function addReimbursementRow(reimbId, empId, content, reimbAmt, resolvedMess){
	let row = document.createElement("tr");
	row.setAttribute("id", "reimRow"+reimbId);
	row.setAttribute("class", "pendingReimbs");
	row.setAttribute("title", empId);
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    let cell5 = document.createElement("td");
    let cell6 = document.createElement("td");
    
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    
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

    let approveBtn = document.createElement("button");
    let rejectBtn = document.createElement("button");
    let holdingDiv = document.createElement("div");
    rejectBtn.setAttribute("type", "submit");
    rejectBtn.setAttribute("value", "Reject");
    
    approveBtn.setAttribute("class", "appBtns btn btn-success");
    rejectBtn.setAttribute("class", "rejBtns btn btn-danger");
    
    cell6.setAttribute("hidden", true);
    
    approveBtn.setAttribute("id", "app"+reimbId);
    rejectBtn.setAttribute("id", "rej"+reimbId);
    
    approveBtn.innerHTML = "Approve";
    rejectBtn.innerHTML = "Reject";
    
    cell6.appendChild(approveBtn);
    cell6.appendChild(rejectBtn);
    
    cell6.setAttribute("id", "row"+reimbId);
    cell6.setAttribute("class", "rowClass");

}

function createButtonEvents(){
	var buttons = document.getElementsByClassName("pendingReim");
	for (let btn of buttons){
		var input = btn.id.substring(4);
		document.getElementById("pend"+input).addEventListener("click", unHideOptions);
	}
	var appBtn = document.getElementsByClassName("appBtns");
	for (let app of appBtn){
		var input = app.id.substring(3);
		document.getElementById("app"+input).addEventListener("click", approveReimbursement);
	}
	var rejBtn = document.getElementsByClassName("rejBtns");
	for (let rej of rejBtn){
		var input = rej.id.substring(3);
		document.getElementById("rej"+input).addEventListener("click", rejectReimbursement);
	}
}	


function approveReimbursement(){
	var id = this.id.substring(3);
	let tableRow = document.getElementById("reimRow"+id);
	let employeeId = tableRow.firstChild.nextSibling.innerHTML;
	let content = tableRow.firstChild.nextSibling.nextSibling.innerHTML;
	let amount = tableRow.firstChild.nextSibling.nextSibling.nextSibling.innerHTML;
	let newAmount = amount.substring(1);
	console.log(amount);
	let approved = "Approved";
	
	let newReimbObj = {
			"reimbursementId": id,
			"emp_id": employeeId,
			"content": content,
			"reimbursementAmount": newAmount,
			"isResolved": 1,
			"resolvedMessage": approved,
			"mngResolved": document.getElementById("sessionEmail").innerHTML
	}
	ajaxPost(reimbAllURL, newReimbObj);
	location.reload();
	
}

function ajaxPost(url, newReimbObj){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.open("POST", url);
	xhr.onreadystatechange = function (){
		if(this.readyState === 4 && xhr.status === 201){
			console.log('post worked');
		}
	}
	xhr.setRequestHeader("Content-Type", "application/json");
	let jsonEmp = JSON.stringify(newReimbObj);
	console.log(jsonEmp);
	xhr.send(jsonEmp);
}

function rejectReimbursement(){
	var id = this.id.substring(3);
	let tableRow = document.getElementById("reimRow"+id);
	let employeeId = tableRow.firstChild.nextSibling.innerHTML;
	let content = tableRow.firstChild.nextSibling.nextSibling.innerHTML;
	let amount = tableRow.firstChild.nextSibling.nextSibling.nextSibling.innerHTML;
	let newAmount = amount.substring(1);
	console.log(amount);
	let rejected = "Rejected";
	
	let rejReimbObj = {
			"reimbursementId": id,
			"emp_id": employeeId,
			"content": content,
			"reimbursementAmount": newAmount,
			"isResolved": 2,
			"resolvedMessage": rejected,
			"mngResolved": document.getElementById("sessionEmail").innerHTML
	}
	ajaxPost(reimbAllURL, rejReimbObj);
	window.location.reload();
	
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

//callback function for showing reimbursements
function searchReimbursements(){
	sendAjaxGet(reimbAllURL, displayPendingReimbursements);
}

function searchResReimbursements(){
	sendAjaxGet(reimbAllURL, displayResolvedReimbursements);
}

function displayPendingReimbursements(xhr){
	let reimbursements = JSON.parse(xhr.response);
	for (reimb of reimbursements){
		if(reimb.isResolved == 1 || reimb.isResolved == 2){
			continue;
		} else {
		addReimbursementRow(reimb.reimbursementId, reimb.emp_id, reimb.content, reimb.reimbursementAmount, reimb.resolvedMessage);
		}
	}
}

function displayResolvedReimbursements(xhr){
	let reimbursements = JSON.parse(xhr.response);
	for (reimb of reimbursements){
		if (reimb.isResolved == 0){
			continue;
		} else {
			addResReimbursementRow(reimb.reimbursementId, reimb.emp_id, reimb.content, reimb.reimbursementAmount, reimb.resolvedMessage, reimb.mngResolved)
		}
	}
}

function addResReimbursementRow(reimbId, empId, content, reimbAmt, resolvedMessage, mngResolved){
	let row = document.createElement("tr");
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    let cell5 = document.createElement("td");
    let cell6 = document.createElement("td");
    
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    
    cell1.innerHTML = reimbId;
    cell2.innerHTML = empId;
    cell3.innerHTML = content;
    cell4.innerHTML = "$"+reimbAmt;
    cell5.innerHTML = resolvedMessage;
    cell6.innerHTML = mngResolved;

    document.getElementById("resolved").appendChild(row);
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
		
		if(!emps.reportsTo == 0){
			addOptions(emps.id, emps.firstName, emps.lastName);
		}
	}
}

function addOptions(id, firstName, lastName){
	let selectEmp =  document.getElementById("empSelect");
	let opt = document.createElement("option");
	
	opt.innerHTML = `${id} -- ${firstName} ${lastName}`;
	selectEmp.appendChild(opt);
}

function displayThisEmp(){
	sendAjaxGet(reimbAllURL, thisEmpsReimbs);
}

function thisEmpsReimbs(xhr){
	let empString = document.getElementById("empSelect").value;
	let empId = empString.substring(0, 1);
	let reimbs = JSON.parse(xhr.response);
	let allReims = document.getElementsByClassName("pendingReimbs");
	for(r of allReims){
		if (r.title != empId){
			r.setAttribute("hidden", true);
		} else {
			r.removeAttribute("hidden");
		}
		if (empString == "-- All Employee Reimbursements --"){
			r.removeAttribute("hidden");
		}
		
	}
	
}

function sendAjaxGet(url, funct){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function (){
		if(this.readyState === 4 && this.status === 200){
			funct(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

