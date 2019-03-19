$(document).ready( function () {
    $('#reqTable').DataTable({
    	ajax: {
    		url: 'http://localhost:8080/RefundSite/reqdata', //where to find the data
    		dataSrc:''
    	},
    	columns:[
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
} );
