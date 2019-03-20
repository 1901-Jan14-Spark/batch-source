

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

function sendAjaxPost(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 201){
			func(this);
		}
	}
	xhr.open("POST", url);
	xhr.send();
}

function sendAjaxPut(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 202){
			func(this);
		}
	}
	xhr.open("PUT", url);
	xhr.send();
}
sendAjaxGet("http://localhost:8080/HelloWorld/api/employees/", display);

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

function sendAjaxPut(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 202){
			func(this);
		}
	}
	xhr.open("PUT", url);
	xhr.send();
}

function display(xhr){
	employees = JSON.parse(xhr.response);
	let table = rBody;
	for(i in employees){
		let nextRow = document.createElement("tr");
		
		nextRow.innerHTML = `<td>${employees[i].id}</td>
							<td>${employees[i].username}</td>
							<td>${employees[i].password}</td>
							<td>${employees[i].email}</td>
							<td>${employees[i].address}</td>
							<td>${employees[i].phone}</td>`;
		table.appendChild(nextRow);
	}
}