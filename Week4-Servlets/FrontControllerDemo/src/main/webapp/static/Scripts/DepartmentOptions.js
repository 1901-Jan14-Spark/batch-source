/**
 * Dynamically generates the options in our department select for creating a new employee
 */

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

sendAjaxGet("http://localhost:8080/FrontControllerDemo/api/departments", populateSelect);

function populateSelect(xhr){
	let departments = JSON.parse(xhr.response);
	console.log(departments);
	
	let dptSelect = document.getElementById("dptSelect");
	
	for(i in departments){
		let newOption = document.createElement("option");
		newOption.value = departments[i].id;
		newOption.innerHTML = departments[i].name;
		dptSelect.appendChild(newOption);
	}
	
}