var maxLengthTest = ["short", "short", "shortish", "Loooooong", "short"];
var reverseArrayTest1 = [1, 2, 3, 4];
var reverseArrayTest2 = [1, 2, 3, 4, 5];
var testStringScript = "ThisString has the word Script in it: Script Scripty Script";  //also works for countVowels
var testStringNoScript = "This string does not have that word";
var emailTest = "me@email.com";
var palindropme = "tacocat";
var parBalance1 = "{([])}";
var parBalance2 = "(([]))";
var parUnbalanced1 = ")({})(";
var parUnbalanced2 = "(}){(}";
var bubbles = [12, 345, 4, 546, 122, 84, 98, 64, 9, 1, 3223, 455, 23, 234, 213];

// document.getElementById("title") = "New title";
// let newNode = document.createElement("h3");
// newNode.innerHTML = "Subtitle I guess?";


//0  Fizzbuzz
function FizzBuzz() {
    let printMe = "";
    for (i = 1; i < 101; i++) {
        if (i % 3 == 0) { printMe += "Fizz"; }
        if (i % 5 == 0) { printMe += "Buzz"; }
        if (i % 3 != 0 && i % 5 != 0) { printMe += i; }
        console.log(printMe);
        printMe = "";
    }
    return "Done!";
}

// 1.      Longest String. Write a JavaScript to find the longest string from an given array of strings and returns the string’s array index.
function maxLength(array) {
    let longestIndex = 0;
    let longestLength = 0;
    let currentString = "";

    for (i = 0; i < array.length; i++) {
        currentString = array[i];
        if (currentString.length > longestLength) {
            longestLength = array[i].length;
            longestIndex = i;
        }
    }
    return longestIndex;
}


// 2.      Reverse Array. Write a JavaScript function to reverse the elements of a given array.
function reverseArray(array) {
    let max = array.length - 1;
    let newArray = [];
    for (i = 0; i <= max; i++) {
        newArray[i] = array[max - i];
    }
}

// 3.     Count Vowels. Write a JavaScript function to count the number of vowels in a given string.
function vowelCount(string) {
    let numVowels = 0;
    for(i of string){
        if(i == "a" || i == "e" || i == "i" || i == "o" || i =="u") numVowels++;
    }
    // let stringCopy = string;
    // let strLen = string.length;
    // let lastVowel = 0;
    // let countA = -1;
    // let countE = -1;
    // let countI = -1;
    // let countO = -1;
    // let countU = -1;
    // let countY = -1; //sometimes
    // while (lastVowel != -1) { //Count a's in string
    //     countA++;
    //     lastVowel = stringCopy.indexOf("a"); //Find the first "a" in the string
    //     if (lastVowel > -1) stringCopy = stringCopy.slice(lastVowel + 1, strLen); //cuts the string
    // }
    // stringCopy = string; //Resets the string for next loop
    // while (lastVowel != -1) { //Count a's in string
    //     countE++;
    //     lastVowel = stringCopy.indexOf("e"); //Find the first "e" in the string
    //     if (lastVowel > -1) stringCopy = stringCopy.slice(lastVowel + 1, strLen); //cuts the string
    // }
    // stringCopy = string;
    // while (lastVowel != -1) { //Count a's in string
    //     countI++;
    //     lastVowel = stringCopy.indexOf("i"); //Find the first "i" in the string
    //     if (lastVowel > -1) stringCopy = stringCopy.slice(lastVowel + 1, strLen); //cuts the string
    // }
    // stringCopy = string;
    // while (lastVowel != -1) { //Count a's in string
    //     countO++;
    //     lastVowel = stringCopy.indexOf("o"); //Find the first "o" in the string
    //     if (lastVowel > -1) stringCopy = stringCopy.slice(lastVowel + 1, strLen); //cuts the string
    // }
    // stringCopy = string;
    // while (lastVowel != -1) { //Count a's in string
    //     countU++;
    //     lastVowel = stringCopy.indexOf("u"); //Find the first "u" in the string
    //     if (lastVowel > -1) stringCopy = stringCopy.slice(lastVowel + 1, strLen); //cuts the string
    // }
    // stringCopy = string;
    // while (lastVowel != -1) { 
    //     countY++;
    //     lastVowel = stringCopy.indexOf("y"); 
    //     if (lastVowel > -1) stringCopy = stringCopy.slice(lastVowel + 1, strLen); 
    // }
    return (numVowels);
}


// 4.      Remove Script. Write a JavaScript function to check if a string "Script" is present in a given string. If "Script" is present in the string return the string without "Script" otherwise return the original one.
function removeScript(string) {
    let stringCopy1 = string; //copy string into disposable variable
    let stringCopy2 = string; //second copy
    let firstHalf = "";
    let secondHalf = "";
    let lastScript = 0;
    let repeats = 0;
    if (string.indexOf("Script") != -1) {
        while (lastScript > -1) {
            console.log(stringCopy1.indexOf("Script"));
            lastScript = stringCopy1.indexOf("Script");
            firstHalf = stringCopy1.slice(0, lastScript);//cut string before "Script"
            stringCopy1 = stringCopy2; //reset disposable string using second copy
            secondHalf = stringCopy1.slice(lastScript + 6, string.length); //cut string after "Script"
            stringCopy1 = firstHalf + secondHalf; //fuse halves
            stringCopy2 = stringCopy1; //update second copy
            lastScript = stringCopy1.indexOf("Script");
            repeats ++;
            if(repeats > 9000){ //infinity check
                console.log("IT'S OVER 9000!!!!");
                break;
            }
        }
        return (stringCopy1);
    }
    else return (string);
}

// 5.      Find Leap Year. Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.
function isLeapYear(date) {
    return((date%4 == 0 && date%100 != 0) || (date%400 ==0));
}

// 6.      Email Validation. Create a function that checks for a valid email format. Challenge  Try doing this with RegEx, or Regular Expressions
function isValidEmail(string) {
    let atPos = string.indexOf("@");
    let dotPos = string.lastIndexOf(".");
    // console.log(atPos, ", ", dotPos, ", ", string.length); //debugging 
    return (atPos > 0 && dotPos == string.length - 4);
}

// 7.     Remove Character. Write a JavaScript function to remove a character at the specified position of a given string and return the new string.
function removeChar(string, index) {
    let stringCopy = string; //copy string into disposable variable
    let firstHalf = stringCopy.slice(0, index - 1); //cut string before index
    stringCopy = string; //reset disposable string for second half
    let secondHalf = stringCopy.slice(index, string.length); //cut string after index
    return (firstHalf + secondHalf); //fuse halves
}

// 8.       Bubble Sort. Use the bubble sort algorithm to sort the array. You'll need to look this up! Return the sorted array.
function bubbleSort(numArray) {
    let arLen = numArray.length;
    let swaps = 0;
    let holder = 0;
    do {
        swaps = 0; //reset counter for new iteration
        for (i = 0; i < arLen - 1; i++) {// runs for all but the last index
            if (numArray[i] <= numArray[i + 1]) continue;
            else {
                holder = numArray[i];
                numArray[i] = numArray[i + 1];
                numArray[i + 1] = holder;
                swaps++;
            }
        }
    } while (swaps > 0)
    return (numArray);


}

// 10.   Palindrome. Return true if someStr is a palindrome, otherwise return false.
function isPalindrome(someStr) {
    let rtsEmos = ""; //Initialize reverse string. (Get it? :D)
    let strLen = someStr.length;
    for (i = 0; i < strLen; i++) {
        rtsEmos += someStr[strLen - i - 1]; //Starts writing the reverse string at 0 using the last character in someStr
    }
    // console.log(someStr, rtsEmos); //debugging
    return (rtsEmos == someStr);
}


// 11.   Shapes. See text File.
function printShape(shape, height, character) {
    let endString = "";
    let spaceCounter = 0;
    let charCounter = 0;
    let space = " ";
    let halfHeight = (height - 1) / 2;
    switch (shape) {
        case ("Square"):
            for (i = 0; i < height; i++) {
                for (j = 0; j < height; j++) {
                    endString = endString + character;
                }
                console.log(endString);
                endString = "";//reset string line
            }
            break;
        case ("Triangle"):
            for (i = 0; i < height; i++) {
                for (j = 0; j < height; j++) {
                    if (i < j) {
                        endString = endString + " ";
                    }
                    else {
                        endString = endString + character;
                    }
                }
                console.log(endString);
                endString = "";//reset string line
            }
            break
        case ("Diamond"):
            for (i = 0; i < height; i++) {

                if (i < halfHeight) {//top half
                    spaceCounter = halfHeight - i;
                    charCounter = 1 + (i + i);
                    endString += space.repeat(spaceCounter) + character.repeat(charCounter);
                    // console.log(endString);
                }
                else { //bottom half of diamond
                    spaceCounter = i - halfHeight;
                    charCounter = (height - i - 1) * 2 + 1;
                    endString += space.repeat(spaceCounter) + character.repeat(charCounter);
                }

                console.log(endString);
                endString = ""; //reset string line
            }

    }
    return ("Shape Printed!");
}

// 12.   Rotate Left. See text File.
function rotate(array, n) {
    let newAr = []; //automatically makes a new array the same size as the old one
    let move = 0; //initialize variable for how much an individual value moves
    let arLn = array.length;
    for (i = 0; i < arLn; i++) {
        move = i + n;
        if (i + n > arLn) move = i + n - arLn;
        else move = i + n;
        console.log(`i1= ${i}, i2= ${arLn - move}`);
        newAr += array[arLn - move];
        console.log(newAr, ", ", array);
    }
    return (newAr);
}

// 13.   Balanced Brackets. See text file.
function balanced(string) {
    let openPar = 0;
    let openSqu = 0;
    let openCur = 0;
    let prevChar = "";

    for (i = 0; i < string.length; i++) {
        switch (string.charAt(i)) {
            case "(":
                openPar++;
                prevChar = ")";
                break;
            case ")":
                if (prevChar == "{" || prevChar == "[" || openPar < 1){
                    return (false);}
                openPar--;
                prevChar = "(";
                break;
            case "[":
                openSqu++;
                prevChar = "[";
                break;
            case "]":
                if (prevChar == "{" || prevChar == "(" || openSqu < 1){
                    return (false);}
                openSqu--;
                prevChar = "]";
                break;
            case "{":
                openCur++;
                prevChar = "{";
                break;
            case "}":
                if (prevChar == "(" || prevChar == "[" || openCur < 1) 
                return (false);
                }
                openCur--;
                prevChar = "}";
                break;
            // default: return (false);
        }

    }
    if (openSqu || openPar || openCur)return (false);
    else return (true);



}