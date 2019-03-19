let employeeUrl = "http://localhost:9393/Project1/api/employees";
let reimbUrl = "http://localhost:9393/Project1/api/reimbursements";

document.getElementById("showRequestForm").addEventListener("click", unhideForm);
document.getElementById("showReimbursements").addEventListener("click", unhidePendingTable);
document.getElementById("showResolvedReimb").addEventListener("click", unhideResolved);
document.getElementById("submitRequest").addEventListener("click", processPostRequest);
document.getElementById("toProfile").addEventListener("click", showProfile);

function unhideForm(){
	let form = document.getElementById("createReimb");
	form.removeAttribute("hidden");
	
	let pending = document.getElementById("pendingTable");
	pending.setAttribute("hidden", true);
	
	let resolved = document.getElementById("resolvedTable");
	resolved.setAttribute("hidden", true);
	
	let accProf = document.getElementById("accountProfile");
	accProf.setAttribute("hidden", true);
}

function unhidePendingTable(){
	let pending = document.getElementById("pendingTable");
	pending.removeAttribute("hidden");
	
	let form = document.getElementById("createReimb");
	form.setAttribute("hidden", true);
	
	let resolved = document.getElementById("resolvedTable");
	resolved.setAttribute("hidden", true);
	
	let accProf = document.getElementById("accountProfile");
	accProf.setAttribute("hidden", true);
}

function unhideResolved(){
	let resolved = document.getElementById("resolvedTable");
	resolved.removeAttribute("hidden");
	
	let form = document.getElementById("createReimb");
	form.setAttribute("hidden", true);
	
	let pending = document.getElementById("pendingTable");
	pending.setAttribute("hidden", true);
	
	let accProf = document.getElementById("accountProfile");
	accProf.setAttribute("hidden", true);
}

sendAjaxGet("http://localhost:9393/Project1/session", runWelcome);

function runWelcome(xhr){
	let response = JSON.parse(xhr.response);
	document.getElementById("sessionEmail").innerHTML = `${response.email}`;
	
	if(response.email != null){
		document.getElementById("greetingEmp").innerHTML = `Welcome back, ${response.email} <i class="fa fa-angle-double-down" style="font-size:20px"></i>`;
		
	} else {
		window.location = "http://localhost:9393/Project1/login";
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

function ajaxPost(url, newReimbObj){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.open("POST", url);
	xhr.onreadystatechange = function (){
		if(this.readyState === 4 && xhr.status === 201){
			let message = document.getElementById("successPost");
			message.removeAttribute("hidden");
			message.innerHTML = "Your reimbursement was successfully created! Returning you to the dashboard home now.";
		}
	}
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.setRequestHeader("requestType", "postNew");
	let jsonEmp = JSON.stringify(newReimbObj);
	console.log(jsonEmp);
	xhr.send(jsonEmp);
}

//function to hide employeeId -- needed when submitting reimbursements.
sendAjaxGet(employeeUrl, storeId);
function storeId(xhr){
	let empId = JSON.parse(xhr.response);
	let sessionEmail = document.getElementById("sessionEmail").innerHTML;
	for (emps of empId){
		if(emps.email == sessionEmail){
			document.getElementById("hiddenId").value = emps.id;
			document.getElementById("empFN").innerHTML = emps.firstName;
			document.getElementById("empLN").innerHTML = emps.lastName;
			document.getElementById("empEmail").innerHTML = emps.email;
		}
	}
}

sendAjaxGet(reimbUrl, viewReimbursements);

function viewReimbursements(xhr){
	let idNum = document.getElementById("hiddenId").value;
	let reimbs = JSON.parse(xhr.response);
	document.getElementById("hiddenLength").value = reimbs.length;
	for(r of reimbs){
		if(r.emp_id = idNum){
			if(r.isResolved == 0){
				addPendingRow(r.emp_id, r.reimbursementId, r.content, r.reimbursementAmount, r.resolvedMessage);
			} else if (r.isResolved > 0){
				addResolvedRow(r.reimbursementId, r.content, r.reimbursementAmount, r.resolvedMessage, r.mngResolved);
			}
		}
	}
}

function addPendingRow(empId, reimbId, content, reqAmt, resMess){
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	let cell4 = document.createElement("td");
	let cell5 = document.createElement("td");
	
	let pendTable = document.getElementById("pending");
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	row.appendChild(cell5);
	
	cell1.innerHTML = empId;
	cell2.innerHTML = reimbId;
	cell3.innerHTML = content;
	cell4.innerHTML = `$${reqAmt}`;
	cell5.innerHTML = resMess;
	
	pendTable.appendChild(row);
}

function addResolvedRow(reimbId, content, reimbAmt, resMess, mngRes){
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	let cell4 = document.createElement("td");
	let cell5 = document.createElement("td");
	
	let resTable = document.getElementById("resolved");
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	row.appendChild(cell5);
	
	cell1.innerHTML = reimbId;
	cell2.innerHTML = content;
	cell3.innerHTML = `$${reimbAmt}`;
	cell4.innerHTML = resMess;
	cell5.innerHTML = mngRes;
	
	resTable.appendChild(row);
}


document.getElementById("formIsRes").value = "0";
document.getElementById("formResMess").value = "Pending";
document.getElementById("formMng").value = "0";
	
function processPostRequest(){
	let amountReq = document.getElementById("amountInp").value;
	let content = document.getElementById("reqReason").value;
	let formRes = document.getElementById("formResMess").value;
	let resNum = document.getElementById("formIsRes").value;
	let mngNum = document.getElementById("formMng").value;
	
	let newReimbObj = {
			"reimbursementId": parseInt(document.getElementById("hiddenLength").value) + 1,
			"emp_id": document.getElementById("hiddenId").value,
			"content": content,
			"reimbursementAmount": amountReq,
			"isResolved": resNum,
			"resolvedMessage": formRes,
			"mngResolved": mngNum
	}
	ajaxPost(reimbUrl, newReimbObj);
	window.location.replace("http://localhost:9393/Project1/employeeLogin");
}

function showProfile(){
	let form = document.getElementById("createReimb");
	form.setAttribute("hidden", true);
	
	let pending = document.getElementById("pendingTable");
	pending.setAttribute("hidden", true);
	
	let resolved = document.getElementById("resolvedTable");
	resolved.setAttribute("hidden", true);
	
	let accProf = document.getElementById("accountProfile");
	accProf.removeAttribute("hidden");
	
	let btn1 = document.getElementById("showRequestForm");
	btn1.setAttribute("hidden", true);
	
	let btn2 = document.getElementById("showReimbursements");
	btn2.setAttribute("hidden", true);
	
	let btn3 = document.getElementById("showResolvedReimb");
	btn3.setAttribute("hidden", true);
}