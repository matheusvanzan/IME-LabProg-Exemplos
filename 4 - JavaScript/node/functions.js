// Arrow functions

function sum1(a, b) {
    return a + b;
}

var sum2 = (a, b) => a + b;

var sum3 = (a, b) => {
    return a + b;
}


var a = 1;
var b = 2;

console.log(`sum1(${a}, ${b}) = ${sum1(a, b)}`); // sum1(1, 2) = 3
console.log(`sum2(${a}, ${b}) = ${sum2(a, b)}`); // sum2(1, 2) = 3
console.log(`sum3(${a}, ${b}) = ${sum3(a, b)}`); // sum3(1, 2) = 3

// Function of function

var sum = sum3;
var sub = (a, b) => sum(a, -b);

var calc = (a, b, operation) => {
    return operation(a, b);
}

console.log('calc sum', calc(a, b, sum)); // calc sum 3
console.log('calc sub', calc(a, b, sub)); // calc sub -1


// Callbacks

function myCallback() {
    console.log('Process finished');
}

function myLongProcess(callback) {
    console.log('Process started');
    
    setTimeout(() => {
        callback();
    }, 2000); // 2 seg
}

myLongProcess(myCallback);


// Arrays

var numbers = [1, 2, 3, 4, 5];

var double = (array) => {
    var returnArray = [];

    for (var i = 0; i < array.length; i++) {
        returnArray.push(2*array[i]);
    }
    return returnArray;
}

console.log(double(numbers)); // [ 2, 4, 6, 8, 10 ]

console.log()

