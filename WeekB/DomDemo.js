console.log("js success!")

let catPic = document.getElementById("catImage");
catPic.src = "https://cdn.images.express.co.uk/img/dynamic/128/590x/lynx-909438.jpg";

let capts = document.getElementsByTagName("figcaption");
capts[0].innerHTML = "no longer a small cat";

// let newNode = document.createElement("h3");
// newNode.innerHTML = "I just made this new node!";

// let bodyNode = document.getElementsByTagName("body")[0];
// bodyNode.appendChild(newNode);

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

catPic.addEventListener("mouseover", changePic);
// [nav element].addEventListener("mouseover", navFunction);

function changePic(event){
    console.log(event);
    // console.log(event.clientX+", "+event.clientY);
    if(event.target.src === "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cat-quotes-1543599392.jpg?crop=1.00xw:0.759xh;0,0&resize=480:*"){
        catPic.src = "https://cdn.images.express.co.uk/img/dynamic/128/590x/lynx-909438.jpg"
        capts[0].innerHTML = "no longer a small cat"
    } else{
        catPic.src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cat-quotes-1543599392.jpg?crop=1.00xw:0.759xh;0,0&resize=480:*"; 
        capts[0].innerHTML = "Our small cat"
    }
}

catPic.addEventListener("mouseover", displayText);
catPic.addEventListener("mouseleave", removeText);

function displayText(){
    let newNode = document.createElement("h3");
    newNode.innerHTML = "You hovered over the cat";
    newNode.id = "hoverText"
    
    let bodyNode = document.getElementsByTagName("body")[0];
    bodyNode.appendChild(newNode);
}

function removeText(){
    let variableText = document.getElementById("hoverText");
    variableText.remove();
}
