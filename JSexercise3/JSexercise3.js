
let anchors = document.getElementsByTagName("a");
  let created = document.createElement("BUTTON");
  created.setAttribute("id", "performOperation");
  created.innerHTML = "calculate";
  created.setAttribute("onclick", "calculateValue()");
  document.getElementsByTagName("h3")[0].appendChild(created);

for(i=0;i<anchors.length;i++){
    if(anchors[i].name == "google"){
        anchors[i].href = "https://www.google.com/webhp?authuser=0";
    }
    else if(anchors[i].name == "twitter"){
        anchors[i].href = "https://twitter.com/?lang=en";
    }

    else if(anchors[i].name == "slack"){
        anchors[i].href = "https://slack.com/lp/two?cvosrc=ppc.google.d_ppc_google_us_en_brand-hv&cvo_creative=257483843273&utm_medium=ppc&utm_source=google&utm_campaign=d_ppc_google_us_en_brand-hv&utm_term=slack&ds_rl=1249094&cvosrc=ppc.google.slack&cvo_campaign=&cvo_crid=257483843273&Matchtype=e&utm_source=google&utm_medium=ppc&c3api=5523,257483843273,slack&gclid=Cj0KCQiAhKviBRCNARIsAAGZ7CesWrE9EeeKhNylugLEnL96wQZlHhU--O9mOmVzBaV1YeWeAFgJzIoaAj3dEALw_wcB&gclsrc=aw.ds";
    }

    else if(anchors[i].name == "javadocs"){
        anchors[i].href = "https://www.oracle.com/technetwork/java/javase/documentation/javadoc-137458.html";
    }
    else{
        console.log("not a link on the page");
    }
}

let disablePluto = document.getElementById("planet").getElementsByTagName("option");
disablePluto[2].disabled = true;
//document.getElementsByTagName("p").setAttribute("hidden", false);
//console.log(document.getElementsByTagName("p"));
// let findAttribute = document.getElementsByTagName("p");
// for(i = 0; i < findAttribute.length; i++)
// {
//     if(findAttribute[i].hasAttribute("hidden")){
//         findAttribute[i].hidden = false;
//     }
// }

//document.getElementById("planet").addEventListener("select", alienText());
// let isMars = document.getElementById("planet");
//if(document.getElementById("planet").selectedIndex == "1"){
    document.getElementById("planet").addEventListener("change", function(){
        if(document.getElementById("planet").selectedIndex == 1){
            alienText();
        }
        
    });
//}

function alienText(cIndex){
    let findAttribute = document.getElementsByTagName("p");
for(i = 0; i < findAttribute.length; i++)
{
    if(findAttribute[i].hasAttribute("hidden")){
        if(document.getElementById("planet").selectedIndex == 1){
            findAttribute[i].hidden = false;
        }
        else{
            findAttribute[i].hidden = true;
        }
    }
    }
}

function addRow(name, email, phone, birthday, color, gender, activities){
    let row = document.createElement("tr");
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    let cell5 = document.createElement("td");
    let cell6 = document.createElement("td");
    let cell7 = document.createElement("td");
    let node = document.createElement("UL");
    
    for(i = 0; i < activities.length; i++){
        if(activities[i].checked){
            let lItem = document.createElement("LI");
            lItem.innerHTML = activities[i].value;
            node.appendChild(lItem);
            //console.log(node);
        }
    }
    //         let lItem = document.createElement("LI");
    //         lItem.innerHTML = activities[i];
    //         node.appendChild(lItem);
    //     }
    // }
    cell7.appendChild(node);
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);

    cell1.innerHTML=name;
    cell2.innerHTML=email;
    cell3.innerHTML=phone;
    cell4.innerHTML=birthday;
    cell5.innerHTML=color;
    cell6.innerHTML=gender;
    
    //document.getElementsByTagName("table").getElementsByTagName("tbody")[0].appendChild(row);
    document.getElementsByTagName("tbody")[0].appendChild(row);
}

document.getElementById("form-sub").addEventListener("click", addNew);

function addNew(){
    let name = document.getElementById("firstname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let bday = document.getElementById("bday").value;
    let color = document.getElementById("color").value;
    //let genderlist = document.getElementsByName("gender");
    let finalgender= chooseGender();
    let activitiesList = document.getElementsByClassName("activity");
    //var activitiesSelected = checkActivities();
    var regex = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    var phoneRegex = /^\(?([0-9]{3})\)?[-]?([0-9]{3})[-]?([0-9]{4})$/;
     
    if(name == "" || name.length < 2){
        console.log("what is your name")
    }

    if(document.getElementById("lastname").value == "" || document.getElementById("lastname").value.lenght < 2){
        console.log("what is your last name")
    }

    if(phone == "" || phoneRegex.test(phone)==false ){
        console.log("invalid phone number");
    }

    if(email == "" || regex.test(email) == false){
        console.log("none or incorrect email")
    }
    if(finalgender == undefined){
        console.log("please select your gender")
    }
    if(bday == ""){
        console.log("what is your birthday")
    }
    if(checkActivities() != true){
        console.log("click on an activity");
    }
    else{
        addRow(name, email, phone, bday, color, finalgender, activitiesList);
    }
   //console.log(activitiesSelected);
}

document.getElementsByTagName("details")[0].setAttribute("onmouseover", "openDetails()");
  document.getElementsByTagName("details")[0].setAttribute("onmouseout", "closeDetails()");
function openDetails(){
    document.getElementsByTagName("details")[0].open = true;
}
function closeDetails(){
    document.getElementsByTagName("details")[0].open = false;
}

function concatenate(){
    let spanners = document.getElementsByTagName("span");
    let spam = "";
    for(i = 0; i < spanners.length; i++){
        spam = spam + " " + spanners[i].innerHTML;
    }
    console.log(spam);
}

function chooseGender(){
    var genderlist = document.getElementsByName("gender");
    for(i = 0; i < genderlist.length; i++){
        if(genderlist[i].checked)
        {
            return genderlist[i].value;
        }
    }
}

function checkActivities(){
    var activitiesList = document.getElementsByClassName("activity");
    for(i = 0; i < activitiesList.length; i++){
        if(activitiesList[i].checked == true){
           return true;
        }
    }
}
document.getElementById("earth_time").setAttribute("hidden", true);
document.getElementById("earth_time_check").setAttribute("onclick", "earthTime()");
function earthTime(){
    document.getElementById("earth_time").innerHTML = Date();
    document.getElementById("earth_time").hidden = false;
}

document.getElementsByTagName("h1")[0].setAttribute("onclick", "backgroundChange()");
function generateColor() {
    var letters = '0123456789ABCDEF';
    var randomColor = '#';
    for (var i = 0; i < 6; i++) {
        randomColor += letters[Math.floor(Math.random() * 16)];
      
    }
    if(color == "#000000"){
        generateColor();
    }
    else{
        return randomColor;
    }
    
  }
  
  function changeColor(){
    document.body.style.backgroundColor = generateColor();
  }

  function backgroundChange(){
    setTimeout(changeColor, 3000);
  }

  function calculateValue(){
      var num1 = Number(document.getElementById("n1").value);
      var num2 = Number(document.getElementById("n2").value);
      var operations = document.getElementById("operation");
      if(num1 == "" && num1 == "")
      {
        console.log("please enter values");
      }
      else{
          if(operations.selectedIndex == 0)
          {
            document.getElementById("result").innerHTML = num1 + num2;
          }
          else if(operations.selectedIndex == 1)
          {
            document.getElementById("result").innerHTML = num1 - num2;
          }
          else if(operations.selectedIndex == 2)
          {
            document.getElementById("result").innerHTML = num1 / num2;
          }
          else if(operations.selectedIndex == 3)
          {
            document.getElementById("result").innerHTML = num1 * num2;
          }
          else{
            document.getElementById("result").innerHTML = "enter values";
            }
        }
}
function createButton(){
    let newButton=document.createElement("button");
    newButton.setAttribute("id", "calculator-button");
}

//helloPeople function used to test this
function walkTheDom(node, func){
  var allNodes = document.getElementsByTagName(node);
  for(i = 0; i < allNodes.length - 1; i++){
    func(allNodes[i]);
  }
}

//function to test the walkTheDom
function helloPeople(node){
    node.innerHTML = "hello people";
}
concatenate();

