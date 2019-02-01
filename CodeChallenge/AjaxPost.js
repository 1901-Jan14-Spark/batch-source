const getUrl= 
"https://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/books/all";
function books(){
let xhr = new XMLHttpRequest(getUrl, callback, );
xhr.open("GET",getUrl, true);
xhr.onreadystatechange=function(){
    if(xhr.readyState===4 && xhr.status===200){
        callback(this); //passing in the entre xhr Object
        }
    }   
    xhr.send();
}


function printResponse(xhrObj){
  let jsonResponse= (xhrObj.response);
  let books= JSON.parse(jsonResponse);
  console.log(books);
}

printResponse(getUrl. books);