/**
 * 
 */
let murl = "http://localhost:8080/Project_1//ManagerNameApi";

function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//console.log("Onready")
		if(this.readyState===4 && this.status===200){
			callback(this)
		}
	}
	xhr.open("GET",url);
	xhr.send();
}

function popInfo(xhr){
	let manager = JSON.parse(xhr.response);
	console.log(manager);
	
	 document.getElementById("ManagerName").innerHTML = manager;
	
	
}

sendAjaxGet(murl,popInfo);