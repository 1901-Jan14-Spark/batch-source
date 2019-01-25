console.log("JS is Working");

// FizzBuzz
// Write a program that prints the numbers from 1 to 100. But for multiples of three print
// “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which
// are multiples of both three and five print “FizzBuzz”.
// for (var i=1; i<=100; i++) 




// {
//       if (i%3===0) {
//         console.log("Fizz");
//         } 
//       else if (i%5===0) {
//         console.log("Buzz");
//         }
//       else if (i%15===0) {
//             console.log("FizzBuzz");
//         }
//      else {
//         console.log(i)
//        }
// }








// Longest String
// Define function: maxLength(array)
// Write a JavaScript to find the longest string from an given array of strings and returns the
// string’s array index.








//var array = ["Monday","Tuesday","Hollyday","ThanksgivingDay","day"];

// function maxLength(array){
// let maxWord = 0;
// let index = 0;
// for (var i=0; i<array.length; i++){
//   if (array[i].length> maxWord)
//     {
//       maxWord = array[i].length;
//       index =i;
//     }
//   }
// console.log(index);
// }









// Reverse Array
// Define function: reverseArray(array)
// Write a JavaScript function to reverse the elements of a given array.









// var array = ["Monday","Tuesday","Hollyday","ThanksgivingDay","day"];
// var array = [4,76,140,43,56];

// function reverseArray(array){
//   console.log(array.reverse());
// }
// reverseArray(array)






// Count Vowels
// Define function: vowelCount(string)
// Write a JavaScript function to count the number of vowels in a given string.







// var string="thanksgivingday";
// function vowelCount(string) {
//   return string.replace(/[^aeiou]/gi, "").length;
// };
// console.log(vowelCount(string));






// Remove Script
// Define function: removeScript(string)
// Write a JavaScript function to check if a string "Script" is present in a given string. If
// "Script" is present in the string return the string without "Script" otherwise return the
// original one.






// function removeScript(string){
//   if ( string.search(/Script/)){
// var remove = string.replace(/Script/, "");
// return remove;
//   }
// else{
//   return string;
// }
//   }
//  console.log(removeScript("unsjndssdw<Script>ggjgj"));





// Find Leap Year
// Define function: isLeapYear(date)
// Create a JavaScript function that takes a date parameter and returns true if the year is a
// leap year in the Gregorian calendar






// function isLeapYear(date){
//   if (date % 4 === 0 && date % 100 !==0){
//     return true;
//     } else if (date % 4 === 0 && date % 100 === 0 && date % 400 === 0){
//     return true;
//     } else {
//     return false
//     }
// }
// console.log(isLeapYear(2296));







// Email Validation
// Define function: isValidEmail(string)
// Create a function that checks for a valid email format.
// Challenge: Try doing this with RegEx, or Regular Expressions






// function isValidEmail(string){
//   var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/

//   return regex.test(String(string).toLowerCase());
// }
// console.log(isValidEmail("younessyahoo.com"));







// Remove Character
// Define function: removeChar(string, index)
// Write a JavaScript function to remove a character at the specified position of a given
// string and return the new string.





// function removeChar(string, index){
//   let remove = string.replace(string.charAt(index), "");
//   return remove;
// }
// console.log(removeChar("youness", 4))






// Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array. You'll need to look this up!
// Return the sorted array.
// var array = [4,76,140,43,56];






// function bubbleSort(array) {
//   for ( i = 0; i <array.length; i++) {
//     for ( j = 0; j < (array.length - i); j++) {
//       if (array[j] < array[j - 1]) {
//         var tmp = array[j];
//         array[j] = array[j - 1];
//         array[j - 1] = tmp;
//       }
//     }
//   }
//   return array
// }
// console.log(bubbleSort(array));






// Palindrome
// Define function: isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false.






// function isPalindrome(someStr){
//   var re = /[\W_]/g;
//   var lowRegStr = someStr.toLowerCase().replace(re, '');
//   var reverseStr = lowRegStr.split('').reverse().join(''); 
//   return reverseStr === lowRegStr;
// }
// console.log(isPalindrome("opera"));






// Shapes
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
// *
// ***
// *****
// ***
// *







function printShape(shape, height, character){
   switch (shape){
                  case 'Triangle':
                  {
            for(var i=1; i <= height; i++)
               {
                  console.log(character.repeat(i));
               }
                  }
                break;
                case 'Square':
                {
                     for (j = 0; j < height; j++){ 
                     console.log(character.repeat(height));
                  }
               }
               break;


            //    case 'Diamond':
            //    {

            //       for(i=1;i<=height;i++){
            //          txt = "";
            //          for(j=i;j<(height/2);j++){
            //            txt += " ";
            //          }
            //          for(k=0;k<(i*2)-1;k++){
            //            txt += character;
            //          }
            //          console.log(txt);
            //        }
            //        for(i=height-1;i>=0;i--){
            //          txt = "";
            //          for(j=i;j<(height/2);j++){
            //            txt += " ";
            //          }
            //          for(k=0;k<(i*2)-1;k++){
            //            txt += character;
            //          }
            //          console.log(txt);
            //        }
            //   } 
              
               }
            }


console.log(printShape("Triangle", 3, "$"));
console.log(printShape("Square", 3, "%"));
console.log(printShape("Diamond", 5, "*"));




// Rotate Left
// Define function: rotate(array, n)
// Given array, rotate left n times and return array
// Examples
// f([1,2,3,4,5], 1) = [2,3,4,5,1]
// f([1,2,3,4,5], 6) = [2,3,4,5,1]
// f([1,2,3,4,5], 3) = [4,5,1,2,3]





// var array = [1,2,3,4,5];
// function rotate(array, n){
// array = array.slice();
// while( n-- ){
//   var temp = array.shift();
//   array.push( temp )
// }
// return array;
// }
// console.log(rotate(array, 3));






// Balanced Brackets
// Define function: balanced(string)
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
// Create a function which takes a string of brackets and returns true if balanced and false
// if not balanced








// function balanced(string){

//     let arr = [];
//     let map = {'(': ')', '[': ']', '{': '}'}

//     for (let i = 0; i < string.length; i++) {
//         if (string[i] === '(' || string[i] === '{' || string[i] === '[' ) {
//             arr.push(string[i]);
//         }
//         else {
//             let last = arr.pop();
//             if (string[i] !== map[last]) {
//               return false};
//              }
//     }
//         if (arr.length !== 0) {
//           return false};
//     return true;
// }
// console.log(balanced("()()()(())({[]})"));
