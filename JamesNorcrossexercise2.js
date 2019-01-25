//problem 1 FizzBuzz
function FizzBuzz(){
    for(var i = 0; i < 100; i++){
        if(i % 3 == 0 && i % 5 == 0)
        {
            console.log("FizzBuzz");
        }
        else if(i % 5 == 0)
        {
            console.log("Buzz");
        }
        else if(i % 3 == 0){
            console.log("Fizz");
        }
        else{
            console.log(i);
        }
    }
}

//problem 2 Longest String
function maxLength(anArray){
    var currentString = "";
    var finalString = ""
    var index = 0;
    for(i = 0; i < anArray.length; i++){
    currentString = anArray[i];
    if(currentString.length > finalString.length)
    {
        finalString = currentString;
        index = i;
    }
}
return index;
}

//problem 3 reverse array
function reverseArray(anArray){
    var beginning = 0;
    var end = anArray.length - 1;
    var first = null;
    var last = null;
    while(beginning != end && beginning < end){
        first = anArray[beginning];
        last = anArray[end];
        anArray[beginning] = last;
        anArray[end] = first;
        beginning++;
        end--;
    }
    return anArray
}

//problem 4 count vowels
function vowelCount(string){
    var val = 0;
    var letter = "";
    for(i = 0; i < string.length; i++)
    {
        letter = string[i];
        switch(letter){
        case "a":
        val = val + 1;
        break;
        case "e":
        val = val + 1;
        break;
        case "i":
        val = val + 1;
        break;
        case "o":
        val = val + 1;
        break;
        case "u":
        val = val + 1;
        break;
        case "A":
        val = val + 1;
        break;
        case "E":
        val = val + 1;
        break;
        case "I":
        val = val + 1;
        break;
        case "O":
        val = val + 1;
        break;
        case "U":
        val = val + 1;
        break;
        default:
        val = val + 0;
     }
}
return val
}

//problem 5 Remove Script
function removeScript(string){
    var newString = "";
    var regex = /([Ss]+cript)/;
    if(string.search(regex))
    {
        newString = string.replace(regex, "");
    }

    else{
        newString = string;
    }
    return newString;
}

//problem 6 Find Leap Year
function isLeapYear(date){
    var theYear = date.getFullYear()
   if( theYear % 4 == 0 && theYear % 100 == 0){
           if(theYear % 400 ==0)
           {
                return true;
           }
           else{
                return false;
           }
   }
   else if(theYear % 4 == 0 && theYear % 100 != 0){
        return true;
   }
   else{
       return false;
   }
}
//problem 7 email validation
//find a way to enforce that @ needs to be before .net, .com, etc.
//have this be the norm of an email [content]@[content][content]
function isValidEmail(input){
    var regex = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    // var regex1 = /\@[A-Za-z0-9_\-\.]/;
    // var regex2 = /\.([A-Za-z]{2,4})$/;
    // var regexDig = /^[A-Za-z0-9_\-\.]/
    // var regexFinal = new RegExp(regexDig.source + "|" + regex1.source + + "|" +regex2.source);
    if(regex.test(input)){
            console.log(input + " is a valid email");
        }
        else{
            console.log(input + " is not a valid email");
        }
   }

   //problem 8 Remove Character
   function removeChar(input, int){
    var charact = input[int];
    return input.replace(charact, "");
}

//problem 9 Bubble Sort
function bubbleSort(numArray){
    var n = numArray.length;
    var temp = null;
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++)
        {
            if(numArray[j] > numArray[j+1]){
                temp = numArray[j+1];
                numArray[j+1] = numArray[j];
                numArray[j] = temp;
            }
        }
    }
    return numArray;
}

//problem 10 Palindrome
function Palindrome(input){
    var divideWord = input.split(""); 
    var arrayContain = divideWord.reverse();
    var reverseWord = arrayContain.join(""); 
    if(reverseWord == input)
    {
        return true;
    }
    else{
        return false;
    }
   }

//problem 11 Shapes
function printShape(shape, height, character){
    var middle = (height / 2) + 0.5;
    var incrementer = (height - 3) / 2;
    var left = incrementer;
    var right = height - incrementer;
    var bottleft = 1;
    var bottright = height - 1;
     switch(shape){
   case "square":
     for(i = 0; i < height; i++){
         var square = "";
         for(j = 0; j < height; j++)
         {
             square = square + character;
         }
         console.log(square);
     }
     break;
    case"triangle":
     var triangle = "";
     for(i = 0; i < height; i++){
         triangle = triangle + character;
             console.log(triangle);
     }
     break;
   case "diamond":
      for(i = 1; i <= height; i++){
         var diamond = "";
         if(i == 1 || i == height)
         {
             for(j = 1; j <= height; j++){
                 if(j == middle)
                 {
                     diamond = diamond + character;
                 }
                 else{
                     diamond = diamond + " ";
                 }
             }
             console.log(diamond);
         }
         else if(i == middle){
             for(k = 1; k <= height; k++){
                 diamond = diamond + character;
             }
             console.log(diamond);
         }
             else if(i > 1 && i < middle){
                 for(l = 0; l < height; l++){
                     if(l < left)
                     {
                         diamond = diamond + " ";
                     }
                     else if(l >= right){
                         diamond = diamond + " ";
                     }
                     else{
                         diamond = diamond + character;
                     }
                }
                left = left - 1;
                right = right + 1;
                console.log(diamond);
             }
             else{
                 for(l = 0; l < height; l++){
                     if(l < bottleft)
                     {
                         diamond = diamond + " ";
                     }
                     else if(l >= bottright){
                         diamond = diamond + " ";
                     }
                     else{
                         diamond = diamond + character;
                     }
                }
                bottleft = bottleft + 1;
                bottright = bottright - 1;
                console.log(diamond);
             }
         }
       break;
    default:
    console.log("not a valid shape");
    }
}

//problem 12 Rotate left
function rotate(thisArray, n){
    var temp = 0;
    var temp2 = 0;
    var temp3 = 0;
    var temp4 = 0;
    var last = thisArray.length - 1;
    var nextPosition = 0;
  for(i = 0; i < n; i++)
  {
      temp2 = thisArray[0];
      temp = thisArray[last]; 
      for(j =0; j < thisArray.length; j++){
          if(j == last){
              thisArray[j] = temp2
          }
          else{
              if(j+1 == thisArray.length)
              {
                 break;
              }
              else{
              thisArray[j] = thisArray[j+1];
              }
          }
              
      }
  }
  console.log(thisArray);
}

//problem 13 balanced brackets
function balanced(input){
    var curlyLcounter = 0;
    var curlyRcounter = 0;
    var bracketLcounter = 0;
    var bracketRcounter = 0;
    var parenLcounter = 0;
    var parenRcounter = 0;
    var curly = false;
    var bracket = false;
    var parenthesis = false;

    for(i = 0; i < input.length; i++){
        switch(input[i]){
            case "{":
            curlyLcounter++;
            break;
            case "}":
            curlyRcounter++;
            break;
            case "[":
            bracketLcounter++;
            break;
            case "]":
            bracketRcounter++;
            break;
            case "(":
            parenLcounter++;
            break;
            case ")":
            parenRcounter++;
            break;
            default:
            break;
        }
    }
    if(curlyLcounter == curlyRcounter){
          curly = true;
    }
    if(bracketLcounter == bracketRcounter){
          bracket = true;
    }
     if(parenLcounter == parenRcounter){
          parenthesis = true;
    }

    if(curly && bracket && parenthesis){
        return true;
    }
    else{
        return false;
    }
}