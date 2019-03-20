/**
 * JavaScript used to render employee information on View Employees.html
 */



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

sendAjaxGet("http://localhost:8080/Project1/api/employees", display);

function display(xhr){
	employees = JSON.parse(xhr.response);
	
	let table = document.getElementById("table");
	
	for(i in employees){
		let nextRow = document.createElement("tr");	
		nextRow.innerHTML = `<td>${employees[i].empId}</td><td>${employees[i].firstName} + " " + ${employees[i].lastName}</td><td>${employees[i].username}</td><td>${employees[i].password}</td><td>${employees[i].email}<td>${employees[i].d.name}</td></td>`;
		table.appendChild(nextRow);
	}
}