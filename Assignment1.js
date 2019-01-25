// Problem 0 FizzBuzz
function fizzBuzz() {
    for(i = 1; i <= 100; i++) {
        if((i % 5 == 0) && (i % 3 == 0)) {
            console.log("FizzBuzz");
        } else if (i % 5 == 0) {
            console.log("Fizz");
        } else if (i % 3 == 0) {
            console.log("Buzz");
        }
        else {
            console.log(i);
        }
    }
}

// Problem 1 Longest String
function maxLength(array) {
    var index = 0;
    for(i = 0; i < array.length; i++) {
        var longestString = array[0];
        if(array[i].length > longestString.length) { 
            index = i;
            longestString = array[i];
        }
    } console.log(index);
}

// Problem 2 Reverse Array
function reverseArray(array) {
    var newArray = array.reverse();
    for(i = 0; i < array.length; i++) {
        console.log(newArray[i]);
    }
}

// Problem 3 Count Vowels
function vowelCount(string) {
    vowelCount = 0;
    string = string.toLowerCase();
    for(i = 0; i < string.length; i++) {
        if(string[i] == "a") {
            vowelCount++;
        } else if(string[i] == "e") {
            vowelCount++;
        } else if(string[i] == "i") {
            vowelCount++;
        } else if(string[i] == "o") {
            vowelCount++;
        } else if(string[i] == "u") {
            vowelCount++;
        }
    } console.log(vowelCount);
}

// Problem 4 Remove Script
function removeScript(string) {
    string = string.toLowerCase();
    string = string.replace(/script/g, "")
    console.log(string);
}

// Problem 5 Find Leap Year
function isLeapYear(date) {
    // if((date % 4 == 0) || ((date % 100 == 0) & (date % 400 == 0))) {
    //     return true;
    // } else {
    //     return false;
    // }
    if(new Date(date, 1, 29).getDate() == 29) {
        return true;
    } return false;
}

// Problem 6 Email Validation
function isValidEmail(string) {
    if(string.includes("@") && string.includes(".com")) {
        return true;
    } return false;
}

// Problem 7 Remove Character
function removeChar(string, index) {
    string = string.replace(string[index], "");
    console.log(string);
}

// Problem 8 Bubble Sort
function bubbleSort(numArray) {
    for(i = 0; i < numArray.length; i++) {
        for(j = 0; j < numArray.length-i-1; j++) {
            if(numArray[j] > numArray[j+1]) {
                placeHolder = numArray[j];
                placeHolder2 = numArray[j+1];
                numArray[j] = placeHolder2;
                numArray[j+1] = placeHolder;
            }
        }
    } console.log(numArray);
}

// Problem 9 Palindrome
function isPalindrome(someStr) {
    var someStr2 = someStr.split("").reverse().join("");
    if (someStr == someStr2) {
        return true;
    } return false;
}

// Problem 10 Shapes
function printShape(shape, height, character) {
    switch(shape) {
        case "Square":
            for(i = 0; i < height; i++) {
                console.log(character + character + character)
            } break;

        case "Triangle":
            var triangle = "";
            for(i = 0; i < height; i++) {
                triangle = triangle + character;
                console.log(triangle);
            } break;

        case "Diamond":
            var newRow = "";
            for(i = 1; i < height - 1; i++){
            var addSpace = "";
            for(j = 0; j < height/2 + 1- i; j++){
                addSpace += " ";
            }
            newRow += character.repeat(i);
            console.log(addSpace + newRow);
            }
            for(i = height; i > height/2 + 1; i--){
            addSpace = " ";
            for(j = -1; j < height-i; j++){
                addSpace += " ";
            }
            newRow = newRow.slice(0, -3);
            if(newRow <= 1){
                newRow = character;
            }
            console.log(addSpace + newRow);
            }
        break;
    }
}
printShape("Diamond", 5, "*");

// Problem 11 Rotate Array
function rotate(array, n){
    var lengthMod = n % array.length;
    var tempArray = new Array(lengthMod);
    for(i = 0; i < lengthMod; i++){
        tempArray[i] = array[i];
    }
    array.splice(0, lengthMod);
    return array.concat(tempArray);
}

// Problem 12 Balanced Bracket
function balanced(string) {

}