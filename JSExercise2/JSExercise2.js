// Required:

// 0.      FizzBuzz
// Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number and 
// for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”.

function FizzBuzz(){
    for(i=0; i<=100; i++){
        if (i % 3 == 0) {
            console.log("Fizz");
        }
    

        else if(i%5 == 0){
            console.log("Buzz");
        }
    

        else if(i%5==0 && i%3 ==0){
            console.log("FizzBuzz");
        }
        else {
            console.log(i);
        }
    }
}

// 1.      Longest String
// Define function: maxLength(array)
// Write a JavaScript to find the longest string from an given array of strings and returns the string’s array index.

function maxLength(array){
    let longest = array[0];
    for (let i = 1; i < array.length; i++) {
        if (array[i].length > longest.length) {
            longest = array[i];
        }
    }
    return array.indexOf(longest);
}

let array1 = ["One", "LOOOOOOOOOOOOOOOOOONGER", "Hundreds", "loooooooooooong"];

console.log(maxLength(array1));
 
//  2.      Reverse Array
// Define function: reverseArray(array)
// Write a JavaScript function to reverse the elements of a given array.

function reverseArray(array){
    let newarray = [];
    let last = array.length;
    for (i = last-1; i >= 0; i--){
        newarray.push(array[i]);
    }
    return newarray; 
}

let array2 = ["vijay", "is", "name", "my", "hi"];

console.log(reverseArray(array2));
 
// 3.     Count Vowels 
// 	Define function: vowelCount(string)
// 	 Write a JavaScript function to count the number of vowels in a given string.

function vowelCount(String){
    return (String.match(/[aeiou]/gi) || []).length;
}
console.log(vowelCount("test"));

function getVowels(str) {
    var vowelsCount = 0;
    //loop through the string
    for (var i = 0; i <= str.length - 1; i++) {
  
    //if a vowel, add to vowel count
      if (str.charAt(i) == "a" || str.charAt(i) == "e" || str.charAt(i) == "i" || str.charAt(i) == "o" || str.charAt(i) == "u") {
        vowelsCount += 1;
      }
    }
    return vowelsCount;
  }

console.log(getVowels("Llama"));
 
// 4.      Remove Script
// Define function: removeScript(string)
// Write a JavaScript function to check if a string "Script" is present in a given string. If "Script" is present in the string return the string without "Script" otherwise return the original one.

function removeScript(String){
    String.trim;
    if (String.includes("Script")){
        return String.replace(/[Script]/g, '');
    }
    else return String; 
}


testString = "JavaScriptScript";

console.log(removeScript(testString));


// 5.      Find Leap Year
// Define function: isLeapYear(date)
// Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.


    function isLeapYear(date){
        if (new Date(date, 1, 29).getMonth() == 1){
            return true;
        }
        else return false;    
    }

    console.log(isLeapYear(2020));

// 6.      Email Validation 
// Define function: isValidEmail(string)
// Create a function that checks for a valid email format. 
// Challenge: Try doing this with RegEx, or Regular Expressions

function isValidEmail(string){
    if (string.includes("@") && string.match(/.com$/)){
        return true;
    }
    else return false;
}

console.log(isValidEmail("@.com"));
    
// 7.     Remove Character
// 	Define function: removeChar(string, index)
// Write a JavaScript function to remove a character at the specified position of a given string and return the new string.

function removeChar(string, index) {
    let newString = string.slice(0, index) + string.slice(index+1);
    return newString;
}

console.log(removeChar("Yayay", 2));


// 8.       Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array. You'll need to look this up!
// Return the sorted array.


var testArray = [9, 208, 73, 21, 5, 63, 820, 52];

function bubbleSort(numArray) {
    var swapped;
    do {
        swapped = false;
        for (var i=0; i < testArray.length-1; i++) {
            if (testArray[i] > testArray[i+1]) {
                var temp = testArray[i];
                testArray[i] = testArray[i+1];
                testArray[i+1] = temp;
                swapped = true;
            }
        }
    } while (swapped);

    return numArray;
}

console.log(bubbleSort(testArray));

 
// 9.   Palindrome
// Define function: isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false.

function isPalindrome(someStr){
        someStr = someStr.toLowerCase();
        if(someStr.length === 1){
          return true;
        }else if(someStr[0] !== someStr[someStr.length-1]){
          return false;
        }
          return isPalindrome(someStr.slice(1,-1));
    }  
      console.log(isPalindrome("racecar"));
 
// 10.   Shapes
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

// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *						

function printShape (shape, height, character){
    shape = shape.toLowerCase();
    let str = "";
    
    switch(shape){
        case "square":
            for (i = 0; i <= height; i++){    
                console.log(str);
                str = "";
                
                for (j = 0; j < height; j++){
                    str += character;
                }
            }
             break;
             
        case "triangle":
            for (i = 0 ; i <= height; i++){
                console.log(str);

                for(j = 0 ; j < 1; j++){
                    str += character;
                }
                
            }
            break;
        
        case "diamond":
            for(i = 1; i < height - 1; i++){
                var row = "";
                var space = "";
                for(j = 0; j < height/2 + 1- i; j++){
                  space += " ";
                }
                row += character.repeat(i);
                console.log(space + row);
              }

              for(i = height; i > height/2 + 1; i--){
                space = " ";
                for(j = -1; j < height-i+1; j++){
                  space += " ";
                }
                row = row.slice(0, -3);
                if(row <= 1){
                  row = character;
                }
                console.log(space + row);
              }

            break;

            default:
            console.log("Invalid shape request");
    }
              
    }   
// 11.   Rotate Left
// Define function: rotate(array, n)
// Given array, rotate left n times and return array
// Examples
// f([1,2,3,4,5], 1) = [2,3,4,5,1]
// f([1,2,3,4,5], 6) = [2,3,4,5,1]
// f([1,2,3,4,5], 3) = [4,5,1,2,3]

var array3 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

function rotate(array, n) {
    n %= array.length;
    if (n < array.length - n) {
        while (n--) {
            array.unshift(array.pop()) }
    } 
        else {
        n = array.length - n;
        while (n--) {
            array.push(array.shift()) }
    }
    return array;
}
console.log(rotate(array3, 1));

// 12.   Balanced Brackets
//  	Define function: balanced(string)

// A bracket is any one of the following: (, ), {, }, [, or ]
 
// The following are balanced brackets:
// ()
// ()()
// (())
// ({[]})
 
// The following are NOT balanced brackets
// (
// )
// (()
// ([)]
 
// Create a function which takes a string of brackets and returns true if balanced and false if not balanced
 
