// global test variables
var strArr = new Array("hello", "nah", "I", "arblarghargh", "toohoo");
var numArr = new Array(6, 5, 2, 1, 3, 4);
var numArr2 = new Array(1, 2, 3, 4, 5, 6);
var testStr = "This is a String with a <Script>";
var palin = "01011010";

// Required:
//
// 0.      FizzBuzz
// Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. \
// For numbers which are multiples of both three and five print “FizzBuzz”.

function fizzBuzz(){
  for(i = 1; i < 100; i++){
    if(i % 3 == 0 && i % 5 == 0){
      console.log("FizzBuzz");
    } else if(i % 3 == 0){
      console.log("Fizz");
    } else if(i % 5 == 0){
      console.log("Buzz");
    } else{
      console.log(i);
    }
  }
}

//
// 1.      Longest String
// Define function: maxLength(array)
// Write a JavaScript to find the longest string from an given array of strings and returns the string’s array index.

function maxLength(array){
  var len = 0;
  var here = 0;
  for(i in array){
    if(array[i].length > len){
      len = array[i].length;
      here = i;
    }
  }
  return array[here];
}

// 2.      Reverse Array
// Define function: reverseArray(array)
// Write a JavaScript function to reverse the elements of a given array.

function reverseArray(array){
  return array.reverse();
}

// 3.     Count Vowels
//     Define function: vowelCount(string)
//      Write a JavaScript function to count the number of vowels in a given string.

function vowelCount(string){
  var count = 0;
  for(i of string){
    if(i == "a" || i == "e" || i == "i" || i == "o" || i == "u"){
      count++;
    }
  }
  return count;
}

console.log(vowelCount(testStr));

// 4.      Remove Script
// Define function: removeScript(string)
// Write a JavaScript function to check if a string "Script" is present in a given string. If "Script" is present in the string return the string without "Script" otherwise return the original one.

function removeScript(string){
  return string.replace(/Script/g, '');
}

console.log(removeScript(testStr))

// 5.      Find Leap Year
// Define function: isLeapYear(date)
// Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.

function isLeapYear(date){
  var year = date.getFullYear();
  if(year % 4 == 0){
    return true;
  } else{
    return false;
  }
}

// 6.      Email Validation
// Define function: isValidEmail(string)
// Create a function that checks for a valid email format.
// Challenge: Try doing this with RegEx, or Regular Expressions

function isValidEmail(string){
  // word + @ + any alphabet + . any alphabet 2 or 3 characters.
  var re = /^\w+@[a-zA-Z]+\.[a-zA-Z]{2,3}/;
  return re.test(String(string).toLowerCase());
}

console.log(isValidEmail("shimjay1@gmail.com"));

// 7.     Remove Character
//     Define function: removeChar(string, index)
// Write a JavaScript function to remove a character at the specified position of a given string and return the new string.

function removeChar(string, index){
  return string.slice(0, index) + string.slice(index+1);
}

console.log(removeChar(testStr, 8));

// 8.       Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array. You'll need to look this up!
// Return the sorted array.

function bubbleSort(numArray){
  var changed = true;
  while(changed){
    changed = false;
    for(i = 0; i < numArray.length - 1; i++){
      if(numArray[i] > numArray[i + 1]){
        var temp = numArray[i];
        numArray[i] = numArray[i + 1];
        numArray[i + 1] = temp;
        changed = true;
      }
    }
  }
  return numArray;
}

console.log(bubbleSort(numArr));

//
// 10.   Palindrome
// Define function: isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false.

function isPalindrome(someStr){
  return someStr == someStr.split('').reverse().join('');
}

console.log(isPalindrome(palin));

// 11.   Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape.
// Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
//
// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *
// shape = "Square", "Triangle", "Diamond".
// height = odd number
// character = content char
function printShape(shape, height, character){
  var row = "";
  switch(shape){
    case "Square":
      for(i = 0; i < height; i++){
        row += character;
      }
      for(i = 0; i < height; i++){
        console.log(row);
      }
      break;
    case "Triangle":
      for(i = 0; i < height; i++){
        row += character;
        console.log(row);
      }
      break;
    case "Diamond":
      //tophalf
      for(i = 1; i < height - 1; i++){
        var space = "";
        for(j = 0; j < height/2 + 1 - i; j++){
          space += " ";
        }
        row += character.repeat(i);
        console.log(space + row);
      }

      //bottom half
      for(i = height; i > height/2 + 1; i--){
        space = " ";
        for(j = -1; j < height-i; j++){
          space += " ";
        }
        row = row.slice(0, -3);
        if(row <= 1){
          row = character;
        }
        console.log(space + row);
      }
      break;
    }
}

console.log(printShape("Square", 4, "&"));
console.log(printShape("Triangle", 3, "x"));
console.log(printShape("Diamond", 5, "{"));


// 12.   Rotate Left
// Define function: rotate(array, n)
// Given array, rotate left n times and return array
// Examples
// f([1,2,3,4,5], 1) = [2,3,4,5,1]
// f([1,2,3,4,5], 6) = [2,3,4,5,1]
// f([1,2,3,4,5], 3) = [4,5,1,2,3]
//

function rotate(array, n){
  var len = n % array.length;
  var temp = new Array(len);
  for(i = 0; i < len; i++){
    temp[i] = array[i];
  }
  array.splice(0, len);
  return array.concat(temp);
}

console.log(rotate(numArr2, 9));

// 13.   Balanced Brackets
//      Define function: balanced(string)
//
// A bracket is any one of the following: (, ), {, }, [, or ]
//
// The following are balanced brackets:
// ()
// ()()
// (())
// ({[]})
//
// The following are NOT balanced brackets
// (
// )
// (()
// ([)]
//
// Create a function which takes a string of brackets and returns true if balanced and false if not balanced
//
//

function balanced(string){
  var brackets = "(){}[]";
  var stack = [];
  for(i = 0; i < string.length; i++){
    if(string[i] == brackets[0] || string[i] == brackets[2] || string[i] == brackets[4]){
      stack.push(string[i]);
    }
    if(string[i] == brackets[1] || string[i] == brackets[3] || string[i] == brackets[5]){
      if(!match(stack.pop(), string[i])){
        return false;
      }
    }
  }
  return true;
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

console.log(balanced("if(this is balanced[it should be] we {did well})"))







//
