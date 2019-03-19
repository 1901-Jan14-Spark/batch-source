let employeeUrl = "http://localhost:9393/Project1/api/employees";
let reimbUrl = "http://localhost:9393/Project1/api/reimbursements";

document.getElementById("showRequestForm").addEventListener("click", unhideForm);
document.getElementById("showReimbursements").addEventListener("click", unhidePendingTable);
document.getElementById("showResolvedReimb").addEventListener("click", unhideResolved);
document.getElementById("submitRequest").addEventListener("click", processPostRequest);

function unhideForm(){
	let form = document.getElementById("createReimb");
	form.removeAttribute("hidden");
	
	let pending = document.getElementById("pendingTable");
	pending.setAttribute("hidden", true);
	
	let resolved = document.getElementById("resolvedTable");
	resolved.setAttribute("hidden", true);
}

function unhidePendingTable(){
	let pending = document.getElementById("pendingTable");
	pending.removeAttribute("hidden");
	
	let form = document.getElementById("createReimb");
	form.setAttribute("hidden", true);
	
	let resolved = document.getElementById("resolvedTable");
	resolved.setAttribute("hidden", true);
}

function unhideResolved(){
	let resolved = document.getElementById("resolvedTable");
	resolved.removeAttribute("hidden");
	
	let form = document.getElementById("createReimb");
	form.setAttribute("hidden", true);
	
	let pending = document.getElementById("pendingTable");
	pending.setAttribute("hidden", true);
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



sendAjaxGet(reimbUrl, viewReimbursements);

function viewReimbursements(xhr){
	let reimbs = JSON.parse(xhr.response);
	document.getElementById("hiddenLength").value = reimbs.length;
	for(r of reimbs){
		r.emp_id;
	}
}

//function to hide employeeId -- needed when submitting reimbursements.
sendAjaxGet(employeeUrl, storeId);
function storeId(xhr){
	let empId = JSON.parse(xhr.response);
	let sessionEmail = document.getElementById("sessionEmail").innerHTML;
	for (emps of empId){
		if(emps.email == sessionEmail){
			document.getElementById("hiddenId").value = emps.id;
		}
	}
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
	
	console.log(newReimbObj);
	ajaxPost(reimbUrl, newReimbObj);
	location.reload();
}