/**
 *  JavaScript used to render employee information on Directory.html
 */

//console.log("Hello world from directory.js")

function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

sendAjaxGet("http://localhost:8080/FrontControllerDemo/api/employees", display);


function display(xhr){
	employees = JSON.parse(xhr.response);
//	console.log(employees);
	
	let table = document.getElementById("table");
	
	for(i in employees){
		let nextRow = document.createElement("tr");
		let dpt = "n/a";
		
		if(employees[i].department){
			dpt = employees[i].department.name;
		}
		
		nextRow.innerHTML = `<td>${employees[i].name}</td><td>${dpt}</td>`;
		
		table.appendChild(nextRow);
	}	
}
