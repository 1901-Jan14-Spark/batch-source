function ajaxReq(command,extension,callback,body){//Ajax request that handles all instances of AJAX
    let url ="http://localhost:8080/api/" + extension;
    let xhr = new XMLHttpRequest();
    xhr.open(command,url);
    xhr.onreadystatechange=function(){
        if(this.readyState==4 && this.status == 200){
            callback(xhr);
            return;
        }
        if(this.readyState==4 && (this.status == 201 || this.status==204)){
            callback(xhr);
            return;
        }
        if(this.readyState==4){//This line could be better, but it gets the job done in the current context
            callback(xhr)
        }
    }
    if(command != "GET"){
        xhr.setRequestHeader("Content-type", "application/json")
        let message = JSON.stringify(body);
        xhr.send(message);
    }else
        xhr.send();
}
function makeStaticUserTable(xhr){
    let dataObj = JSON.parse(xhr.response);
    let table = document.getElementsByClassName("table");
    let row = table[0].insertRow();
    row.insertCell(0).innerHTML = "Employee Id";
    row.insertCell(1).innerHTML= "Name";
    row.insertCell(2).innerHTML= "Phone";
    row.insertCell(3).innerHTML= "Email";
    for(let i=0; i<dataObj.length; i++){
        let row = table[0].insertRow();
        row.insertCell(0).innerHTML = dataObj[i].eID;
        row.insertCell(1).innerHTML = dataObj[i].fName+" " + dataObj[i].lName ;
        row.insertCell(2).innerHTML = dataObj[i].phone;
        row.insertCell(3).innerHTML = dataObj[i].email;
       
    }
}
ajaxReq("GET","employee", makeStaticUserTable);
console.log("Connected")