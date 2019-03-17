let employeeUrl = "http://localhost:9393/Project1/api/employees";

document.getElementById("showRequestForm").addEventListener("click", unhideForm);
document.getElementById("showReimbursements").addEventListener("click", unhidePendingTable);
document.getElementById("showResolvedReimb").addEventListener("click", unhideResolved);

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

//function to hide employeeId -- needed when submitting reimbursements.
sendAjaxGet(employeeUrl, storeId);
function storeId(xhr){
	let empId = JSON.parse(xhr.response);
	let sessionEmail = document.getElementById("sessionEmail").innerHTML;
	for (emps of empId){
		if(emps.email == sessionEmail){
			document.getElementById("hiddenId").innerHTML = emps.id;
		}
	}
}
