
//AJAX call that requests data from server
var button = document.getElementById("button");

//my empty div I will add content to dynamically
var dataContainer = document.getElementById("data");
button.addEventListener("click", function(){
var ourRequest = new XMLHttpRequest();
ourRequest.open('GET', url='http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message');
ourRequest.onload = function(){
    var ourData = JSON.parse(ourRequest.response);
    console.log(ourRequest.response);
    console.log(ourData);
    renderHTML(ourData);
    document.getElementById("text").innerHTML=`This text has been changed! ${ourData.message}`
}
//console.log(ourData);
ourRequest.send();
});
//renders data rceived
function renderHTML(data){
    var htmlDivString = "";
    for (i=0; i < dataContainer.clientHeight; i++) {
        htmlDiveString += "<p>" + ourData[i]; + "</p>";
    }
    dataContainer.insertAdjacentHTML("beforeend", "testing123");
}

function loadDoc() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
       document.getElementById("demo").innerHTML = this.responseText;
      }
    };
    xhttp.open("GET", "ajax_info.txt", true);
    xhttp.send();
  }


  //PROBLEM 10
  function walkTheDom(node, func){
    var all = document.getElementsByTagName(node);
    for(i = 0; i < all.length - 1; i++){
      func(all[i]);
    }
  }