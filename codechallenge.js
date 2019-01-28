var url = "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";

     sendAjaxGet(url,  someCallBackFunction);

     var  jsonObjectx= "";

function someCallBackFunction(xhr){
    jsonObjectx = JSON.parse(xhr.response).message;
    console.log(jsonObjectx);
    var stringifiedobj = JSON.stringify(jsonObjectx);
  

  var messageHook = document.getElementById("message");
   messageHook.innerHTML= stringifiedobj;

 
  console.log(stringifiedobj.message);
}

var messageHook = document.getElementById("message");





function sendAjaxGet(url, callback){

   
    let xhr = new XMLHttpRequest();

    xhr.open("GET", url);

    xhr.onreadystatechange = function(){
        if(this.readyState===4 && this.status===200){
            callback(this);
        } else if (this.status== 400){
            displayError();
        }
    }

    xhr.send();


  }




