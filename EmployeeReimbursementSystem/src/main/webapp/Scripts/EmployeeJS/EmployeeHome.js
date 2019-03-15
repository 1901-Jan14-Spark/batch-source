let pendingChecked = false;
let resolvedChecked = false;
let allChecked = false;

let url = "http://localhost:8080/Revature/employeeallReqs";

function setUrl() {
	if (pendingChecked) {
		url = "http://localhost:8080/Revature/employeependingReqs";
	} else if (resolvedChecked) {
		url = "http://localhost:8080/Revature/employeeresolvedReqs";
	} else if (allChecked) {
		url = "http://localhost:8080/Revature/employeeallReqs";
	}
}

document.getElementById("all").addEventListener("change", function() {
	allChecked = this.checked;
	setUrl();
	sendAjaxGet(url, display);
});

document.getElementById("pending").addEventListener("change", function() {
	pendingChecked = this.checked;
	setUrl();
	sendAjaxGet(url, display);
});

document.getElementById("resolved").addEventListener("change", function() {
	resolvedChecked = this.checked;
	setUrl();
	sendAjaxGet(url, display);
});


function sendAjaxGet(url, func) {
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState==4 && this.status==200) {
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

sendAjaxGet(url, display);

function display(xhr) {
	requestArr = JSON.parse(xhr.responseText).requests;
	let table = document.getElementById("requestTable");
	table.removeChild(document.getElementById("requestTableBody"));
	let newBody = document.createElement("tbody");
	newBody.setAttribute("id", "requestTableBody");
	table.appendChild(newBody);
	for (i in requestArr) {
		let newRow = document.createElement("tr");
		if (requestArr[i].manager) {
			man = `${requestArr[i].manager.firstname} ${requestArr[i].manager.lastname}`;
		} else {
			man = "n/a";
		}
		newRow.innerHTML = 
			`<td>${requestArr[i].id}</td>
			<td>${requestArr[i].status}</td> 
			<td>${requestArr[i].amount}</td> 
			<td>${man}</td>`;
		newBody.appendChild(newRow);
	}
}

//Toggle the side navigation
$("#sidebarToggle").on('click', function (e) {
	e.preventDefault();
	$("body").toggleClass("sidebar-toggled");
	$(".sidebar").toggleClass("toggled");
});