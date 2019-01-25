//Problem 0: 
function FizzBuzz(){
    for(i=1;i<101;i++){
        if(i%15==0){
            console.log("FizzBuzz");
            continue;
        }
        if(i%3==0){
            console.log("Fizz");
            continue;
        }
        if(i%5==0){
            console.log("Buzz");
            continue;
        }
        console.log(i);
    }
}
// Problem 1
function maxLength(array){
    let max = array[0].length;
    for(i=1; i<array.length; i++)
        if(max < array[i].length)
            max = array[i].length
    return max;
}
// Problem 2
function reverseArray(array){
    let rArray= [];
    let x = array.length - 1;
    for(i=x;i>=0; i--){
        rArray.push(array[i]);
    }
    return rArray;
}
// Problem 3
function vowelCount(word){
    let count = 0;
    word = word.toLowerCase()
    let vowels = ["a","e","i","o","u","y"]
    for(i=0; i<word.length; i++)
        for(j in vowels)
            if (word[i]==vowels[j]) {++count; break;}
    return count;
}
//Problem 4
function removeScript(string){
    while(string.includes("Script",0)){
        string = string.replace("Script","");
    }
    return string;
}
//Problem 5
function isLeapYear(date){
    let year = date.getFullYear();
    if(year%4 == 0){
        if(year%100 == 0){
            if(year%400==0){
                return true;
            }
            else{ return false;}
        }
        else{
            return true;
        }
    }
    else{
        return false;
    }
}
//Problem 6
function isValidEmail(string){
    return /@/.test(string);
}
//Problem 7
function removeChar(string, index){
    let newString = "";
    for (i=0; i<string.length; i++){
        if(i==index)
            continue;
        newString+=string[i];
    }
    return newString;
}
//Problem 8
function bubbleSort(numArray){
    let temp;
    let notSorted = true;
    while(notSorted){ 
        notSorted = false;
        for(i=0; i<numArray.length; i++)
            if(numArray[i]>numArray[i+1]){
                temp = numArray[i];
                numArray[i] = numArray[i+1];// I really thought JS would have had a swap function...
                numArray[i+1] = temp;       // there is a fancier way of doing this but, it takes away from read-ability.
                notSorted =true;
            }
    }
    return numArray;
}
//Problem 9
function isPalindrome(someStr){
    someStr.trim()
    someStr.toLowerCase; // cleaning for cases like Racecar and race car
    if(someStr == String(reverseArray(Array(someStr))))// witchcraft at its finest
        return true;
    else return false;
}
//Problem 10
function printShape(shape, height, character){
    // if(height !== Number){
    //     console.log("Number input invalid!")// i didnt, the character is passed to you, you dont have to define it
    //     return;
    // }
    // if(character !== String)
    // {
    //     console.log("Character input invalid!")
    //     return;
    // }
    shape = shape.toLowerCase();
    let output = ""
    switch(shape){
        case "square":
            for(i=0; i<height; i++){ //outer for loop is responsible for deciding when it is a newline
                for(j=0; j<height; j++) // inner loop for drawing the contents of each line
                    output += character;
                output += "\n" ;
            }
            break;
        
        case "triangle":
            for(i=0; i<height; i++){
                for(j=-1; j<i; j++)
                output += character;
            output += "\n"
            }
            break;

        case "diamond": 
            let numSpaces = Math.floor(height/2);
            let space = " ";
            let middle = character.repeat(height)+"\n";
            for(i=0; i<numSpaces; i++){
                output += space.repeat(numSpaces - i) + (character.repeat((i*2)+1)) + space.repeat(numSpaces - i) + "\n";
            }
            output += middle;
            for(i=numSpaces-1; i>=0; i--){
                output += space.repeat(numSpaces - i) + (character.repeat((i*2)+1)) + space.repeat(numSpaces - i) + "\n";
            }
            break;
        default:
        console.log("Shape parameter was an unexpected input!");
    }
    console.log(output); 
    


}
//problem 11
function rotate(array, n){
    for (j=0; j< n%5; j++){
        var izero = array[0]
        for(i=0; i<array.length; i++){
            if(i==array.length-1){
                array[i] = izero;
                break;
            }
            array[i] = array[i+1];
        }
    }
    return array;
}
// let a = [1,2,3,4,5]
// console.log(rotate(a,3)); // because of pointer arithmatic these will not produce the 
// console.log(rotate(a,8));// same output
//problem 12
// this took longer than I expected
