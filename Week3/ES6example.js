// {
//     var x = 2;
//      you can obviously see x here....
// }
// //you can see x here

// variables declared with the var keyword can not have block scope
// variables declared inside a block {} can be accessed from the outside block


///========================LET=================
// the keyword 'let' allows for block scoping
// {
//     let x = 5;
//     //can we see x here? yes, we can. obviously....
    
// }
// can we see x here??
// x is not defined outside of the {} because it was declared using the let
//keyword and it has block scope


// var x = 10;
// //x=10
// {
//     var x =2;
//     //x=2
// }
// //x=2
// //x is equal to 2 because the var keyword was used and the value of x was reassigned

// var x = 10;
// //x = 10
// {
//     let x = 2;
//     //x = 2
// }
//x=10, because of the global scope x that has a value of 10

// var x = 10;
// {
//     const x = 2;
//     // x = 2
// }
// //x=10, because const only makes 2 immutable in the block scope

var x = 10;
{
    const x = 2;
    {
        let x = 99;
        //x=99
        // let x = 22;
        // if you try to redeclare x using the 'let' keyword in the same block
        // you get an error
        // we can use let to redeclare the varible x in this particular scope,
        //but we may not reassign the value of x without declaring, because
        // it was declared as const in the higher scope.
    }
    // x = 2
}
//x=10, because const only makes 2 immutable in the block scope