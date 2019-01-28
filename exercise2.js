//1
function fizzBuzz(){
    for (i=0; i<100; i++)
    {
    if (i%15==0)
    console.log("Fizz");
    else if (i%3==0)
    console.log("Buzz");
    else if (i%5==0)
    console.log("FizzBuzz");
    else console.log(i);
    }
}

//2
function maxLength(array){
    var x = 0;
    for (i=0; i<array.length-1; i++){
        if (array[i+1].length > array[i].length) {x = i+1;}
        else {x = i;}
    }
    return x;
}

//3
function reverseArray(array) {
    var newArray=[];
    for (var i = array.length - 1; i >= 0; i--){
        newArray.push(array[i]);
    }
    console.log(newArray);
}

//4
function vowelCount(string) {
    var string = string.toString();
    var vowels = ["a", "e", "i", "o", "u"]
    counter = 0;

    for (i=0; i<string.length; i++){
        if (vowels.indexOf(string[i]) !== -1)
        {
            counter+=1;
        }
    }
    return counter;
}

//5
function removeScript(string){
        var newString = string.replace(/Script/gi, "");
        console.log(newString);
}

//5
function isLeapYear(date){
    if ((date%4==0) && (date%100!==0) || (date%400==0)) {
        return "Year IS a Leap Year!";}
    else{
        return "NOT a Leap Year!"
    }
}

//6
function isValidEmail(string){
    var reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return reg.test(String(string).toLowerCase());
}

//7
function removeChar(string, index){
    var newString = "";
    for (i=0; i<string.length; i++){
        if (i!=index) {
        newString = newString + string[i];
        } 
    }
    return newString; 
}

//8
function bubbleSort(numArray) {
    var length = numArray.length;
    while (length--) { 
        for(i=0, j=1; i<length; i++, j++) {
            if(numArray[i] > numArray[j]) {
                temp = numArray[i];
                numArray[i] = numArray[j];
                numArray[j] = temp;
            }
        }
    }
    return numArray;
}

// function isPalindrome(someStr){
//     var n=someStr.length;
//     var b=0;
//     for(b, n; b<=n; b++,n--) {
//         if (someStr[n]==someStr[b]) {
//             return true;
//         }
//         else {
//             return false;
//         }
//     }
// }

//9
function isPalindrome(someStr) {
    var holder = "";
    for (i=someStr.length-1; i>=0; i--) {
        holder = holder + someStr[i];
        console.log(holder);
    }
    if (holder == someStr) {
        return true;
    }
    else {
        return false;
    }
}

//10
function printShape(shape, height, character) {
    var row ="";
    switch(shape){

        case "square":
            for (i = 0; i < height; i++) {
                row += character;
            }
            for(i = 0; i < height; i++) {
                console.log(row);
            } 
        break;

        case "triangle":
            for (i = 0; i < height; i++) {
                row += character;
                console.log(row);
            } 
        break;

        case "diamond":
            for (i = 1; i < height -1; i++) {
                var space = "";
                for (j = 0; j < height/2 +1 -i; j++) {
                    space +=" ";
            }
                row += character.repeat(i);
                console.log(space + row);
            }

            for(i = height; i >height/2 +1; i--) {
                space = " "
                for (j=-1; j < height-i; j++) {
                    space += " ";
                }
                row = row.slice(0, -3);
                if(row <= 1) {
                    row = character;
                }
                console.log(space + row);
            }
            break;
        }
}

//11
function rotate(arr, n) {
    var length = arr.length;
    return arr.slice(length - n%length).concat(arr.slice(0, length - n%length));
  };

//12
function balanced(string) {
    n = string.length;

    if (n%2==0) {
    firstHalf = string.slice(0, n/2);  
    secondHalf = string.slice(n/2, n);  //if string is even it cuts it in half

        for(i=0; i<firstHalf.length; i++){
            // newSecondHalf = "";
            if((firstHalf[i]==("(") & secondHalf[(n/2)-i]==(")")) | (firstHalf[i]== ("[") & secondHalf[(n/2)-1-i]==("]")) | (firstHalf[i]== ("{") & secondHalf[(n/2)-1-i]==("}")) | (firstHalf[i]== (")") & secondHalf[(n/2)-1-i]==("(")) | (firstHalf[i]== ("}") & secondHalf[(n/2)-1-i]==("{")) | (firstHalf[i]== ("]") & secondHalf[(n/2)-1-i]==("["))) {
            // newSecondHalf = newSecondHalf + firstHalf[i];
                return true;
            }
            else{
                return false; //if one of the opposite elements doesnt match
            }
            // if(newSecondHalf == firstHalf) {
            //     return true;
            // }
            // else {
            //     return false;
            // }
        }

    }
    else {
        return false; //if its not even
    }

}

