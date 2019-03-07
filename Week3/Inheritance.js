// in programming, we often want to take something and extend it
// 

// let animal = {
//     eats: true,
//     jumps:false
// }
// let rabbit = {
//     jumps: true
// }
//we want to make rabbit, inherit from animal
// rabbit.__proto__=animal;
// the conecept of inheritance occurring through prototypes in JS is referred to as
// "prototypal inheritance"

//so the way that this works, is that if you are looking for a property in rabbit
//but it is missing, you will get the property from animal, if it exists

// so if you were to try to find the 'eats' field in the rabbit. since it does not exist
// you will get the 'eats' field of the animal object
// if you try to get the 'jumps' field of the rabbit, you will get the value
// 'true' rather than 'false' because this field exists in the rabbit object


// let animal = {
//     eats:true,
//     walk:'animal walk'

// }

// let rabbit = {
//     jumps:true,
//     __proto__:animal
// }

// let longEar = {
//     earLength: 10,
//     __proto__: rabbit
// }

// console.log(longEar.walk)
// console.log(longEar.jumps)

// you can also chain the inheritance that is acheived through using the __proto__
//property
// you can do this indefinitely


//What is the limitation to prototypal inheritance?
//1) the references cannot go in circles
//2) the value of __proto__ can be either an object or null. other types (like primitves)
// are ignored
//3) you can only inherit from one entity