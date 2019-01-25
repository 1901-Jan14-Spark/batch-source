







//0
function fizzbuzz(){
for(i=1;i<101;i++){
if(i%3==0 && i%5==0){
    console.log("FizzBuzz");
}
else if(i%3==0){
    console.log("Fizz");
}
else{
    console.log(i);
}
}
}

//1
array=["elephants", "tyranosaurusRex", "tortoise"]
function maxlength(array){
    var long=array[0];
    var index=0;
 for(i=0; i<array.length;i++){
     if (array[i].length>long.length){
     long=array[i]
     index=i}
 }
console.log("index is " + index)
return  long;
}

//2
array2=["elephants", "tyranosaurusRex", "tortoise"]
function reverseArray(array2){
    j=array2.length-1
    for(i=0 ;i<(array2.length-1)/2;i++){
        x=array2
    
    var temp=x[i];
    x[i]=x[j];
    x[j]=temp;
    j--;
    }
 
 console.log(x);
 }

//3
function vowelCount (string){
    let counter = 0;
    for(let i = 0; i< string.length; i++) {
    let newStr = string[i].toLowerCase()
    if (newStr == "a" || newStr == "e" || newStr == "i" || newStr == "o" || newStr == "u") {
    counter += 1;
    
    }
    
    }
    return counter;
    }
 
//4
var string2="aScripta"
function removeScript(string2){
if(string2.includes("Script")){
   var newstring = string2.replace("Script", "");
    return newstring;


}
else{
    return string2;
}
}
//5
var Date=new Date(1700)
function isLeapYear(Date){
if (Date%4==0){
    if(Date%100==0)  {
        if(Date%400!=0){
       return false}
        
else {return true;}
}
   else{return true;} 
}
else {return false;}
}
//6
var string3=("aaronc1@tamu.edu");
function isValidEmail(string3){
    var n = string3.search("@");
    var m=string3.search(".com");
    var o=string3.search(".");
if(string3.includes("@")==false){
    console.log("Invalid email")
}
else if(n==0 || n==string3.length-1){
    console.log("Invalid email")
}
else if(string3.includes(".com")==false){
    console.log("Invalid email")
}
else if(m<n ||  o==n+1){
    console.log("Invalid email")
}

else{console.log("Thank you")}
//return n;
}
//7
function removeChar(string, index){
    var a=index;
    var b=string[a];
    var c =string.replace(string[a],"");
    return c;
}

//8
numArray=[1, 2, 3]
function bubbleSort(numArray){
   var change;
   var size=numArray.length-1;
   var x=numArray;
  do {
      change=false;
   for(i=0;i<size;i++){
if (x[i]>x[i+1])
{
    var temp=x[i];
    x[i]=x[i+1];
    x[i+1]=temp;
    change=true
}

   }
   size--;
  }while (change)
  return x;
 }

 //10
 var someStr="racecar"
function isPalindrome(someStr){
    var re = /[\W_]/g;
    someStr = someStr.toLowerCase().replace(re, '');
    var len = someStr.length;
    for (var i = 0; i < len/2; i++) {
      if (someStr[i] !== someStr[len - 1 - i]) {
          return false;
      }
    }
    return true;


}
//11
var shape=("square")
function printShape(shape, height, character){
switch(shape){
    case "square":
        for(i=0;i<height;i++){
            console.log(character+character+character)
    }
    

    break;

    case "triangle":
    for(i=0;i<height;i++){
        console.log(character)
        character=character+character
}
    
    
    


    break;

    case "diamond":
    var x=character;
    var shapeArr=[0];
    var j=0;
    for(i=0;i<height/2;i++){
        console.log(character);
        shapeArr[j]=character;
        character=character+x+x;
        j++;
    }
        j--;
        while(i>height/2 && i<height){
            j--;
            console.log(shapeArr[j]);
            i++;
            
        }
        


    break;
}

}

//12
array4=[1,2,3,4,5]
function rotate(array4, n){
   

  for (i=0;i<=array4.length;i++){
     if (i<n){
      var  p=array4[i];
     var q=i;
    while(q-n<0){q=+4
    
    };

     }
      array4[i-n]=array4[i];
      
        
      
  }
  array4[q]=p;
  console.log(  p)  ;
 return array4;
 }

//13
function balanced(string){
    if (string.length <= 1)
    return false

  var matchingOpeningBracket
  var x
  var stack = []

  let openingBrackets = ['[', '{', '(']
  let closingBrackets = [']', '}', ')']

  for ( i = 0; i < string.length; i++) {
    x = string[i]

    if (closingBrackets.indexOf(x) > -1) {
      matchingOpeningBracket = openingBrackets[closingBrackets.indexOf(x)]
      if (stack.length == 0 || (stack.pop() != matchingOpeningBracket)) {
        return false
      }
    } else {
      stack.push(x)
    }
  }

  return (stack.length == 0)
  }


