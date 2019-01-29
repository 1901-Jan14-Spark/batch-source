// This is the file used to edit the HTML file named "index.html"





//      Selectors   getElementBy
let g = (document.getElementsByTagName("a"));
let garray = ["https://www.google.com/","https://twitter.com/","https://slack.com/","https://javadocs.com/" ]
for(i=0;i<garray.length;i++){
    g[i].setAttribute("href",garray[i]);

}
let planets = (document.getElementById("planet"));
planets[2].remove();
let p1 = document.getElementsByTagName("p"); // declaring all paragraphs as p1
let p2 = p1[5]; // hidden paragraph
let earth = planets[0]; 




alienText();{
    if(earth === "selected");
   return p1[5].hidden.valueOf('true');
  
   }
   if(earth !== "selected");

   return p1[5].hidden.valueOf('false');


    

    



// function alienText("change", hiddenreveal){
    





// console.log(p)
// function alienText(){
// p.addEventListener(onclick, document.get)
// }
// 
