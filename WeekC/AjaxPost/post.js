const postUrl = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/books";

function makeAjaxPost(url, callback, newBookObject){
    let xhr = new XMLHttpRequest();
    xhr.open("POST", url);
    xhr.onreadystatechange = function(){
        if(xhr.readyState===4&&xhr.status===201){
            callback(this);
        }
    }
    xhr.setRequestHeader("Content-Type","application/json");
    let jsonBook = JSON.stringify(newBookObject);
    xhr.send(jsonBook);

}

function printResponse(xhrObj){
    console.log(xhrObj.response);
}

let newBook = {
    title: "Harry Potter",
    author: "J.K. Rowling",
    publishYear: 1998
}

makeAjaxPost(postUrl,printResponse, newBook);
