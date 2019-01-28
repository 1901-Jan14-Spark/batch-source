



 var url = "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";

     sendAjaxGet(url,  someCallBackFunction);



function someCallBackFunction(xhr){
  var  x = JSON.parse(xhr.response);
 

}

var x = document.getElementById("message");
console.log(x);

