// Higher-order functions examples in JavaScript

// 1. map() - Transforms each element of the array
console.log('1 ---');
var numbers = [1, 2, 3, 4, 5];
var doubled = numbers.map((n, index, a) => {
    console.log(n, index, a, this);
    return n * 2;
}, this);
console.log(doubled); // [2, 4, 6, 8, 10]

// 2. filter() - Filters elements based on a condition
console.log('2 ---');
var numbers = [1, 2, 3, 4, 5];
var evenNumbers = numbers.filter(n => n % 2 === 0);
console.log(evenNumbers); // [2, 4]

// 3. reduce() - Reduces the array to a single value
console.log('3 ---');
var numbers = [1, 2, 3, 4, 5];
var sum = numbers.reduce((acc, number) => acc + number, 0); // Starts at 0
console.log(sum); // 15

var mixedArray = ["Hello", "World"];
var result = mixedArray.reduce((acc, str) => acc + " " + str);
console.log(result); // ✅ "Hello World"

var sum2 = numbers.reduce((acc, number) => acc + number);
console.log(sum);

// 4. forEach() - Iterates over each element (no return value)
console.log('4 ---');
var numbers = [1, 2, 3, 4, 5];
numbers.forEach(n => console.log(n * 2)); // Output: 2, 4, 6, 8, 10

// 5. find() - Returns the first element that meets a condition
console.log('5 ---');
var numbers = [1, 2, 3, 4, 5];
var firstEven = numbers.find(n => n % 2 === 0);
console.log(firstEven); // 2

// 6. some() - Checks if at least one element satisfies the condition
console.log('6 ---');
var numbers = [1, 2, 3, 4, 5];
var hasEven = numbers.some(n => n % 2 === 0);
console.log(hasEven); // true

// 7. every() - Checks if all elements satisfy the condition
console.log('7 ---');
var numbers = [1, 2, 3, 4, 5];
var allEven = numbers.every(n => n % 2 === 0);
console.log(allEven); // false

// 8. sort() - Sorts the array (modifies original array)
console.log('8 ---');
var numbers = [5, 2, 8, 1, 4];
numbers.sort((a, b) => a - b); // Ascending order
console.log(numbers); // [1, 2, 4, 5, 8]

numbers.sort((a, b) => b - a); // Descending order
console.log(numbers); // [8, 5, 4, 2, 1]

var names = ["Álvaro", "Érika", "José", "Carlos", "Ana"];
names.sort();
console.log(names); // [ 'Ana', 'Carlos', 'José', 'Álvaro', 'Érika' ]
names.sort((a, b) => a.localeCompare(b, 'pt-BR')); // Ordenação correta em português
console.log(names); // Output: ["Ana", "Álvaro", "Carlos", "Érika", "José"]

// 9. flatMap() - Maps and flattens the array by one level
console.log('9 ---');
var sentences = ["Hello world", "Learning JavaScript"];
var words = sentences.flatMap(sentence => sentence.split(" "));
console.log(words); // ["Hello", "world", "Learning", "JavaScript"]

var mapped = words.map(sentence => sentence.split(" "));
console.log(mapped);
// Output: [["Hello", "world"], ["JavaScript", "is", "great"]]

var flatMapped = words.flatMap(sentence => sentence.split(" "));
console.log(flatMapped);
// Output: ["Hello", "world", "JavaScript", "is", "great"]
