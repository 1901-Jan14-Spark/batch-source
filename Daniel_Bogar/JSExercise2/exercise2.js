//0. FizzBuzz
function fizzBuzz(){
    for(i=1;i <=100; i++){
        if(i%3 == 0 && i%5 != 0){
            console.log("Fizz");
        }
        else if(i%3 != 0 && i%5 == 0){
            console.log("Buzz")
        }
        else if(i%3 == 0 && i%5 == 0){
            console.log("FizzBuzz")
        }
        else{
            console.log(i);
        }
    }
}
//1. Longest String

function maxLength(array){
     let max = 0;
    for(i = 0; i < array.length; i++){
        if(array[i].length > max){
            max = array[i].length;
        }
    }
    return max;
}

const testArray = ["hello", "why", "sasquatch", "no"];

console.log(maxLength(testArray));

//2. Reverse Array

function reverseArray(testArray){
    let reverse = [];
    for(i = testArray.length - 1; i >= 0; i--){
        reverse.push(testArray[i]);
    }
    return reverse;
}

console.log(reverseArray(testArray));

//3.Count Vowels

function vowelCount(str){
    let vowels = ["a", "e", "i", "o", "u"];
    let counter = 0;
    for(let letter of str.toLowerCase()){
        if(vowels.includes(letter)){
            counter++;
        }
    }
    return counter;
}

console.log(vowelCount("pizza pie!"));

//4. Remove Script

function removeScript(str){
    let substring = "script";
    let lowerStr = str.toLowerCase();
    if(lowerStr.includes(substring)){
        lowerStr = lowerStr.replace(substring, '');
    }
    return lowerStr;
}

console.log(removeScript("What does a dog Script do?"));

//5.Find Leap Year

function isLeapYear(datestr){
    let date = new Date(datestr);
    let year = date.getFullYear();
    console.log(year);
    return (year % 100 ===0) ? (year % 400 === 0) : (year % 4 === 0);
}

console.log(isLeapYear("2057-02-02"));

//6. Email Validation

function isValidEmail(email){
    let re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    //let re = /\w*@daniel.com\b/;
    result = email.match(re);
    if(result == null){
        return "Not a valid email";
    }
    else{
        return "Valid Email";
    }
}
console.log(isValidEmail("bogar@daniel.com"));
console.log(isValidEmail("bogar@ daniel.com"));
console.log(isValidEmail("bogar@daniel. com"));

//7.Remove Character

function removeChar(string, index){
    let re = new RegExp(index, "g");
    let text = string.replace(re, '');
    return text;
}

console.log(removeChar("Pizza is the best!", 't'));

//8. Bubble Sort
const testBubbleArray = [1, 3, 4, 9, 20, 56, 23, 2]; //should be [1, 2, 3, 4, 9, 20, 23, 56]

function bubbleSort(arr){
    var swap;
    do {
        swapp = false;
        for (var i=0; i < arr.length; i++)
        {
            if (arr[i] > arr[i+1])
            {
               temp = arr[i];
               arr[i] = arr[i+1];
               arr[i+1] = temp;
               swapp = true;
            }
        }
    } while (swapp);
    return arr;
}

console.log(bubbleSort(testBubbleArray));

//10. Palindrome

function isPalindrome(someStr){
    let isPalindrome = false;
    let length = someStr.length;
    let reverseStr = "";
    for(i = length; i>=0; i--){
        reverseStr += someStr.charAt(i);
    }
    if(someStr == reverseStr){
        isPalindrome = true;
    }
    return isPalindrome;
}
console.log(isPalindrome("tacocat"))
console.log(isPalindrome("Bubblegum"))

//11. Shapes

//document.write('<br />')
function printShape(shape, height, character){
   switch(shape){
    case "Square":
        for(i = 0; i< height; i++){
            let square = "";
            for(j = 0; j<height; j++){
                square += character;
            }
        console.log(square);
        }
        break;
    case "Triangle":
        let triangle = "";
        for(i = 0; i< height; i++){
           triangle += character;
           console.log(triangle);
        }
        break;
    case "Diamond":
        for(var i = 0; i< height; i++){
            var str = '';
            for(var j=0; j < height - i; j++){
                str += ' ';
            }
            for(var k = 0; k< (2*i+1); k++){
                str += character;
            }
            console.log(str)
        }
        for(var i = height - 1; i > 0; i--){
            var str = '';
            for(var j= height - i + 1; j > 0; j--){
                str += ' ';
            }
            for(var k = i*2 - 1; k > 0; k--){
                str += character;
            }
            console.log(str)
        }
        break;
    default:
        console.log("This is not a valid shape.");
   }
}
printShape("Square", 3, '$');
printShape("Triangle", 5, '$');
printShape("Diamond", 9, '$');

//12. Rotate Left

function rotate(array , n){
   let temp = [];
   for(i=0; i<array.length; i++){
       temp[i] = array[(i+n)%array.length];
   }
    return temp;
  }
const numArray = [1, 2, 3, 4, 5];                                                                                                                                                                         
console.log(rotate(numArray, 3));

//13. Balanced Brackets

function balanced(string){
    let condition = false;
    let answer = false;
    let i = 0;
    do{
        if(i<(string.length/2)){
            character = string.charAt(i);
            switch(character){
                case "(":
                if(string.charAt(string.length - i - 1) == ')'){
                    answer = true;
                    condition = true;
                }
                else{
                    answer = false;
                    condition = false;
                }
                break;
                case "[":
                if(string.charAt(string.length - i - 1) == ']'){
                    answer = true;
                    condition = true;
                }
                else{
                    answer = false;
                    condition = false;
                }
                break;
                case "{":
                if(string.charAt(string.length - i - 1) == '}'){
                    answer = true;
                    condition = true;
                }
                else{
                    answer = false;
                    condition = false;
                }
                break;
                default:
                    answer = false;
                    condition = false;
                }
        }
        else{
            condition = false;
        }
    i++;
    }
    while(condition);
    return answer;
}

const bracketStr = "[({})]";
console.log(balanced(bracketStr));

