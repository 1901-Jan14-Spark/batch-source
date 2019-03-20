const getReimbursementByID = "http://localhost:8080/project-one/api/reimbursement?id=12";
const getEmployeesByID = "http://localhost:8080/project-one/api/employees?eid=2";
const postReimbursement = "http://localhost:8080/project-one/api/reimbursement";

var employee;
var reimbursement;






window.onload = function(){



    //fetch and populate employee
    makeAjaxGet(getEmployeesByID, fetchEmployee);

    //fetch and populate reimbursement
    makeAjaxGet(getReimbursementByID, fetchReimbursement);


   document.getElementById("detailblock").style.display="none"; 

}



function makeAjaxGet(url, callback){
    let xhr = new XMLHttpRequest();
    xhr.open("GET",url,false);
    xhr.onreadystatechange = function(){
        if(xhr.readyState===4 && xhr.status===200){
            callback(this); // passing in the entire xhr object
        }
    }
    xhr.send();
    
}



function fetchEmployee(xhrObj){
    let jsonResponse = xhrObj.response;
    employee = "";
     employee = JSON.parse(jsonResponse);
     

     populateHomePage(employee);
             
      }
      

      function fetchReimbursement(xhrObj){
        let jsonResponse = xhrObj.response;
        reimbursement = "";
        reimbursement = JSON.parse(jsonResponse);
         
    
         populatetable(reimbursement);
                 
          }
     
    
 
function populateHomePage(employee){
     
   
     document.getElementById('name').innerHTML =  "Name: "  + employee[0].firsName + " " + employee[0].lastName;
     document.getElementById('salary').innerHTML =  "Salary: "  + employee[0].salary ;
     document.getElementById('email').innerHTML =  "Email: "  + employee[0].email ;
     document.getElementById('hiredate').innerHTML =  "Hire Date: "  + employee[0].hireDate ;
     document.getElementById('tid').innerHTML =  "Title: "  + employee[0].title.title ;


}



function populatetable(reimbursement){





    for(r of reimbursement){
        addRow(r.rID, r.description, r.amount,r.submittedDate,r.approvalStatus,r.approver,r.lastActivity,r.eid );
     // ADD ROW
  
        
    }
    
console.log(reimbursement[0]);



}







// ADD ROW
function addRow(rID, description, amount,submittedDate,approvalStatus,approver,lastActivity,eid){
     //create row element for both main and side table and set the attribute 
    let row = document.createElement("tr");
    row.setAttribute("onclick", "tableClicked(this)");
    
    let srow = document.createElement("tr");
    srow.setAttribute("onclick", "tableClickEvents(this)");
    
    
    //create data cells (columns) for both tables
    let cell1 = document.createElement("td");
    
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    
    let cell5 = document.createElement("td");
    let cell6 = document.createElement("td");
    let cell7 = document.createElement("td");
    let cell8 = document.createElement("td");
    
    

 

    //change color true/false accordingly
  //  resolved?cell4.style.color = '#00BA00': cell4.style.color = '#d00';
    


    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);
   // row.appendChild(cell8);

    
   
   //prevent duplicates from being populated on the side table
    // if (id < 26){
    // srow.appendChild(scell1);
    // srow.appendChild(scell2);
    // }
    
    

    // if(id===undefined){
    //     id = counter;
    //     counter++;
    // }
    

    cell1.innerHTML=rID;
    cell2.innerHTML=description // notes + "<br /> <b> - " + nameF;
    cell3.innerHTML=amount
    
    cell4.innerHTML=submittedDate;
    cell5.innerHTML=approvalStatus;
    cell6.innerHTML=approver;
    cell7.innerHTML=lastActivity;
    cell8.innerHTML=eid;
 
    
    
    // if (id < 26){
    // scell1.innerHTML=id;
    // scell2.innerHTML=nameF;
    // }
    

   var some = document.getElementById("reimbursementTable").appendChild(row);
    
    
   var containerH = document.querySelector('.sideblock #userTable');
   // containerH.appendChild(srow);
    
}



function tableClicked( x){

   

  
  document.getElementById("tableblock").style.display="none"; 
  document.getElementById("detailblock").style.display="block"; 


}


function tableClicked( x){

    var pickedID = x.children[1].innerHTML;
  //console.log("printing " + pickedID);

  
  document.getElementById("tableblock").style.display="none"; 
  document.getElementById("detailblock").style.display="block"; 


    

    console.log( x.children[0].innerHTML,x.children[1].innerHTML,x.children[2].innerHTML,
        x.children[3].innerHTML,x.children[4].innerHTML,x.children[5].innerHTML)


  document.getElementById('detail-Id').innerHTML = "ID: " + x.children[0].innerHTML;
  document.getElementById('detail-submit').innerHTML ="Amount: " + x.children[2].innerHTML;
  document.getElementById('detail-amount').innerHTML ="Date " +   x.children[3].innerHTML;
  document.getElementById('detail-description').innerHTML =  x.children[1].innerHTML;
  


}


function formSubmit(){


   console.log("submit!!")

   


  console.log( document.getElementById('amount').value);
  
  console.log( document.getElementById('exampleFormControlTextarea2').value);

  

  var r = new reimbursementObj(100,"SDDS", 3);

  var json = JSON.stringify(r);


   console.log(json);

  //makeAjaxPost(postReimbursement, tempCallBack, jsonRaw);

  document.getElementById('amount').value = "";
  document.getElementById('exampleFormControlTextarea2').value = "";
  
  document.getElementById("tableblock").style.display="block"; 
  document.getElementById("detailblock").style.display="none"; 

}



// AJAX POST
function makeAjaxPost(url, callback, newObject){
    let xhr = new XMLHttpRequest();
    xhr.open("POST", url);
    xhr.onreadystatechange = function(){
        if(xhr.readyState===4 && xhr.status===201){
            callback(this);
        }
        else{}
    }
    xhr.setRequestHeader("Content-Type","application/json");
    let jsonBook = JSON.stringify(newObject);
    xhr.send(jsonBook);

}


function tempCallBack(){

console.log("callback")



}











function reimbursementObj(amount,description, eid ){
     
    
      this.rID = 0,
    this.description= description;
    this.amount= amount
    this.submittedDate = "2018-11-09",
    this.approvalStatus = 0,
    this.approver= "",
    this.receipts = "null",
    this.lastActivity = "2018-04-26",
    this.eid = eid



			
	
}
function goBack(){


    document.getElementById('amount').value = "";
    document.getElementById('exampleFormControlTextarea2').value = "";
    
    document.getElementById("tableblock").style.display="block"; 
    document.getElementById("detailblock").style.display="none"; 



}


var jsonRaw ={"rID":0,"description":"zero praesent lectus vestibulum quam sapien varius ut blandit non",
"amount":789.09,"submittedDate":"2017-11-16","approvalStatus":3,"approver":"6",
"receipts":null,"lastActivity":"2018-08-01","eid":12}