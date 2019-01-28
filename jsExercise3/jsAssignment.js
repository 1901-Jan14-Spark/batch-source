window.onload = function () {
    setLinks();//Problem1
    removePluto();//Problem2
    getDetails();//Problem5
    hiddenMsg();//Problem6
}

//Problem1
function setLinks() {
    document.getElementsByName("google")[0].href = "https://www.google.com/";
    document.getElementsByName("twitter")[0].href = "https://twitter.com/?lang=en";
    document.getElementsByName("slack")[0].href = "https://slack.com/";
    document.getElementsByName("javadocs")[0].href = "https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html";
}


//Problem2
function removePluto() {
    var planetVal = document.getElementById("planet");
    //find option with value 'Pluto'
    for (i = 0; i < planetVal.length; i++) {
        var opt = planetVal[i];
        //if found then remove it
        if (opt.value.toLowerCase() == "pluto") {
            planetVal.remove(i);
        }
    }
}


//Problem3
document.getElementById("planet").onchange = alienText;
var pEle = document.getElementsByTagName("p");
var index;
//search through all <p> elements
for (i = 0; i < pEle.length; i++) {
    var hasHidden = pEle[i].hasAttribute("hidden");
    //find the one <p> element that has the hidden attribute
    if (hasHidden == true)
        index = i;
}

function alienText() {
    var planetSel = document.getElementById("planet");
    var selected = planetSel.value;
    //if the planet select value is not earth set hidden attribute 
    if (selected.toLowerCase() != "earth")
        pEle[index].removeAttribute("hidden");

    else
        pEle[index].setAttribute("hidden", "");


}


//Problem4
document.getElementById("form-sub").addEventListener("click", submitForm);

function submitForm() {
    //get all input values
    var first = document.getElementById("firstname").value;
    var last = document.getElementById("lastname").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var bDay = document.getElementById("bday").value;
    var sexSel = findSex();
    var favCol = document.getElementById("color").value;
    var actList = findList();
    if (first.length > 2 && last.length > 2 && phone.length == 10 && email.indexOf("@") != -1 && sexSel != undefined) {
        //create new row and cells
        var table = document.getElementsByTagName("tbody");
        var rowCount = table[0].childElementCount;
        var row = table[0].insertRow(rowCount);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);
        cell1.innerHTML = first + " " + last;
        cell2.innerHTML = email;
        cell3.innerHTML = phone;
        cell4.innerHTML = bDay;
        cell5.innerHTML = favCol;
        cell6.innerHTML = sexSel;
        for (i = 0; i < actList.length; i++)
            cell7.innerHTML += "<ul><li>" + actList[i] + "</li></ul>"

    }
    else{
        alert("Invalid input");
    }        
}

function findSex() {
    var sex = document.getElementsByTagName("input");
    //find radio selection with attribute 'name'
    for (i = 0; i < sex.length; i++) {
        var sexOp = sex[i].hasAttribute("name");
        if (sexOp == true) {
            //once found save value of checked radio option
            if (sex[i].checked)
                var sexSel = sex[i].value;

        }
    }
    return sexSel;
}

function findList() {
    var act = document.getElementsByClassName("activity");
    var actList = [];
    //store all checked checkboxes into array 'actList'
    for (i = 0; i < act.length; i++) {
        if (act[i].checked) {
            var actOp = act[i].value;
            actList.push(actOp);
        }
    }
    return actList;
}

// function makeList(actList){
//     var unList = document.createElement("UL");
//     unList.setAttribute("id", "newUL");
//     document.body.appendChild(unList);

//     for(i=0;i<actList.length;i++){
//         var listData = document.createElement("LI");
//         var data = document.createTextNode(actList[i]);
//         listData.appendChild(data);
//         document.getElementById("newUL").appendChild(listData);
//     }
// }


//Problem5
function getDetails() {
    document.getElementsByTagName("details")[0].addEventListener("mouseenter", mouseEnter);
    document.getElementsByTagName("details")[0].addEventListener("mouseleave", mouseLeave);

    //function sets 'open' attribute in 'details' element when mouse enters range
    function mouseEnter() {
        document.getElementsByTagName("details")[0].setAttribute("open", true);
    }

    //function removes 'open' attribute in 'details' element when mouse leaves range
    function mouseLeave() {
        document.getElementsByTagName("details")[0].removeAttribute("open");
    }
}


//Problem6
function hiddenMsg() {
    var msg = document.getElementsByTagName("span"); ""
    var hiddenOutput = "";
    //find all 'span' elements and append their text content to a variable
    for (i = 0; i < msg.length; i++) {
        hiddenOutput = hiddenOutput + msg[i].textContent;
    }
    console.log(hiddenOutput);
}


//Problem7
document.getElementById("earth_time_check").addEventListener("click", earthTime);

function earthTime() {
    var dispLoc = document.getElementById("earth_time");
    var currTime = new Date();
    dispLoc.innerHTML = currTime.toLocaleTimeString();//format to show current time
}


//Problem8
document.getElementsByTagName("h1")[0].addEventListener("click", waitFunc);

//wait 3 seconds before calling 'changeBkGrd function
function waitFunc() {
    setTimeout(changeBkGrd, 3000)
}

//randomly generate a number and change background color based off of the number
function changeBkGrd() {
    var x = Math.floor((Math.random() * 10) + 1);
    switch (x) {
        case 1:
            document.body.style.backgroundColor = "#AB4487";
            break;
        case 2:
            document.body.style.backgroundColor = "#6288AB";
            break;
        case 3:
            document.body.style.backgroundColor = "#6CAB5D";
            break;
        case 4:
            document.body.style.backgroundColor = "#ABA758";
            break;
        case 5:
            document.body.style.backgroundColor = "#4FAB52";
            break;
        case 6:
            document.body.style.backgroundColor = "#6946AB";
            break;
        case 7:
            document.body.style.backgroundColor = "#AB6D5F";
            break;
        case 8:
            document.body.style.backgroundColor = "#58ABA6";
            break;
        case 9:
            document.body.style.backgroundColor = "#A6AB09";
            break;
        case 10:
            document.body.style.backgroundColor = "#00ABAB";
            break;
    }
}


//Problem9
//create space below calculator to display operation
var opLine = document.createElement("h4");
opLine.setAttribute("align", "center");
document.body.appendChild(opLine);
var opnd1 = 0;
var opnd2 = 0;

document.getElementById("n1").addEventListener("input", val1Disp);
document.getElementById("n2").addEventListener("input", val2Disp);
document.getElementById("operation").onchange = calc;

//read value of first operand and send to 'calc' function
function val1Disp() {
    opnd1 = document.getElementById("n1").value;
    var validNum = isNaN(opnd1);
    if(!validNum)
        calc();
}

//read value of second operand and send to 'calc' function
function val2Disp() {
    opnd2 = document.getElementById("n2").value;
    var validNum = isNaN(opnd2);
    if(!validNum)
        calc();
}

function calc() {
    var op = document.getElementById("operation").value;
    switch(op){
        case "Add":
            var output = Number(opnd1) + Number(opnd2);
        break;
        case "Subtract":
            var output = Number(opnd1) - Number(opnd2);
        break;
        case "Divide":
            var output = Number(opnd1) / Number(opnd2);
        break;
        case "Multiply":
            var output = Number(opnd1) * Number(opnd2);
        break;
    }
    opLine.textContent = output.toString();
}


//Problem10
function walkTheDom(node, func){
    func(node);
    node = node.firstChild;
    while(node){
        walkTheDom(node, func);
        node.nextSibling;
    }
}

function func(node){
    console.log(node);
}