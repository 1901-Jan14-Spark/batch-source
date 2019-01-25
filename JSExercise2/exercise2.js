
// 0.      FizzBuzz
           // 	Define function: fizzbuzz
           // Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”.
function fizzbuzz()
{
  for (x=1; x <= 100; x++){
    if (x % 3 == 0 && x % 5 == 0){
      console.log("FizzBuzz");
    }
    else if (x % 3 == 0 ){
      console.log("Fizz");
    }
    else if (x % 5 == 0 ){
      console.log("Buzz");
    }
    else{
      console.log(x);
    }
  }
}
console.log("a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number and for the multiples of five print \“Buzz\”. For numbers which are multiples of both three and five print \“FizzBuzz\”")
fizzbuzz();


// 1.      Longest String
            // Define function: maxLength(array)
            // Write a JavaScript to find the longest string from an given array of strings and returns the string’s array index.
          
var array=["My","Name", "Is", "Habtamu"];          
function maxLength(array) { 
  longest_str = array[0]
  for(var i = 0; i < array.length; i++) {
     if(array[i].length > longest_str.length) {
        longest_str = array[i];
      } 
    }
  return longest_str;
  }
console.log("array value: ", array);
console.log("The longest value in array: ", maxLength(array));

//  2.      Reverse Array
            // Define function: reverseArray(array)
            // Write a JavaScript function to reverse the elements of a given array.
var array = ['one', 'two', 'three'];
function reverseArray(array){
  reverse_array = []
  index = 0;
  for (i = array.length - 1; i >= 0; i--){
    reverse_array[index++] = array[i];
  }
  return reverse_array
}
console.log('array1: ', array);
console.log("reverse array1: ", reverseArray(array));

 
// 3.     Count Vowels 
          // 	Define function: vowelCount(string)
          // 	 Write a JavaScript function to count the number of vowels in a given string.
  function vowelCount(string)
  {
    var vowel_list = 'aeiouAEIOU';
    var vcount = 0;
    for(var x = 0; x < string.length ; x++)
    {
      if (vowel_list.indexOf(string[x]) !== -1)
        {
        vcount += 1;
        }
    
    }
    return vcount;
  }
  console.log("the vowel count in the word Ethiopia: ", vowelCount("Ethiopia"));





// 4.      Remove Script
           // Define function: removeScript(string)
           // Write a JavaScript function to check if a string "Script" is present in a given string. If "Script" 
           // is present in the string return the string without "Script" otherwise return the original one.
           
function removeScript(string){
    if (string.indexOf("Script") !== -1 ){
       return removeScript(string.replace("Script", ""));
    }
    return string;
}   
console.log("Checking removeScript for HelloScriptScript: ", removeScript("HelloScript"));  




// 5.      Find Leap Year
           // Define function: isLeapYear(date)
           // Create a JavaScript function that takes a date parameter and returns true if the year is a leap 
           //year in the Gregorian calendar.


function isLeapYear(Date){
  var year; 
  if (Date/400){
    year = true
  }
  else if(Date/100){
    year = false
  }
  else if(Date/4){
    year= true
  }
  else{
    year= false
  }
  return year;
}
console.log("checking leap year", isLeapYear(2012));


// 6.      Email Validation 
           // Define function: isValidEmail(string)
           // Create a function that checks for a valid email format. 
           // Challenge: Try doing this with RegEx, or Regular Expressions

  
         
function isValidateEmail(string) {
   
    var emailRegex = new RegExp (/^([A-Za-z0-9_\-.])+@([A-Za-z0-9_\-.])+\.([A-Za-z]{2,4})$/);
    return emailRegex.test(string);

}

console.log(isValidateEmail("haab@gmail.com"));



// 7.     Remove Character
          // 	Define function: removeChar(string, index)
          // Write a JavaScript function to remove a character at the specified position of a given string and 
          // return the new string.
          function removeCharacter(string, index) 
          {
           remove_character = string.substring(0, index);
           return  remove_character;
          }
         
         console.log(removeCharacter("Habtamu",6));

            


// 8.       Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array. You'll need to look this up!
// Return the sorted array.
var anumArray = [67, 6673, 89, 856, 200, 647644, 198, 7964, 783];

function bubbleSort(anumArray) {
    var swapped;
    do {
        swapped = false;
        for (var i=0; i < anumArray.length-1; i++) {
            if (anumArray[i] > anumArray[i+1]) {
                var temp = anumArray[i];
                anumArray[i] = anumArray[i+1];
                anumArray[i+1] = temp;
                swapped = true;
            }
        }
    } while (swapped);
}

bubbleSort(anumArray);
console.log(anumArray)

  
// 10.   Palindrome
// Define function: isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false.


function isPalindrome(someStr){
var length = someStr.length;
var reverse="";
for(i=length-1;i>=0; i--)
{ 
  reverse=reverse+someStr.charAt(i);
} 
return(reverse==someStr)? true:false;
console.log(reverse);

}
console.log(isPalindrome("mom"))




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

// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *		

// Function to print hollow rectangle 
// void printShape("Square", 3, "%")
// { 
//    shape="Square";
//    height= 3;
//   character="%";
// n=3,m=3;
// perimeter and area are handled by the
// Rectangle superclass
// Square

//    function printShape(shape, height, character)
// {
// switch(shape)
//   {
// case "Square":
//   }
// let i;
//   m=3,n=3;
//   for(i = 0; i < size; i++) {
//     print ("*");
//     if (size === i){ 
//     println (""); 
//     }
//     }

// } 
// console.log(square);





// 12.   Rotate Left
// Define function: rotate(array, n)
// Given array, rotate left n times and return array
// Examples
// f([1,2,3,4,5], 1) = [2,3,4,5,1]
// f([1,2,3,4,5], 6) = [2,3,4,5,1]
// f([1,2,3,4,5], 3) = [4,5,1,2,3]
var names = ['kaven','tom','marco','thanson'];
function rotate( array , n){
  while( n-- ){
    var temp = array.shift();
    array.push( temp )
  }
}
rotate( names ,3 )
console.log( names);


// 13.   Balanced Brackets
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
 
const Balanced = (string) => {
  const arr = string.split('');
  var open = [];
  
  const openBrackets = {
    '(': true,'[': true,'{': true,};
  
  const closedBrackets = {
    ')': '(',
    ']': '[',
    '}': '{',
  };
  
  for (var i = 0, length = arr.length; i < length; i++) {
    if (openBrackets[arr[i]]) {
      open.push(arr[i]);
      return true;

    } else if (closedBrackets[arr[i]] && open.pop() !== closedBrackets[arr[i]]) {
      return false;
    }
  }  
}
console.log(Balanced(''));
console.log(Balanced('()'));
console.log(Balanced(')()'));
console.log(Balanced(')('));
console.log(Balanced('()(()()()())'));
console.log(Balanced('[](){}'));
console.log(Balanced('[({})]'));
console.log(Balanced('[(]{)}'));
























