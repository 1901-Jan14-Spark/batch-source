//1
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
//2
let planets = document.getElementById("planet");
planets[2].remove();
//3
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

//5
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
//6
function printSpans() {
    let spans = document.getElementsByTagName("span");
    let str = "Linked spans: ";
    for (let i = 0; i < spans.length; ++i) {
        str += spans[i].innerHTML;
    }
    console.log(str);
}
printSpans();
//7
document.getElementById("earth_time_check").addEventListener("click", showEarthTime);
function showEarthTime() {
    let hour, minute, second;
    let date = new Date();
    hour = date.getHours();
    minute = date.getMinutes();
    second = date.getSeconds();
    document.getElementById("earth_time").innerHTML = String(`${hour}:${minute}:${second}`);
}
//8

//9
function doMath() {
    
}
//10