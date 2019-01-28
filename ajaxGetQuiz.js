

var ourRequest = new XMLHttpRequest();
ourRequest.open('GET', url='http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message');
ourRequest.onload = function(){
    var ourData = JSON.parse(ourRequest.response);
    console.log(ourRequest.response);
    console.log(ourData);
    document.getElementById("text").innerHTML=`This text has been changed! ${ourData.message}`
}
console.log(ourData);

// ourRequest.open(GET, ,true);
ourRequest.send();


