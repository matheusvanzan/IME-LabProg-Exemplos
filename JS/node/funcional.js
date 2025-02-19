// Paradigma Imperativo

var numbers = [1, 2, 3, 4, 5];
var doubled = [];

for (let i = 0; i < numbers.length; i++) {
  doubled.push(numbers[i] * 2);
}

console.log(doubled); // [2, 4, 6, 8, 10]


// Paradigma Declarativo

var numbers = [1, 2, 3, 4, 5];
var doubled = numbers.map(n => n * 2);

console.log(doubled); // [2, 4, 6, 8, 10]
