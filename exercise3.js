


//PROBLEM 1 ///////////////////////////////////////////////////////////////////

document.getElementById("google").href = "https://www.google.com/";
document.getElementById("twitter").href = "https://twitter.com/";
document.getElementById("slack").href = "https://slack.com/signin";
document.getElementById("javadocs").href = "https://www.oracle.com/technetwork/java/javase/documentation/javadoc-137458.html";

//PROBLEM 2 ////////////////////////////////////////////////////////////////////

// options = document.select.children;
// for (i = 0; i < options.length; i++) {
//     if (i==2) {
//         options[i].remove();
//   }
// }

// var pluto = document.getElementsById("planet").lastChild.innerHTML;
// pluto.remove();

// function remove_planet() {
// var planets = document.getElementsById("planet");
// planets.removeChild(select.lastChild);
// }

// function remove_last_planet () {
// var planets = document.getElementsById("planet");
//     if (planets.length > 0) {
//         planets.remove(planets.length-1);
//     }
// }

const noPlanet = document.getElementById("planet");
noPlanet.remove(2);


//PROBLEM 3 /////////////////////////////////////////////////////////////

// function alienText() {
// var alien_text = document.getElementsByTagName("p").hidden = true;
// var earth = document.getElementById("control-form");
//     if (all_select) {
//         console.log(alienText)
//     }
// }

function alienText() {
    var earth = document.getElementById("planet")[0];
    var message = document.getElementsByTagName("p")[5];
    if (earth.selected) {
      message.hidden = true;
    } 
    else {
      message.hidden = false;
    }
  }


  //PROBLEM 4 //////////////////////////////////////////////////////
// funtion addRow() {
//     var table = document.getElementsByClassName("table table-striped table-bordered table-hover table-sm");
//     var row = table.insertRow(0);
//     var cell = table.insertCell(0);
//     cell.innerHTML = //usersinput// ;
// }

// function addRow() {
//     //creates table row
//     var table = document.getElementsByClassName("table");
//     var tr = document.createElement("tr");
//     tr.id = "myTr";
// //creates table cell
//     var td = document.createElement("td");
//     var cell = document.createTextNode("cell element");
//     td.appendChild(cell);
// //add cell to row
//     tr.appendChild(td);
// //addrow to table
//     myElement.appendChild(tr);
// }

function addRow(name, email, phone, bday, gender, color, activity){
      var table = document.getElementsByClassName("table")[0];
    //   var row = table.insertRow(1);


    
      var cell0 = row.insertCell(0);
      var cell1 = row.insertCell(1);
      var cell2 = row.insertCell(2);
      var cell3 = row.insertCell(3);
      var cell4 = row.insertCell(4);
      var cell5 = row.insertCell(5);
      var cell6 = row.insertCell(6);
    
      cell0.innerHTML = name;
      cell1.innerHTML = email;
      cell2.innerHTML = phone;
      cell3.innerHTML = bday;
      cell4.innerHTML = color;
      cell5.innerHTML = gender;
      cell6.innerHTML = activity;

      //append cells to the row row.appendChild(cell)
    }


// PROBLEM 5 ////////////////////////////////////////////////////////////////////



// PROBLEM 6 ///////////////////////////////////////////////////////////////////
function subliminal_messaging() {
    var hiddenmessage = "";
    for(i=0; i<7; i++) {
    hiddenmessage += document.getElementsByTagName("span")[i].innerHTML;
    
    }
console.log(hiddenmessage);
//     var spans = document.getElementsByTagName("span");
    
//     for(i=0; i<spans; i++) {
//     hiddenmessage += spans[i].innerHTML;
//     }
    
// // console.log(spans);
// document.write("<br>"+spans[i]);

}

// //// return hiddenmessage;  

// //// }
// //// document.getElementById('spans').innerHTML = register();



// PROBLEM 7 ////////////////////////////////////////////////////////////////////
document.getElementById("earth_time_check").addEventListener("click", earthTime);
function earthTime(){

    var time = new Date();
    document.getElementById("earth_time").innerHTML = time;
}


// PROBLEM 8 /////////////////////////////////////////////////////////////////////////
document.getElementsByTagName("h1")[0].addEventListener("click", change_color);
function change_color(){
    setTimeout(function(){document.body.style.backgroundColor = ranColor();}, 3000)
    function ranColor(){
        var letters = '0123456789ABCDEF';
        var color = '#';
        for (var i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }
if (color = "#000000"){ ranColor(); }
}