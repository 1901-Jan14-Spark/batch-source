// Problem 1
let allA = (document.getElementsByTagName("a"));
let aLinks = ["https://www.google.com/", "https://www.twitter.com", "https://www.slack.com","https://www.javadocs.com"];
for (i=0; i<allA.length; i++){
    allA[i].setAttribute("href",aLinks[i]);
    allA[i].innerHTML = aLinks[i];
}

// Problem 2
let pOptions = document.getElementById("planet");
pOptions[2].remove();

// Problem 3
function alienText(){

    let p = document.getElementsByTagName("p");
    if(pOptions.value!="Earth")
        p[5].hidden = false;
    else   
        p[5].hidden = true;
}

pOptions.setAttribute("onchange","alienText()"); // realized this after working on the calculator
//pOptions.addEventListener("click", alienText()); //doesnt work with this either
// pOptions[1].setAttribute("onclick", "alienText()"); //This doesnt work.
// pOptions.setAttribute("onclick", "alienText()"); // This does, but not in the way I want it to.

//Problem 4
function addRow(){
   let firstName = document.getElementById("firstname").value;
   let lastName = document.getElementById("lastname").value;
   let email = document.getElementById("email").value;
   let phone = Number(document.getElementById("phone").value);
   let bday = document.getElementById("bday").value;
   let fColor = document.getElementById("color").value;
   let genderR = document.getElementsByName("gender");
   let activities = document.getElementsByClassName("activity");
   let gender;
   for(i=0; i<genderR.length; i++){
        if(genderR[i].checked)
            gender = genderR[i].value;
    }
    let acts =[];
    for(i=0; i<activities.length; i++)   
        if(activities[i].checked) 
            acts.push(activities[i].value);
   if (firstName.length < 2){
       alert("First Name has to be at least two letters!");
       return;
   }
   if (lastName.length < 2){
    alert("Last Name has to be at least two letters!");
    return;
   }
   if (!/\d{10}/.test(phone)){
       alert("Invalid phone number!");
       return;
   }
   if (!/@/.test(email)){
       alert("Invalid email address!");
       return;
   }
    if (bday==""){
        alert("No birthday specified!");
        return;
   }
   if (gender==null){
       alert("No gender selected!")
       return
   } 
   if (fColor == null){
        alert("No favorite color specified!");
        return;
}
    if(acts == null){
        alert("No activities checked!")
        return;
    }

let name = firstName + " " + lastName;
let table = document.getElementsByClassName("table")[0];
let row = table.insertRow();
let ncell = row.insertCell(0);
let ecell = row.insertCell(1);
let pcell = row.insertCell(2);
let bcell = row.insertCell(3);
let ccell = row.insertCell(4);
let gcell = row.insertCell(5);
let acell = row.insertCell(6);
ncell.innerHTML = name;
ecell.innerHTML = email;
pcell.innerHTML = phone;
bcell.innerHTML = bday;
ccell.innerHTML = fColor;
gcell.innerHTML = gender;
let listy= "<ul>";
for(i=0 ; i<acts.length; i++){
    listy+= "<li>"+ acts[i] + "</li>";
}
listy += "</ul>"
acell.innerHTML = listy;

}
document.getElementById("form-sub").setAttribute("onclick","addRow()")

//Problem 5
function openDetails(){
    document.getElementsByTagName("details")[0].open = true;
}
function closeDetails(){
    document.getElementsByTagName("details")[0].open = false;
}
document.getElementsByTagName("details")[0].addEventListener("mouseover",openDetails);
document.getElementsByTagName("details")[0].addEventListener("mouseout",closeDetails);

//Problem 6
function printSpan(){ // This Bob Ross thing might have gone too far... lol.
    let contents = "";
    let spans = document.getElementsByTagName("span");
    for(i=0; i<spans.length; i++)
        contents += spans[i].innerHTML;
    console.log(contents)
}


//Problem 7
function currentTime(){
    let date = new Date()
    document.getElementById("earth_time").innerHTML = date.toTimeString();
}
//document.getElementById("earth_time_check").setAttribute("onclick","currentTime()");
document.getElementById("earth_time_check").addEventListener("click",currentTime); 

//Problem 8
function randomLightEnoughColor(){
    let hex = "#"
    hex += ((Math.floor(Math.random()*255) + 60)).toString(16)
    hex += ((Math.floor(Math.random()*255) + 60)).toString(16)
    hex += ((Math.floor(Math.random()*255) + 60)).toString(16)
    hex = hex.substr(0,7);// The previous three lines were only suppose to produce two bits of hex each but sometimes they were doing more... so i cheated by using substr
    return hex;
}
function setBgRanColor(){ 
    setTimeout(function(){
    let rgb = randomLightEnoughColor();
    console.log(rgb);
    document.getElementsByTagName("body")[0].style.backgroundColor = rgb;}, 3000)
}
document.getElementsByTagName("h1")[0].setAttribute("onclick","setBgRanColor()")

//Problem 9
function calculate(){
    let n1 = Number(document.getElementById("n1").value);
    console.log(n1);
    let n2 = Number(document.getElementById("n2").value);
    console.log(n2);
    let operator = document.getElementById("operation").value;
    let result;
    switch(operator){
        case "Add":
            result = n1 + n2;
            break;
        case "Subtract":
            result = n1 - n2;
            break;
        case "Divide":
            result = n1 / n2;
            break;
        case "Multiply":
            result = n1 * n2;
            break;
        default:
            console.log(operator);
    }
    document.getElementById("result").innerHTML = result;
}
document.getElementById("n1").setAttribute("onchange","calculate()");
document.getElementById("n2").setAttribute("onchange","calculate()");

//Problem 10
function walkTheDom(node,func){
   node = node.firstChild;
    while(node){
        if(!node.hasChildNodes())
            func(node)
        walkTheDom(node,func);
        node = node.nextSibling;
        }
    }
        // for(i =0; i<node.length; i++){
        //     console.log(node[i]);
        //     walkTheDom(node.childNodes[i],func);}

function whoLetTheDomsOUT(node){
    node.innerHTML = "&#128054";
}
function doggy(){
    if(document.getElementById("n1").value == "dog" || document.getElementById("n2").value == "dog")
        walkTheDom(document.getRootNode(),whoLetTheDomsOUT);
}

document.getElementById("n1").addEventListener("change",doggy); // type dog into n1 or n2 to walk the dom (:
document.getElementById("n2").addEventListener("change",doggy);


