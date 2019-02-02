

//1)

var googleLink = document.querySelector('.container a');
googleLink.href= "https://www.google.com/";
googleLink.innerHTML="Google";


var twitterLink = document.querySelector('.container a[name="twitter"]');

 twitterLink.href= "https://twitter.com/";
 twitterLink.innerHTML="Twitter";


 var slackLink = document.querySelector('.container a[name="slack"]');

 slackLink.href= "https://slack.com/";
 slackLink.innerHTML="Slack";

 var javaDocsLink = document.querySelector('.container a[name="javadocs"]');

 javaDocsLink.href= "https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html";
 javaDocsLink.innerHTML="Java Docs";



 
 //2)
 //Removed Pluto//
 var pluto = document.getElementById("planet");
 pluto.remove(2);
   
  // console.log(pluto.value)
 
 


  //3)
pluto.addEventListener("change", alienText);
//document.getElementById("planet").addEventListener("change", alienText);

 
   function alienText(a){
    var detailTag = document.getElementsByTagName("DETAILS")[0];
     if (pluto.value !== "Earth"){
  
      var newDiv =  document.createElement('div');
      newDiv.className= 'hello';
      newDiv.id = 'hello1';
      newDiv.setAttribute('title', 'Hello Div');
      var newDivText = document.createTextNode('Alien gibberish goes here ');
      newDiv.appendChild(newDivText);
      var containerH = document.querySelector('.container .form-group');
      console.log(containerH);
      var planetPicker = document.getElementById("planet");
      console.log(planetPicker);
      newDiv.style.fontSize = '30px';
      containerH.insertBefore(newDiv, planetPicker);
     }
    }



   //4)
   var detailTag = document.getElementsByTagName("DETAILS")[0].addEventListener("mouseover", openDetails);
   document.getElementsByTagName("DETAILS")[0].addEventListener("mouseout", cloeseDetails);
  //  item.addEventListener("mouseover", func, false);
  //  item.addEventListener("mouseout", func1, false);

   function openDetails(a){

    var detailTag = document.getElementsByTagName("DETAILS")[0].open = true;


   }
   function cloeseDetails(a){

    var detailTag = document.getElementsByTagName("DETAILS")[0].open = false;


   }



  //Number 6
   printSpanElements();
function printSpanElements(){

var spanElements = document.getElementsByTagName("SPAN");
var concatinatedSpan= "";

for ( x=0; x < spanElements.length; x++){
  
  concatinatedSpan +=  spanElements[x].innerHTML;
   

}
//console.log(concatinatedSpan);

}







//Number 7
document.getElementById("earth_time_check").addEventListener("click", function(){

  
     
 document.getElementById("earth_time").innerHTML = new Date().toString();


});



//Number 8

 document.querySelector('.container h1').addEventListener("click", function(){

  
  console.log("hoelllel");

    setTimeout(function() {
    changeBackgroundColor(); }, 3000);
 
 
 });
 function changeBackgroundColor() {
  
  
      var element =  document.querySelector('.container h1');
      //generate random red, green and blue intensity
      var r = getRandomInt(0, 255);
      var g = getRandomInt(0, 255);
      var b = getRandomInt(0, 255);
      
      element.style.backgroundColor = "rgb(" + r + "," + g + "," + b + ")";
      //document.getElementById("colorvalue").innerHTML = r + " " + g + " " + b;
  


 }
 function getRandomInt(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}





//9)

document.getElementById("operation").addEventListener("change", performCalculation);


function performCalculation(){
 

  console.log("herer we go");
   let value = "";
  let operation = document.getElementById("operation").value;
  let n1 = Number(document.getElementById("n1").value);
  let n2 =Number( document.getElementById("n2").value);
  let display =document.getElementById("result");

   if (n1&&n2){

   switch(operation){
    case "Add": value = n1 + n2;
    break;
    case "Subtract": value = n1 - n2;
    break;
    case "Add": value = n1 + n2;
    break;
    case "Divide": value = n1 / n2;
    break;
    case "Multiply": value = n1 * n2;
    break;

   }
    console.log(display);
    display.innerHTML = value;
  
  }

  document.getElementById("result").innerHTML = "Enter Numbers";


}





//10


    //walkTheDome(node start travesing at, function we call every time we visit a node)  
function walkTheDom(node, func){
  //call a function on the node   
func(node);

//look to see if the node have a first child 
node = node.firstChild;
while(node){
  // if so, we call walk the dome on that node 
  walkTheDom(node, func);
  //when it comes back, we look to see if it have a next sibling 
  node = node.nextSibling;

}

}














   document.getElementById("form-sub").addEventListener("click", addNew);

   function addNew(){
     



    let firstName = document.getElementById("firstname").value;
    
    let lastName = document.getElementById("lastname").value;
    
    let email = document.getElementById("email").value;
    
    let phone = document.getElementById("phone").value;
    
    let bday = document.getElementById("bday").value;

    let planet = document.getElementById("planet").value;
    

    
     
   var formElements = document.getElementsByClassName("form-group")[0];
    //console.log(formElements);
    var selectionGender="";

    for (i in formElements){
    if(formElements[i].name == "gender"){
      if(formElements[i].checked == true){

        selectionGender = formElements[i].value;
      
      }}
    let bday = document.getElementById("bday").value;
    addRow(formElements[0].value + " " + firstName, lastName, email, phone, selectedGender, planet);

       

       function addRow(name, email, phone, bday, gender, color, activity){
        //0=name, 1=email, 2=phone, 3=birthday, 4=color, 5=gender, 6= act
          var table = document.getElementsByClassName("table")[0];
          var row = table.insertRow(1);
        
          var cell0 = row.insertCell(0);
          var cell1 = row.insertCell(1);
          var cell2 = row.insertCell(2);
          var cell3 = row.insertCell(3);
          var cell4 = row.insertCell(4);
          var cell5 = row.insertCell(5);
          var cell6 = row.insertCell(6);
        
          cell0.innerHTML = name;
          cell1.innerHTML = email;
          cell2.innerHTML = phone;
          cell3.innerHTML = bday;
          cell4.innerHTML = color;
          cell5.innerHTML = gender;
          cell6.innerHTML = cell6Func(activity);
        }

      }
    
    
    }







   




