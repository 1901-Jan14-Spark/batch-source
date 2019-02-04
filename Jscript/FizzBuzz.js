// //Write funciton that prints numbers 1 to 100 where multiples of 3 print Fizz, multiples of 5 prints Buzz, and multiples of 3 and 5 prints FizzBuzz.
// let i = 1;
// for(i; i<101;i++){
//    if(i%15==0)    {console.log("FizzBuzz");}
//    else if(i%3==0){console.log("Fizz");}
//    else if(i%5==0){console.log("Buzz");}
//    else {console.log(i)}

// }


// function recursivelyCalculateExponentials(base, exp){
//     if(exp == 1){
//         return base;
//     }
//     return base*recursivelyCalculateExponentials(base,(exp-1)); 
// }

// let pow = recursivelyCalculateExponentials(10,4);
// console.log(pow);
// function maxLength(array){
//     let longest = ""
//     for(i in array ){
//         if(array[i].length > longest.length){
//             longest = array[i];
//         }

//     }    
//     console.log(longest);
// }
// var x = ["string", "baseball", "abracadabra", "supercalifragilisticexpialidocious", "mvenslop"]
// maxLength(x);


// function reverseArray(array){
    
//    x= array.reverse(y)
//    console.log(x)
// }
// var y = [1, 2, 3, 4, 5]
// reverseArray(y)

// function vowelCount(string){
// let x = ["a",  "e" , "i" , "o", "u", "y"]
// let z = 0
// for(i in string)
//     for(j in x)
//     if(string[i]==x[j])
//             z++
// return z
// }   let y = "supercalifragilisticexpialidociousy"
// let count = vowelCount(y)
// console.log(count)


// // remove script

// function removeScript(stringy){
// let x = "Script"
// let z = ""
// stringy = stringy.replace("Script", z);
//   return stringy
// }
// let y = "This is a Script dog."
// let r = removeScript(y)
// console.log(r)


// function isLeapYear(date)

// {
// return ((date%4==0)&&(date%100!=0))||(date%400==0);
// console.log("Lear")

// function isValidEmail(string){
// let g = "lowellmparker@gmail.com"
// var seq = /\W@/ 
// seq=RegExp.test(g)
// console.log(g +"is a valid email")
// let x = isValidEmail(string)}



// Remove a specified character from a string
// function = removeChar(string, index){
// let x="lowellmparker"
// char = "m"
// let y= string.index("m")

// function bubblesort(array){
//     let sorted = false;                 //I need it to check again and stop
//     while(!sorted){sorted = true; 
//             for(i=0;i<array.length-1;i++){
//                 if(array[i]>array[i+1]){
//                 let T=array[i];
//             array[i] = array[i+1];
//         array[i+1]=T;
//     sorted = false; 
//             }
//         }
//     }
//     return array
// }


// var array=[1,10,15,3,54,67,34];

// console.log(bubblesort(array));
// function isPalindrome(somestr){
//     var normalized = this.toLowerCase().match(/[a-z]/gi).reverse();
//     return normalized.join('') === normalized.reverse().join('');
//     if("Go dog.".isPalindrome()){
//         console.log("Is Palindrome");
//     }else{
//         console.log("It's not Palindrome");
// }





function printShape(shape, height, char){
      switch(shape)
        {
            case square:
                for(i=0;i<i.height;i++){
                    for(j=0;j=i;j++){
                    console.log(char);
                                    }
                                               }               console.log(char);
}
}
