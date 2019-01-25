//FizzBuzz

var x;
for(x = 1; x<= 100;x++ ){
    // if (x%5 !== 0 || x%3 !== 0){
        // console.log(x)
        if (x%5==0&&x%3==0){
            console.log("FizzBuzz")
    }else if (x%3==0){
console.log("Fizz");
}else if (x%5==0){
    console.log("Buzz");
}
else {
        console.log(x)
    }
}


//Longest String


var longest= '';
function maxLenght(array){
for (i = 0; i<array.Lenght; i++){
    if (array[i].Lenght >longest.Lenght){
        longest = array[i].Lenght;            
    }
}
console.log(longest);
return longest;
}
//

var aar = ["jajbas","jasojbf","jasobdfojabf"]
var longest = aar.reduce(function(a,b) {
    return a.length > b.length ? a : b 
}, '');
console.log(longest);






// reverse Array
var myArr = [0,2,2,3,3];
function reverseArray(array){
    // var array = [0]
  for(i=array.length; i>-1; i--){
      var next = array[i];
      console.log(next);
  }
  //return next;
}
// console.log(reverseArray[1, 2, 3]);

//count Vowels
function vowelCount(string)
{
    var Vowels='aeiouAEIOU';
    var vcountt= 0;

    for(var x = 0; x < string.length; x++)
    {
        if (Vowels.indexOf(string[x]) !== -1)
    {
     vcountt+=1;
    }
    }
return vcountt;
}
console.log(vowelCount("stressoo"));

//Remove Script
function removeScript(string){
    var ret = string.replace('script','');
    return ret;
    }
console.log(removeScript("data script"));

//Find Leap year
function isLeapYear(date){
    if(date % 4==0&&(date%100!==0||x%400==0)){
        console.log("Leap Year");
    }
else{
    console.log("Not");
}
}
//Email Validation
function isValidEmail(string){
    var first= false;
    var second = false;
    var third = false;
    var fourth = false;
    var fith = false;

    for( i = 0; i<string.length; i++){
        var res = string.split("");
        print = res[i];
        // console.log(print);
        if(print === "m"){
            // console.log("first")
            first = true;
            //  return first;   
        }
        else if(print === "o"){
            second = true;
            //  return second;
        }
        else if(print === "c") {
            third = true;
            // return third;   
        }
        else if(print === "."){
            fourth = true;
            // return fourth; 
         }               
        else if(print === "@"){
            fith = true;
            // return fith;
        }
    }if(first&&second&&third&&fourth&&fith){
        console.log("Valid Email")
    }else{
        console.log("not valid")
    }
}

///Remove Charector
function removeChar(string, index){
    string = string.slice(0,index) +string.slice(index+1);
    console.log(string);
}
//Bubble Sort
var numArray = [545,4581,54884,21,54];
function bubbleSort(numArray){
    var swapped;
    do {
        swapped = false;
        for(var i=0; i< numArray.length-1; i++){
            if (numArray[i]> numArray[i+1]){
                var temp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = temp;
                swapped = true;
            }
        }
    }while (swapped);
}
bubbleSort(numArray);
console.log(numArray);

//Palindrome
function isPalindrome(someStr){
    var reverseStr = someStr.split('').reverse().join('');
    return reverseStr===someStr;
}

///Shapes
// var shape = "";
// var height= 0;
// var character = "";
function printShape(shape, height, character){
    var row = "";
    switch(shape){
        case "square":
        // for (var i = 0; i <height; i++){
        //     document.write(character);
        //     for(var j=0; j <height; j++){
        //         document.write(character);
        //     }
        //     document.write('</br>');
        // }
        // document.write('<br />');
        // case shape.toLowerCase("Square"):
        for (var i = 0; i < height; i++){
            document.write(character);
            for(var j = 0; j < height; j++){
                document.write(character);
            }
            document.write('</br>');
        }

        case "triangle":
        for(var i=0; i <=height; i++){
            row+=character;
            document.write(row);
        }
        case "diamond":
        for(i = 1; i < height - 1; i++){
            var space = "";
            for(j= 0; j <height/2 +1-i; j++){
                space+= " ";
            }
            row += character.repeat(i);
            console.log(space+row);
        }
        for(i = height; i > height/2 +1; i--){
            sapce= "";
            for(j = -1; j < height - i; j++){
                space +=" ";
            }
        
            row = row.slice(0, -3);
            if (row<= 1){
                row = character;
            }
            console.log(space+row);
            
        }
        break;
        }
    }
var array = [];
    //Rotate Left
   function rotate(array, n) {
       var len = n % array.length;
       var temp = new Array(len);
       for(i = 0; i <len; i ++){
           temp[i] = array[i];
       }
       array.splice(0,len);
       return array.concat(temp);
   }   
   
// balanced Brackets
function balanced(string){
    var Brackets= "() [] {}";
    var stack = [];
    for (i= 0; i < string.length; i ++){
        if(string[i] == Brackets[0] || string[i] == Brackets[2] || string[i]
            == Brackets[4]) {
                stack.push(string[i]);
            }
            if(string[i]==Brackets[1] || string[i] == Brackets[3] || string[i]
                == Brackets[5]){
                   if(!match(stack.pop(), string[i])){
                       return false;
                   }
                }
            }
            return true;
    }
    function match(str1, str2){
        if(str1=="(" && str2 ==")"){
            return true;
        }else if(str1 == "{"&& str2 =="}"){
            return true;
        }else if(str2 == "[" && str2 =="]"){
            return true;
        }else{
            return false;
        }
    }
