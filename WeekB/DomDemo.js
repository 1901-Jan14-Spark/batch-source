console.log("js success!")

document.getElementById("catImage").src = "https://cdn.images.express.co.uk/img/dynamic/128/590x/lynx-909438.jpg";

let capts = document.getElementsByTagName("figcaption");
capts[0].innerHTML = "no longer a small cat";

let newNode = document.createElement("h3");
newNode.innerHTML = "I just made this new node!";

let bodyNode = document.getElementsByTagName("body")[0];
bodyNode.appendChild(newNode);

let navNode = document.getElementById("nav");
//bodyNode.removeChild(navNode);
//navNode.innerHTML = "";

let anchors = document.getElementsByTagName("a");
for(i=anchors.length-1;i>-1;i--){
    if(anchors[i].firstChild.tagName == "BUTTON"){
        anchors[i].remove();
    }
}

document.getElementById("rev").click();


