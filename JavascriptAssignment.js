// Links to websites
document.getElementsByName("google")[0].setAttribute("href","http://google.com");
document.getElementsByName("google")[0].innerHTML = "Google";
document.getElementsByName("twitter")[0].setAttribute("href","http://twitter.com");
document.getElementsByName("twitter")[0].innerHTML ="Twitter";
document.getElementsByName("slack")[0].setAttribute("href", "http://slack.com");
document.getElementsByName("slack")[0].innerHTML = "Slack";
document.getElementsByName("javadocs")[0].setAttribute("href","http://javadocs.com");
document.getElementsByName("javadocs")[0].innerHTML = "JavaDocs";



window.onload =function(){
    remove();
    //alienText();
    //addInfo();
    //openDetails();
    document.getElementsByTagName("mouseover",open);
    consoleSpan();
    earthTime();
    //randomColor();
   // background();

}

//Remove Pluto
function remove(){
var pluto 
pluto = document.getElementById("planet").children[2];
 //console.log(pluto)
 pluto.remove(pluto);
// pluto.lastChild.removeChild("pluto");
}

//hidden alien text
 //let hidden = document.get
document.getElementsByTagName("select")[0].addEventListener("change",alienText);
let show = document.getElementsByTagName("p")[5];
function alienText(){    
var mars = document.getElementsByTagName("select")[0].children[1];
console.log(mars); 
var selected = document.getElementsByTagName("select")[0].value;
console.log(selected);
 if(selected === "Mars"){
show.removeAttribute("hidden");
console.log(show)
}else if(selected === "Earth"){
    show.style.visibility ="hidden";
}
}

///Filling the table with data

// function addInfo(name, email, phone, birthday,
//      color, gender, activities){
//          let row = document.createElement("tr");
//          let nameCell = document.createElement("td");
//          let emailCell = document.createElement("td");
//          let phoneCell = document.createElement("td");
//          let birthdayCell = document.createElement("td");
//          let colorCell = document.createElement("td");
//          let genderCell = document.createElement("td");
//          let activityCell = document.createElement("td");

//          row.appendChild(nameCell);
//          row.appendChild(emailCell);
//          row.appendChild(phoneCell);
//          row.appendChild(birthdayCell);
//          row.appendChild(colorCell);
//          row.appendChild(genderCell);
//          row.appendChild(activityCell);
        
         

//         nameCell.innerHTML = name;
//         emailCell.innerHTML=  email;
//         phoneCell.innerHTML= phone;
//         birthdayCell.innerHTML= birthday;
//         colorCell.innerHTML= color;
//         genderCell.innerHTML= gender;
//         activityCell.innerHTML= activities;

//         document.getElementsByTagName("table")[0].appendChild(row);
//      }
     
//      document.getElementById("form-sub").addEventListener("click",addNew);
//      function addNew(){
//          let nameCell = document.getElementById("firstname").value;
//          console.log(nameCell);
//          let emailCell = document.getElementById("email").value;
//          let phoneCell = document.getElementById("phone").value;
//          let birthdayCell = document.getElementById("dbday").value;
//          let colorCell = document.getElementById("color").value;
//          let genderCell = document.getElementby("").value;

//         addInfo(nameCell,emailCell,phoneCell,birthdayCell,
//             colorCell,genderCell) ;        
//      }


var x ;

function open(){
 document.getElementsByTagName("details")[0].open;
}
/// open details fucntion
// function openDetails(){
//    console.log(x);

// }     

//inner Html of all span

document.getElementById
function consoleSpan(){
   var span1 = document.getElementsByTagName("span")[0].innerHTML;
   var span2 = document.getElementsByTagName("span")[1].innerHTML;
   var span3 = document.getElementsByTagName("span")[2].innerHTML;
   var span4 = document.getElementsByTagName("span")[3].innerHTML;
   var span5 = document.getElementsByTagName("span")[4].innerHTML;
   var span6 = document.getElementsByTagName('span')[5].innerHTML;
   var span7 = document.getElementsByTagName("span")[6].innerHTML;

   console.log(span1+span2+span3+span4+span5+span6+span7);
}

//Earth Time
document.getElementById("earth_time_check").addEventListener("click",earthTime);
function earthTime(){
 var today = new Date();
  var  hr = today.getHours();
  var  min = today.getMinutes() ;
  var  time = hr + ":" + min;
document.getElementById("earth_time_check").innerHTML = time;

}


////Intergalactic Directory
document.getElementsByTagName("h4")[0].addEventListener("click", background);
function randomColor(){
    var choosers = "0123456789ABCDEG";
    var choice = '#';
    for (var i = 0; i <6; i++){
        choice += choosers[Math.floor(Math.random()*16)];
    }
        if (choice = "#999999"){
            return choice;
        }
        return choice;
        //if(color =="#000000"){
           // randomColor();
    }

function background(){
    setTimeout(function(){
        document.body.style.backgroundColor =randomColor();
    } ,3000);
}

///Calculator
let operator = document.getElementsByTagName("select")[1].value;
let first = document.getElementById("n1").value;
let second = document.getElementById("n2").value;

// function calc(){
// first 
// }

// Out of time
