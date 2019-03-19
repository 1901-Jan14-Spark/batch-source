$(document).ready( function () {
    var rTable = $('#reqTable').DataTable({
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
    
    $('#empTable').DataTable({
    	ajax: {
    		url: 'http://localhost:8080/RefundSite/employees', //where to find the data
    		dataSrc:''
    	},
    	columns:[
    		{data: "eId"},
    		{data: "eName"},
    		{data: "email"}
    	]
    });
        
    var modal = document.getElementById('arReqModal');
    var closeBtn = document.getElementById('arReqCancel');
    
    var rId = document.getElementById('reqIdInfo');
    var eName = document.getElementById('empNameInfo');
    var amount = document.getElementById('amountInfo');
    var desc = document.getElementById('descInfo');
    
    //populate form input with row data in modal
    $('#reqTable tbody').on('click', 'tr', function(){
    	var rData = rTable.row(this).data();
    	//console.log(rData);
    	rId.setAttribute('value', rData.rId);
    	eName.setAttribute('value', rData.eName);
    	amount.setAttribute('value', rData.amount);
    	desc.setAttribute('value', rData.desc);
    	modal.style.display='block';
    });
    
    //close modal when user clicks x or cancel button
    closeBtn.onclick = function(){
    	modal.style.display='none';
    }

    //close modal when user clicks outside the modal
    window.onclick = function(event) {
    	if (event.target == modal) {
    		modal.style.display = "none";
    	}
    }
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