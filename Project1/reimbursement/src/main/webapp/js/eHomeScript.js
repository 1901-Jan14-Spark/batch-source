$(document).ready( function () {
    $('#reqTable').DataTable({
    	ajax: {
    		url: 'http://localhost:8080/RefundSite/reqdata', //where to find the data
    		dataSrc:''
    	},
    	columns:[
    		{data: "rId"},
    		{data: "eName"},
    		{data: "email"},
    		{data: "amount"},
    		{data: "desc"},
    		{data: "status"},
    		{data: "resolvedBy.eName"},
    		{data: "resolvedBy.email"}
    	]
    });
} );

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
	document.getElementById("currUserName").innerHTML = requests.eName;
}