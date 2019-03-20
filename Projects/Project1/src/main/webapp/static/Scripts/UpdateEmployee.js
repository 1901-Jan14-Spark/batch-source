window.onload = function(){
	ajaxRequest(getInfo);
}

function ajaxGetRequest(process){

	let xhr = new XMLHttpRequest();

	xhr.open("get", "http://localhost:8080/Project1/api/employees/emp");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status >= 200 && xhr.status < 300) {
				process(JSON.parse(xhr.response));
			} else {
				console.log(xhr.statusText);
			}
		}
	}
	xhr.send();
}

function populateInfo(employee){

	document.getElementById("").innerHTML = employee.username;
	document.getElementById("").innerHTML = employee.email;
	document.getElementById("epass").innerHTML = employee.password;
	document.getElementById("efirst").innerHTML = employee.firstname;
	document.getElementById("elast").innerHTML = employee.lastname;
}

function ajaxPostRequest(callback, objectJS) {

	let xhr = new XMLHttpRequest();

	xhr.open("put", "http://localhost:8080/Project1/api/employees");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status < 300 && xhr.status >= 200) {
				callback(xhr);
			} else {
				console.log(xhr.status + xhr.statustext);
			}
		}
	}

	xhr.setRequestHeader("Content-type", "application/json");
	let jsonObject = JSON.stringify(objectJS);
	xhr.send(jsonObject);
}

//Submit post Request
function sendPut(){
	let temp = getDataFromForm();
	ajaxPostRequest(printResponse, temp);
}

function getDataFromForm() {
	let firstname  =  document.getElementById("firstname").value;
	let lastname  =  document.getElementById("lastname").value;
	let email = document.getElementById("email").value;
	let username = document.getElementById("username");
	let password = document.getElementById("password1").value;
	let password2 = document.getElementById("password2").value;
	if(password != password2){
		console.log("Password do not match.")
		return;
	}


	let employee = {
			
			firstname : firstname,
			lastname : lastname,
			email : email,
			username : username,
			password : password,
			
	} 
	console.log(employee);
	return employee;
}

function printResponse(xhrObject) {
	console.log(xhrObject.response);
}