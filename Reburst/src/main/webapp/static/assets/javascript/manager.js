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
} );