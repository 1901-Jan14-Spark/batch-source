const getURL="http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/users/all";
function getRequest(URL, callback){
let xhr = new XMLHttpRequest();

    xhr.open("GET", URL, true);
    xhr.onreadystatechange=function(){
        if(xhr.state === 4 && xhr.status===200){
            callback(this);
        }
        else{
            console.log(xhr.response);
        }
    } 
    xhr.send();
}
    
function printresponse(xhobj){
    let xresponse = xhobj.xresponse;
    let data= JSON.parse(xresponse);
        console.log(data);
    }

getRequest(getURL,printresponse);
    //document.write(getRequest(getURL,getresponse));