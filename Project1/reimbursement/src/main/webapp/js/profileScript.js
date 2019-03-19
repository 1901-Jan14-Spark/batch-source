function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState===4 && xhr.status===200){
			func(xhr);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

sendAjaxGet('http://localhost:8080/RefundSite/curremp', display);

function display(xhr){
	let requests = JSON.parse(xhr.response);
	document.getElementById("nameInput").setAttribute("value", requests.eName);
	document.getElementById("emailInput").setAttribute("value", requests.email);
	document.getElementById("passInput").setAttribute("value", requests.ePass);
}

//toggle password visibility
function myFunction() {
	  var x = document.getElementById("passInput");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}