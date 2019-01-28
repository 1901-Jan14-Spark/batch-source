// Make each link direct the user to its respective website
let links = document.getElementsByTagName('a');
 links[0].href="https://www.google.com/";
 links[1].href="https://twitter.com/";
 links[2].href="https://slack.com/";
 links[3].href="https://docs.oracle.com/javase/8/docs/api/";

// Disable the Pluto Planet of Residency option.
document.getElementById("planet").options[2].disabled = true;

//Define a function alienText() which shows the hidden element displaying an alien message. 
//When any planet other than Earth is selected, execute this function.

    var show =document.getElementsByTagName("p");

    function alienText(){
    if(document.getElementById("planet").selectedIndex === 1 ) {
        show[5].hidden = true;
    }
    else show[5].hidden = false;
}
document.getElementById("planet").addEventListener("click", alienText());

// 4. When the submit button is pressed, get the values from all of the input into a new row in the table below.
//     Make sure no input is empty, check that first and last name are at least two letters each. Validate for 
//valid phone number and email structure. This should continue to work for multiple entries and rows.





// 5. Create a function openDetails() which opens the details element. Invoke this function when the details’ 
//summary is moused over.
//     The details should be hidden when the mouse is removed from the summary.


document.getElementsByTagName("details")[0].setAttribute("onmouseover", "openDetails()");
function openDetails(){document.getElementsByTagName("details")[0].open = 1;}

document.getElementsByTagName("details")[0].setAttribute("onmouseout", "hideDetails()");
function hideDetails(){document.getElementsByTagName("details")[0].open = 0;}



// 6. Create a function that concatenates the inner HTML of all of the span elements and prints the results
// to the console.


function concatenate(){
    let spans = document.getElementsByTagName("span");
    let span = "";
    for(i = 0; i < spans.length; i++){
        span += spans[i].innerHTML;
    }
    console.log(span);
}

console.log(concatenate());


// 7. Create a function that displays the current time on earth in the span with id “earth_time”. 
//Invoke this function when “Earth time” button is clicked.

document.getElementById("earth_time_check").setAttribute("onclick", "earthCurrentTime()");
function earthCurrentTime(){
    document.getElementById("earth_time").innerHTML = Date();
    document.getElementById("earth_time").hidden = false;
}

// 8. Three seconds after a user clicks on the “Intergalactic Directory” heading, 
// the background color should change to a random color.
// Make sure this color is never black so we can still read our black text!
// (there are other dark colors it could change to where we also couldn’t
// see the text but it’s enough to just accomodate for a black background)


document.getElementsByTagName("h1")[0].setAttribute("onclick", "colorChange()");

function colorChange(){
    setTimeout(function(){
          document.body.style.backgroundColor = changeColor();
        }, 3000); }

function changeColor() {
    var letters = '0123456789ABCDEF';
    var randomColor = '#';
    for (var i = 0; i < 6; i++) {
        randomColor += letters[Math.floor(Math.random() * 16)];
    }
    if(color == "#000000"){
        changeColor();
    }
    else{
        return randomColor;
    }
  }


  // 9. When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select.
  // Display the result in the element with id result.

  function calculate(){
    var total = 0;
    var n1 = Number(document.getElementById("n1").value);
    var n2 = Number(document.getElementById("n2").value);
    var operation = document.getElementById("operation");

    for(i = 0; i < operation.length; i++){
      if(operation[i].innerHTML == "Add"){
        if(operation[i].selected){
          total = n1 + n2;
        }
      } else if(operation[i].innerHTML == "Subtract"){
        if(operation[i].selected){
          total = n1 - n2;
        }
      } else if(operation[i].innerHTML == "Divide"){
        if(operation[i].selected){
          total = n1 / n2;
        }
      } else if(operation[i].innerHTML == "Multiply"){
        if(operation[i].selected){
          total = n1 * n2;
        }
      }
    }
    document.getElementById("result").innerHTML = total;
  }

  
//   10. Define function walkTheDom(node, func)
//     - This function should traverse every node in the DOM.
//     - Use recursion. On each node, call func(node).

function walkTheDom(node, func){
    var all = document.getElementsByTagName(node);
    for(i = 0; i < all.length - 1; i++)
    {
      func(all[i]);
    }
  }