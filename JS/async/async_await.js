// var myFunction1 = async () => {
//     return "Hello 1";
// }

// var myFunction2 = () => {
//     return Promise.resolve("Hello 2");
// }



// ---

// var result1 = myFunction1();
// console.log(result1); // Promise { 'Hello 1' }

// var result2 = myFunction2();
// console.log(result2); // Promise { 'Hello 2' }

// ---

// myFunction1()
//     .then(result => console.log(result)) 
//     .catch(error => console.error(error));
//     // Hello 1

// myFunction2()
//     .then(result => console.log(result)) 
//     .catch(error => console.error(error));
//     // Hello 2

// ---

// var callMyFunction = async () => {
//     try {
//         var result = await myFunction1();
//         console.log(result); // Hello 1
//     }
//     catch (error) {
//         console.error(error);
//     }
// }

// callMyFunction();