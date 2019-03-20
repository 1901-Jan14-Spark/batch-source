/**
 * 
 */
window.onload = function(){
	document.getElementById("submitButton").addEventListener("click", sendPut);
	setTimeout(delayPopulate, 1000);
}

function ajaxGetRequest( process) {

	let xhr = new XMLHttpRequest();

	xhr.open("get", "http://localhost:8080/ReimbursementApp/api/employees/emp");

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

function delayPopulate(){
	ajaxGetRequest(populateInfo);
}

function populateInfo(employee){

	let hiddenpw = "";
	for(let i = 0; i < employee.password.length;i++){
		
		hiddenpw += "*";
	}
		document.getElementById("eemail").innerHTML = employee.email;
		document.getElementById("epass").innerHTML = hiddenpw;
		document.getElementById("efirst").innerHTML = employee.firstname;
		document.getElementById("elast").innerHTML = employee.lastname;
}

function ajaxPostRequest(callback, objectJS) {

	let xhr = new XMLHttpRequest();

	xhr.open("put", "http://localhost:8080/ReimbursementApp/api/employees");

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

// Submit post Request
function sendPut(){
	let temp = getDataFromForm();
	ajaxPostRequest(printResponse, temp);
}

function getDataFromForm() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password1").value;
    let password2 = document.getElementById("password2").value;
    if(password != password2){
    	console.log("Password do not match.")
    	return;
    }
    let firstname  =  document.getElementById("firstname").value;
    let lastname  =  document.getElementById("lastname").value;

    let employee = {
    		email : email,
    		password : password,
    		firstname : firstname,
    		lastname : lastname
    } 
    console.log(employee);
    return employee;
}
  
function printResponse(xhrObject) {
	console.log(xhrObject.response);
}
