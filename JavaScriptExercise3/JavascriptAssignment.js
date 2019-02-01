// // 1
let google= document.getElementsByTagName("a")[0].href="https://www.google.com/";
    document.getElementsByTagName("a")[0].innerHTML="Google";
let twitter= document.getElementsByTagName("a")[1].href="https://twitter.com/?lang=en";
    document.getElementsByTagName("a")[1].innerHTML="Twitter";
let slack= document.getElementsByTagName("a")[2].href="https://slack.com/";
    document.getElementsByTagName("a")[2].innerHTML="Slack";
let javadocs= document.getElementsByTagName("a")[3].href="https://www.oracle.com/technetwork/java/javase/documentation/javadoc-137458.html";
    document.getElementsByTagName("a")[3].innerHTML="JavaDocs";
// 2
let noPluto= document.getElementById("planet").getElementsByTagName("Option")[2].disabled= true;

//3
function alienMessage(){
    let hiddenP =document.getElementsByTagName("p");
    let opt= document.getElementById("planet");
    for(i=0; i < hiddenP.length; i++){
        if(hiddenP[i].hidden){
            if(opt.selectedIndex==1){
                hiddenP[i].hidden = false;
            }
            else{
                hiddenP[i].hidden =true;
            }
        }
    }
}
let mars = document.getElementById("planet")[1];
mars.addEventListener("click", alienMessage);

// //4 gender and activity not Working
function tableAdd(){
      var table = document.getElementsByClassName("table table-striped table-bordered table-hover table-sm")[0];
      var row = table.insertRow(1);
    
      var nam = row.insertCell(0);
      var mail = row.insertCell(1);
      var phoneNum = row.insertCell(2);
      var birth = row.insertCell(3);
      var favColor = row.insertCell(4);
      var gend = row.insertCell(5);
      var activi = row.insertCell(6);
    
      row.appendChild(nam);
      row.appendChild(mail);
      row.appendChild(phoneNum);
      row.appendChild(birth);
      row.appendChild(favColor);
      row.appendChild(gend);
      row.appendChild(activi);

      nam.innerHTML = document.getElementById("firstname").value +" " + document.getElementById("lastname").value;
      mail.innerHTML =  document.getElementById("email").value;
      phoneNum.innerHTML = document.getElementById("phone").value;
      birth.innerHTML = document.getElementById("bday").value;
      favColor.innerHTML = document.getElementById("color").value;
      gend.innerHTML = gen.checked;
      activi.innerHTML = "";
    }
    
    let sub=document.getElementById("form-sub");
    sub.addEventListener("click", tableAdd);


function gen(){
    let formG = document.getElementsByClassName("form-group");
    for(i=0; i < formG.length; i++){
            if(formG[i].checked == true){
               var  genPick= gende[i].value;
                genPick=form[i].checked;
            }
        }
    }

console.log(document.getElementsByTagName("gen"));


// 5
let detBox= document.getElementsByTagName("details")[1];

function openDetails() {
    document.getElementsByTagName("details")[0].open=true;
}

function closeDetails(){
    document.getElementsByTagName("details")[0].open=false;
}

// detBox.addEventListener("mouseover", openDetails);
// detBox.addEventListener("mouseout", closeDetails);

// 6
function showSpan(){
    let span0= document.getElementsByTagName("span")[0].innerHTML;
    let span1= document.getElementsByTagName("span")[1].innerHTML;
    let span2= document.getElementsByTagName("span")[2].innerHTML;
    let span3= document.getElementsByTagName("span")[3].innerHTML;
    let span4= document.getElementsByTagName("span")[4].innerHTML;
    let span5= document.getElementsByTagName("span")[5].innerHTML;
    let span6= document.getElementsByTagName("span")[6].innerHTML;
    let spanAll=(span0+span1+span2+span3+span4+span5+span6);
    console.log(spanAll);
}

// 7
function earthTime(){
    var span = document.getElementById("earth_time_check");
    var utcDate= new Date();
    utcDate.toString();
    span.innerHTML = utcDate;
}

let butSpan=document.getElementById("earth_time_check");
butSpan.addEventListener("click", earthTime);

// 8
//setTimeOut
let heade= document.getElementsByTagName("h1")[0].addEventListener("click", changeColor);
function changeColor(){
    setTimeout(function(){document.body.style.backgroundColor = ranColor();},
    3000);
    
    }
    // aquired function not wrote
function ranColor(){
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
    

}
// wrote this and 1st part
if(color= "#000000"){
    ranColor();

}

console.log(document.getElementsByTagName("h1")[0]);

// 9
let n1=document.getElementById("n1");
let n2=document.getElementById("n2");
let valNum=[1,2,3,4,5,6,7,8,9,0];
let opera=document.getElementById("operation");
    
