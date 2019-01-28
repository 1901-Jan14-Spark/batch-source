//1
document.getElementById("google").addEventListener("click", goToGoogle);
document.getElementById("alienMessage").style.visibility = "hidden"
document.getElementById("google").addEventListener("click", goToGoogle)
function goToGoogle(){
   
   window.location="https://www.google.com/";
    
}

document.getElementById("twitter").addEventListener("click", goToTwitter)
function goToTwitter(){
   
   window.location="https://twitter.com/";
    
}

document.getElementById("slack").addEventListener("click", goToSlack)
function goToSlack(){
   
   window.location="https://slack.com/";
    
}

document.getElementById("javadocs").addEventListener("click", goToJavaDocs)
function goToJavaDocs(){
   
   window.location="https://javadocs.com/";
   
}
//2
var planet =document.getElementById("planet")
planet.remove(2);

//3
document.querySelector('select[name="planet"]').onchange=changeEventHandler;

function changeEventHandler(event) {
if (event.target.value="Mars"){
   alienText()
  
 }
}
function alienText(){
   document.getElementById("alienMessage").style.visibility = "visible";


}

function displayError(){
   let errorNode = document.getElementById("form")
   errorNode.innerHTML = "Not all inputs were entered correctly";
   errorNode.style = "color:red; margin-top: 10px";
}
function clearError(){
   let errorNode = document.getElementById("form")
   errorNode.innerHTML = "";
}
//4
document.getElementById("form-sub").addEventListener("click", addToTable)
//document.getElementsByName("activity").addEventListener("click", check)
function addToTable(){
   clearError();
   
   let First_Name=document.getElementById("firstname").value;
   let Last_Name=document.getElementById("lastname").value;
   let Email=document.getElementById("email").value;
   let Phone=document.getElementById("phone").value;
   let Birthday=document.getElementById("bday").value;
    let gender=document.getElementById("gender").value;
    let favColor=document.getElementById("color").value;
    let activities=document.getElementById("activity").value;
    // check for errors
    var numbers = /^[0-9]+$/;
    if(Phone.match(numbers))
    {
     if(First_Name.length<2 || Last_Name.length<2){
      displayError()
     }
     
      var n = Email.search("@");
      var m=Email.search(".com");
      var o=Email.search(".");
  if(Email.includes("@")==false){
   displayError()
  }
  else if(n==0 || n==Email.length-1){
   displayError()
  }
  else if(Email.includes(".com")==false){
   displayError()
  }
  else if(m<n ||  o==n+1){
   displayError()
  }
  if(Phone.length!=10){
   displayError()
  }
 

   let row = document.createElement("tr");
   let cell1 = document.createElement("td");
   let cell2 = document.createElement("td");
   let cell3 = document.createElement("td");
   let cell4 = document.createElement("td");
   let cell5 = document.createElement("td");
   let cell6 = document.createElement("td");
   let cell7 = document.createElement("td");

   console.log(Birthday)

   row.appendChild(cell1);
   row.appendChild(cell2);
   row.appendChild(cell3);
   row.appendChild(cell4);
   row.appendChild(cell5);
   row.appendChild(cell6);
   row.appendChild(cell7)

   cell1.innerHTML=First_Name;
    cell2.innerHTML=Email;
    cell3.innerHTML=Phone;
    cell4.innerHTML=Birthday;
    cell5.innerHTML=gender;
    cell6.innerHTML=favColor;
    cell7.innerHTML=activities;

    
    
   //  var checkedValue = null;
   //  var i =0
   //  for(let i=0;i<4;i++){
   //      if(activities[i].checked){
   //        checkedValue=activities[i].value;
   //          break;

   //      }
   //    }
   //    cell7.innerHTML=checkedValue;
   //    row.appendChild(cell7);
      
   document.getElementById("table").appendChild(row);
} else {
   displayError()
}
}
 function check(){
    document.getElementById("activities").checked = false;
 }

 //5
 
  var Summ=document.getElementById("summary")
  Summ.addEventListener("mouseover", openDetails);
  function openDetails(){
    
     document.getElementById("details").open=true;
    

 }
 Summ.addEventListener("mouseout", closeDetails);
  function closeDetails(){
    
     document.getElementById("details").open=false;
    

 }
 //6
 var Message=[];
 var Message=document.getElementsByTagName("span")
 function hiddenMessage(){
     var fullMessage=" ";
     for(i=0;i<7;i++){
     var fullMessage= fullMessage.concat(Message[i].innerHTML);
     }
console.log(fullMessage)
 }
 //7
document.getElementById("earth_time_check").addEventListener("click", earthTime)
 function earthTime(){
  // var time = document.createTextNode("10:00");
    var dt = new Date();
    var ET = document.getElementById("earth_time");
    ET.innerHTML=dt.toLocaleTimeString();
    //node.appendChild(time);
  //  ET.appendChild(time);
 }
 //8
 document.getElementById("Inter").addEventListener("click", delay)
 var background=document.getElementById("Inter")

function delay(){
   setTimeout(changeColor, 3000)
}
 function changeColor(){
   var x = Math.floor(Math.random() * 256);
   var y = Math.floor(Math.random() * 256);
   var z = Math.floor(Math.random() * 256);
   if(x==0 && y==0 && z==0){
      document.body.style.backgroundColor = "blue";
   }else{
   var bgColor = "rgb(" + x + "," + y + "," + z + ")";
   document.body.style.backgroundColor = bgColor;
   }
   }
   //9
   
//if(firstNumber)
// if(firstNumber=true ){
//    calculate()
// }
document.getElementById("n1").addEventListener("input", calculate)
document.getElementById("n2").addEventListener("input", calculate)


   function calculate(){
    //  var result=1;
    let firstNumber=9
    let secondNumber=10
     firstNumber=parseInt(document.getElementById("n1").value);
     secondNumber=parseInt(document.getElementById("n2").value);
    let operation = document.getElementById("operation");

      if (operation.selectedIndex==0){
       var result =firstNumber + secondNumber;
         }
      if (operation.selectedIndex==1){
      var result =firstNumber - secondNumber;
         }

      if (operation.selectedIndex==2){
       var result =firstNumber / secondNumber;
         }

      if (operation.selectedIndex==3){
       var result =firstNumber * secondNumber;
         }
      //result=firstNumber;
         document.getElementById("result").innerHTML=result
      
      
   }
 //10
 function walkTheDom(node, func){
   func(node);
   node = node.firstChild;
   while (node) {
       walkTheDOM(node, func);
       node = node.nextSibling;
   }

 }