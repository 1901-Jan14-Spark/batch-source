// Problem 0
console.log("0: FizzBuzz");
function FizzBuzz(){
    for(i=1;i<100;i++){
        if(((i%3)== 0) && ((i%5)==0)){
            console.log("FizzBuzz");
        } else if ((i%3)== 0){
            console.log("Fizz");
        } else if ((i%5)== 0){
            console.log("Buzz");
        } else {
            console.log(i);
        }
    }
}

// Problem 1
console.log("1: Longest String");
var words = ["Hellooo", "Goofdgsfgsfddsgfdsdbye", "Miscommunication", "Done", "Hi","Discombobulatedddd"];
function maxLength(array){
    console.log(array);
    var x = array.length;
    var wordLength = 0;
    var maxLength = 0;
    var index = 0;
    var currentString = " ";
    for(var i = 0; i < x; i++){
        currentString = array[i];
        wordLength = currentString.length;
        if(maxLength < wordLength){
            maxLength = wordLength;
            index = i;
        } else {

            continue;
        } 
    } console.log("The " + index + " word is the longest word.");
}


// Problem 2
console.log("2: Reverse Array");
var randomArray = [2, "Yellow", true, "Blue", 78];4
function reverseArray(array){
    console.log(array);
    for(var i = array.length; i > -1; i--){
        console.log(array[i]);
    }
}

// Problem 3
console.log("3: Count Vowels");
var vowels = ["a", "e", "i", "o", "u"];
function vowelCount(string){
    var numOfVowels = 0;
    console.log("Vowels: " + vowels);
    console.log("Your Word: " + string);
    for(var i = 0; i < string.length -1; i++){
        if((string.includes(vowels[i]) == true)){
            numOfVowels++;                  
        } // else {
        //     numOfVowels = 0;
        // }
    } console.log("This word contains " + numOfVowels + " vowel(s).");
}

// Problem 4
console.log("4: Remove Script");
function removeScript(string){
    if(string.includes("Script")){
        let newString = string.replace("Script", '');
        return newString;
    } else if(string.includes("script")){
        let newString = string.replace("script", '');
        return newString;
    } else {
        return string;
    }
}

// Problem 5
console.log("5: Find Leap Year");
// Year must be entered as a string*
function isLeapYear(date){
    let newDate = new Date(date);
    let year = newDate.getFullYear();
    return (year % 100 === 0) ? (year % 400 === 0) : (year % 4 === 0);
}

// Problem 6
console.log("6: Email Validation");
function isValidEmail(string){
    let domain = /^\w+@[a-zA-Z]+\.[a-zA-Z]{2,3}/;
    result = string.match(domain);
    if(result == null){
        return "Not a valid email";
    } else {
        return "Valid email";
    }

}

// Problem 7
console.log("7: Remove Character");
function removeChar(string, index){
    part1 = string.substring(0, index);
    part2 = string.substring(index + 1, string.length);
    //This method removes all the characters before and after the selected index, and returns the combination of strings.
    return (part1 + part2);
}

// Problem 8
console.log("8: Bubble Sort");
var numArray = [5, 12, 32, 3, 223, 5567, 324, 1, 7786, 678];
function bubbleSort(array){
    console.log(numArray);
    var n = array.length-1;
    var x = array;
    do {
        swapp = false;
        for (var i = 0; i < n; i++)
        {
            if (x[i] < x[i+1])
            {
               var temp = x[i];
               x[i] = x[i+1];
               x[i+1] = temp;
               swapp = true;
            }
        }
        n--;
    } while (swapp);
return x; 
}

// Problem 9
console.log("9: Palindrome");
function isPalindrome(someStr){
    var re = /[^A-Za-z0-9]/g;
    someStr = someStr.toLowerCase().replace(re, '');
    var len = someStr.length;
    for (var i = 0; i < len/2; i++) {
      if (someStr[i] !== someStr[len - 1 - i]) {
          return console.log(someStr + " is not a palindrome.");
      }
    }
    return console.log(someStr + " is a palindrome.");
}

// Problem 10
// Got help from Jay but could not figure out how to allow for both uppercase and lowercase values to be accepted.  Similarly, the diamond positioning is not correct.
console.log("10: Shapes");
function printShape(shape, height, character){
    var row = " ";
    switch(shape){
        // Squares
        case  "Square":
        document.write('</br>');
        for (var i = 0; i < height; i++){
            document.write(character);
            for(var j = 0; j < height; j++){
                document.write(character);
            }
            document.write('</br>');
        }
        break;
        // case "square":
        // for (var c = 0; c < height; c++){
        //     document.write(character);
        //     for(var d = 0; d < height; d++){
        //         document.write(character);
        //     }
        //     document.write('</br>');
        // }
        // break;

        // Triangles
        case "Triangle":
            document.write('</br>');
            for(var e = 0; e < height; e++){
                row += character;
                document.write('</br>');
                document.write(row);                
            } 
            break;    
        // case "triangle":
        //     for(var f = 0; f < height; f++){
        //         row += character;
        //         document.write('</br>');
        //         document.write(row);                
        //     } 
        //     break;

        case "Diamond":
            for(i = 1; i < height - 1; i++){
                var space = "";
                for(j = 0; j < (height/2) + 1- i; j++){
                    space += " ";
                }
                document.write("</br>");
                row += character.repeat(i);
                document.write(space + row);
            }
            for(i = height; i > (height/2) + 1; i--){
                space = " ";
                for(j = -1; j < height-i; j++){
                    space += " ";
                }
            row = row.slice(0, -3);
            if(row <= 1){
                row = character;
            }
            document.write("</br>");
            document.write(space + row);
        }
        break;
    }       
}

// Problem 11 (With help for Daniel)
console.log("11: Rotate Left");
function rotate(array, n){
    console.log(array);
    var len = n % array.length;
    var temp = new Array(len);
    for(i = 0; i < len; i++){
        temp[i] = array[i];
    }
    array.splice(0, len);
    return array.concat(temp);
}

// Problem 12
console.log("12: Balanced Brackets");
var exampleString1 = "if this is balanced (it is), we will be told it is";
var exampleString2 = "if this is not balanced (it is not, we [will] be told it is't}";
function balanced(string){
    console.log(string);
    var brackets = "(){}[]";
    var stack = [];
    for(i = 0; i < string.length; i++){
        if(string[i] == brackets[0] || string[i] == brackets[2] || string[i] == brackets[4]){
        stack.push(string[i]);
      }
      if(string[i] == brackets[1] || string[i] == brackets[3] || string[i] == brackets[5]){
        if(!match(stack.pop(), string[i])){
          return console.log("This string is not balanced.");
        }
      }
    }
    return console.log("This string is balanced.");
}
  
function match(str1, str2){
    if(str1 == "(" && str2 == ")"){
      return true;
    } else if(str1 == "{" && str2 == "}"){
      return true;
    } else if(str1 == "[" && str2 == "]"){
      return true;
    } else{
      return false;
    }
}

