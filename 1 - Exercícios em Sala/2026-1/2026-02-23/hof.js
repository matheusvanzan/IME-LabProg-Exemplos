function sum1(a, b) {
    a = 2*a;
    return a + b;
}

console.log(sum1(1, 3));

const sum2 = (a, b) => {
    a = 2*a;
    return a+b;
};

console.log(sum2(1, 3));





const sum = (a, b) => a + b;
const sub = (a, b) => a - b;


const calc = (a, b, op) => {
    console.log(op);

    return op(a, b);
}

console.log(calc(1, 4, sum));


const funcTimeout = () => console.log('funcTimeout');

const longProcess = (myCallback) => {
    // executar os processos longos
    // Ex: chamadas a API
    console.log('A');
    // setTimeout(myCallback, 5000);
    console.log('B');
}

longProcess(funcTimeout);



// HOF

// map

const numbers = [1, 2, 3, 4, 5];
const double = numbers.map(n => {
    return 2*n
});

var products = [
    { name: 'Café', price: 10 },
    { name: 'Pão', price: 5 },
    { name: 'Leite', price: 8 }
];

// Quero [10, 5, 8]

const prices = products.map(p => p.price);
console.log(prices);

// filter()

// quero só os pares
numbers.filter(n => !n%2);


// reduce
const soma = numbers.reduce( (acc, n) => acc + n , 0);
console.log(soma);

var cart = [
    { name: 'Café', price: 10, qty: 2 },
    { name: 'Pão', price: 5, qty: 3 }
];

// Quero valor total
const total = cart.reduce( (acc, item) => acc + item.price * item.qty, 0);
console.log(total);

// for Each


// find
const firstEven = numbers.find(n => n%2 === 0);
console.log(firstEven);

var users = [
    { id: 10, name: 'Ana' },
    { id: 11, name: 'Carlos' }
];

// quero usuario id = 11
const user = users.find(u => u.id === 11);
console.log(user);


// sort

var invoices = [
    { id: 1, total: 120.5 },
    { id: 2, total: 30.0 },
    { id: 3, total: 78.9 }
];

// ordernar por total
invoices.sort((i1, i2) => i1.total - i2.total);

// flatMap

var posts = [
    { id: 1, tags: ['js', 'web'] },
    { id: 2, tags: ['js', 'node'] },
    { id: 3, tags: ['web'] }
];

// quero listar todas as tags
const allTags = posts.flatMap(p => p.tags);
console.log(allTags);