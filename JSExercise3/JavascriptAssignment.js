
    
        window.onload =function() {
        // document.getElementsById("form-sub")[0].addEventListener("click", AddData);
        document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
        document.getElementsByTagName("details")[0].addEventListener("mouseout", openDetails);
        document.getElementById("earth_time_check").addEventListener("click", startTime);
        document.getElementsByTagName("h1")[0].addEventListener("click", random_bg_color);

         }

//question #1
$("#google").click(function() {
    window.location= "http://google.com";
});

$("#twitter").click(function() {
    window.location= "https://twitter.com/";
});

$("#slack").click(function() {
    window.location= "https://slack.com/";
});

$("#javadocs").click(function() {
    window.location= "https://javadocs.com/";
});

//question #2
 $('#planet').children().each(function(index, element) {
    if ($(element).text() == "Pluto") {
      $(this).prop('disabled', true);
    }
  });

  //question #3
/* Define a function alienText() which shows the hidden element displaying an alien message. 
 When any planet other than Earth is selected, execute this function.*/
function alienText() {
    var x = alienText("planet");
    document.getElementById("planet").style.display = "none"; 
  }

//question #4
function AddData() {
    var x = document.getElementsById("firstname").value;
    var y = document.getElementsById("lastname").value;
    var x = document.getElementsById("email").value;
    var y = document.getElementsById("phone").value;
    var x = document.getElementsById("bday").value;
    var y = document.getElementsByTagName("Gender").value;
    var y = document.getElementsById("color").value;
    var y = document.getElementsByClassName("activity").value;

    var letters = '/^[a-zA-Z]+$/';
    if ((parseInt(x) != (x)) && (y == parseInt(y))) {
        alert("Wrong Value Entered");
    } else {
        var rows = $('#tr');
        var name = "sadcsad";
        var gender = $('input[name="gender"]').val();
        
        rows += "<tr><td>" + name + "</td><td>" + gender + "</td><td>" + age + "</td><td>" + city + "</td></tr>";
        // $(rows).appendTo("#list tbody");
    }
}

//question #5
// Create a function openDetails() which opens the details element. 
// Invoke this function when the details’ summary is moused over. 
// The details should be hidden when the mouse is removed from the summary.

var i;

var detailsElem = document.getElementsByTagName('details')[0],
summaryElem = document.getElementsByTagName('summary'),
summElemLen = summaryElem.length;   
detlElemLen = detailsElem.length; 
 
function openDetails() {
    console.log()

    if (detailsElem.open === true){
      detailsElem.open = false;
    }
    else {
        detailsElem.open = true;
    }
}

//question #6
/* Create a function that concatenates the inner HTML of all of the 
span elements and prints the results to the console.*/

function concatenates()
{
var spans = document.getElementsByTagName("span");
var x = "";
 for(var i=0; i<spans.length; i++) { 
  x+=spans[i].innerHTML;
 }
 console.log(x);

}
//question #7
/* Create a function that displays the current time on earth in the span with id “earth_time”. 
Invoke this function when “Earth time” button is clicked.*/ 

  
  function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    document.getElementById("earth_time_check").innerHTML = h + ":" + m + ":" + s;
    t = setTimeout(function() {
      startTime()
    }, 500);
  }


//question #8
  /*Three seconds after a user clicks on the “Intergalactic Directory” heading, 
  the background color should change to a random color. Make sure this color is never black so we can 
  still read our black text! (there are other dark colors it could change to where we 
  also couldn’t see the text but 
    it’s enough to just accomodate for a black background.*/

    var document = document.getElementsByTagName("h1");
    
         var x=" "; 
        function random_bg_color() {
            var x = Math.floor(Math.random() * 256);
            var y = Math.floor(Math.random() * 256);
            var z = Math.floor(Math.random() * 256);
            var bgColor = "rgb(" + x + "," + y + "," + z + ")";
         console.log(bgColor);
            document.body.style.background = bgColor;
            } 
        random_bg_color(x); 
//question #9
/*When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. 
Display the result in the element with id result.*/

//question #10
/*Define function walkTheDom(node, func)
This function should traverse every node in the DOM. 
Use recursion. On each node, call func(node).*/
function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild; 
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}
walkTheDOM(document.body, function (node) {
    if (node.nodeType === 3) { 
        var text = node.data.trim(); 
        if (text.length > 0) { 
        }
    }
});
 


