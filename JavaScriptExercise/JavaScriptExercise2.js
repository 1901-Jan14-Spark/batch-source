// // 0
function printNumbers(){
    for(i=1; i<101; i++){
 if(i%3==0 && i%5==0)
    console.log("FizzBuzz");
else if(i%3==0)
    console.log("Fizz");
else if(i%5==0)
    console.log("Buzz");
else
console.log(i);
    }
}
// 1
var quack=[5, "dog", 17, "cat", "lizard Dragons", 64];
function maxLenght(quack){
    var a = quack.length;
    var indexLength=0;
    var maxString=0;
    var indexMax=0;
    var currentString="";
    for (var i=0; i < a; i++){
    currentString=quack[i];
    indexLength=currentString.length;
    
    if (maxString<indexLength){
        (maxString=indexLength);
        (indexMax = i);
    }
        else{
            continue;
        }
    }
    console.log(indexMax);

}  
    
// // 2
var arr= [5, "dog", 17, "cat", "lizard", 64];
function reverseArray(arr){
let reverseArr= arr.reverse();
console.log(reverseArr);
}

// //3
function vowelsNumber(array){
var vowel=["a","e","i","o","u"];
var amount=0;
for (var i=0; i < array.length; i++){
if(array[i]== "a"){
    (amount++);

}
if(array[i]== "e"){
    (amount++);

}
if(array[i]== "i"){
    (amount++);

}
if(array[i]== "o"){
    (amount++);

}
if(array[i]== "u"){
    (amount++);
}
    
}
return amount;

}

// // // 4  
function scriptRemoval(string){
var newString= string.replace(/Script/gi,"");
return newString;
}

// // 5
function leapYear(year){
    if((year%4==0)&&(year%100!==0)||(year%400==0))

    return "Year IS a Leap Year!";

else
    return "NOT a Leap Year!"

}

// 6
function validEmail(email){
var test=(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/);
return test.test(email);
}

// 7
function dissectChar(string,char){
    
    var cut=string.slice(0,char)+string.slice(char+1,string.length);
    return cut;
}

// 8
function bubbleSort(numArray){
    var size = numArray.length;
    var swapped;
    do {
        swapped = false;
        for (var i = 0; i < size; i++) {
            if (numArray[i] > numArray[i + 1]) {
                var temp = numArray[i];
                numArray[i] = numArray[i + 1];
                numArray[i + 1] = temp;
                swapped = true;
            }
        }
    } while (swapped);
    return numArray;
}

// // 9
function isPalindrome(string){
if (string == string.split('').reverse().join('')) {
   return true;
}
else {
    return false;
}
}

// 10//Seperated Diamond not working fully
function square(){
var rows=5;
var colu=5;
for(var i=0; i<=rows; i++){
    for(var j=0; j<=colu; j++){
        document.write(" ","%"," ")
      
    }  document.write("<br/>")
}
}

function triangle(){
var rows=5;
for(var i=0; i<=rows; i++){
    for(var j=0; j<=i; j++){
        document.write(" ","$"," ")
      
    }  document.write("<br/>")
}
}

function diamond(){
    var rows=5;
    for(var i=0; i<=rows; i++){
        for(var k=0; k<=rows-i;k++){
            document.write("&nbsp;");
        }
            for(var j=0; j<=i; j++){
                document.write(" ","*"," ")
          
        }  document.write("<br/>")

    }
    }

// 11
function rotateString(){

}


// 12// Not Working
function balanced(string){
    var a =string.length
    if(a%2==0){
    var left=string.slice(0,a/2);
    var right=string.slice(a/2, a);
    for(var i=0; i<right.length; i++){
        if(right[i]== "(" && (left[(a/2)-1-i]==(")")) || (right[i]== "{" && (left[(a/2)-1-i]==("}")) ||
        (right[i]== "{" && (left[(a/2)-1-i]==("}")))));
   
    }
    
return true;
    }else{
    return false;
}
}
