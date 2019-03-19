/**
 * 
 */
console.log("hello");
$(document).ready( function () {
    $('#table_id').DataTable({
    	ajax: {
    		url: 'http://localhost:8080/EmployeePortal/api/reimbursements', //where to find the data
    		dataSrc:''
    	},
    	columns:[
    		{data: "rId"},
    		{data: "rAmount"},
    		{data: "rStatus"},
    		{data: "description"},
    		{data: "rStatusChange"},
    		{data: "employee_id"}
    	]
    });
    
    $('#table_id2').DataTable({
    	ajax: {
    		url: 'http://localhost:8080/EmployeePortal/api/employees', //where to find the data
    		dataSrc:''
    	},
    	columns:[
    		{data: "eId"},
    		{data: "fname"},
    		{data: "lname"},
    		{data: "email"},
    		{data: "mId"}
    	]
    });
} );