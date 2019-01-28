//1 DONE
let googleLink = document.getElementsByName("google")[0];
googleLink.innerHTML = "Google";
googleLink.href = "https://www.google.com";
googleLink.target = "_blank";

let twitterLink = document.getElementsByName("twitter")[0];
twitterLink.innerHTML = "Twitter";
twitterLink.href = "https://www.twitter.com";
twitterLink.target = "_blank";

let slackLink = document.getElementsByName("slack")[0];
slackLink.innerHTML = "Slack";
slackLink.href = "https://www.slack.com";
slackLink.target = "_blank";

let javadocsLink = document.getElementsByName("javadocs")[0];
javadocsLink.innerHTML = "JavaDocs";
javadocsLink.href = "https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html";
javadocsLink.target = "_blank";
//2 DONE
let planets = document.getElementById("planet");
planets[2].remove();
//3 DONE
planets.addEventListener("click", alienText);
function alienText() {
    //console.log("alienText called");
    let hiddenMsg = document.getElementsByTagName("p");
    planets = document.getElementById("planet");
    for (let i = 0; i < hiddenMsg.length; ++i) {
        if (hiddenMsg[i].hidden) {
            hiddenMsg[i].setAttribute("id", "alienText");
        }
    }
    if (planets.options[planets.selectedIndex].innerHTML == "Earth") {
        //console.log("Earth selected");
        document.getElementById("alienText").hidden = true;
    }
    else {
        //console.log("Earth not selected");
        document.getElementById("alienText").hidden = false;
    }
}
//4
document.getElementById("form-sub").addEventListener("click", addForm);
function addForm() {
    let firstName = document.getElementById("firstname").value;
    let lastName = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let birthday = document.getElementById("bday").value;
    let planet = document.getElementById("planet")[document.getElementById("planet").selectedIndex].innerHTML;
    let radios = document.getElementsByName("gender");
    let gender = "";
    for (let i = 0; i < radios.length; ++i) {
        if (radios[i].checked)
            gender = radios[i].value;
    }
    let color = document.getElementById("color").value.toUpperCase();
    let actUL = document.createElement("ul");
    let acts = document.getElementsByClassName("activity");
    for (let i = 0; i < acts.length; ++i) {
        if (acts[i].checked) {
            let actLI = document.createElement("li");
            let textNode = document.createTextNode(acts[i].value);
            //console.log(textNode);
            actLI.appendChild(textNode);
            actUL.appendChild(actLI);
        }
    }
    //console.log(actUL.innerText);

    //Check for correct data format
    //Get table
    //Go into tbody child
    //Create row with scope="row"
    //Create table data using the information
    //Append table data to row as child
    //Append row to table as child
}
//5 DONE
let details = document.getElementsByTagName("details");
details[0].addEventListener("mouseover", openDetails);
details[0].addEventListener("mouseout", openDetails);
details[0].setAttribute("id", "details");
function openDetails() {
    let detail = document.getElementById("details");
    if (!detail.open)
        detail.open = true;
    else
        detail.open = false;
}
//6 DONE
function printSpans() {
    let spans = document.getElementsByTagName("span");
    let str = "Linked spans: ";
    for (let i = 0; i < spans.length; ++i) {
        str += spans[i].innerHTML;
    }
    console.log(str);
}
printSpans();
//7 DONE
document.getElementById("earth_time_check").addEventListener("click", showEarthTime);
function showEarthTime() {
    let hour, minute, second;
    let date = new Date();
    hour = date.getHours();
    minute = date.getMinutes();
    second = date.getSeconds();
    document.getElementById("earth_time").innerHTML = String(`${hour}:${minute}:${second}`);
}
//8 DONE
document.getElementsByTagName("h1")[0].addEventListener("click", changeBackground);
function changeBackground() {
    let rand = "#";
    for (let i = 0; i < 6; ++i) {
        rand += Math.floor(Math.random() * 16).toString(16).toUpperCase();
    }
    //console.log(rand);
    if (rand == "#000000")
        changeBackground();
    setTimeout(function () { document.body.style.backgroundColor = rand }, 3000);
}
//9 DONE
document.getElementById("operation").addEventListener("click", doMath);
function doMath() {
    let n1 = Number(document.getElementById("n1").value);
    let n2 = Number(document.getElementById("n2").value);

    if (!isNaN(n1) && !isNaN(n2)) {
        let operation = document.getElementById("operation");
        switch (operation.options[operation.selectedIndex].innerHTML) {
            case "Add":
                {
                    document.getElementById("result").innerHTML = `${n1} + ${n2} = ${n1 + n2}`;
                }
                break;
            case "Subtract":
                {
                    document.getElementById("result").innerHTML = `${n1} - ${n2} = ${n1 - n2}`;
                }
                break;
            case "Multiply":
                {
                    document.getElementById("result").innerHTML = `${n1} * ${n2} = ${n1 * n2}`;
                }
                break;
            case "Divide":
                {
                    document.getElementById("result").innerHTML = `${n1} / ${n2} = ${n1 / n2}`;
                }
                break;
        }
    }
    else {
        document.getElementById("result").innerHTML = "Invalid Inputs";
    }
}
//10 DONE
function walkTheDome(node, func)
{
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDome(node, func);
        node = node.nextSibling;
    }
}