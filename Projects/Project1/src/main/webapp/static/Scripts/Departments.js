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

sendAjaxGet("http://localhost:8080/Project1/api/departments", display);

function display(xhr){
	departments = JSON.parse(xhr.response);
	
	let table = document.getElementById("table");
	
	for(i in departments){
		let nextRow = document.createElement("tr");	
		nextRow.innerHTML = `<td>${departments[i].deptId}</td><td>${departments[i].name}</td><td>${departments[i].managerId}</td>></td>`;
		table.appendChild(nextRow);
	}
}