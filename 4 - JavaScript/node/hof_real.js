// Higher-order functions examples in JavaScript
// Ideia principal: você passa uma função (callback) para outra função (map/filter/reduce/etc).

// 1. map() - Transforma cada elemento e devolve um NOVO array (mesmo tamanho)
console.log('1 --- map()');
var products = [
    { name: 'Café', price: 10 },
    { name: 'Pão', price: 5 },
    { name: 'Leite', price: 8 }
];

// Mundo real: pegar só os preços para fazer cálculos depois
var prices = products.map(p => p.price);
console.log(prices); // [10, 5, 8]

// Mundo real: criar uma versão "formatada" para exibir na UI
var productLabels = products.map(p => `${p.name}: R$ ${p.price}`);
console.log(productLabels); // ['Café: R$ 10', 'Pão: R$ 5', 'Leite: R$ 8']


// 2. filter() - Seleciona elementos com base em uma condição (pode diminuir o array)
console.log('2 --- filter()');
var orders = [
    { id: 1, status: 'paid' },
    { id: 2, status: 'pending' },
    { id: 3, status: 'paid' }
];

// Mundo real: pegar só pedidos pagos
var paidOrders = orders.filter(o => o.status === 'paid');
console.log(paidOrders); // [{id: 1,...}, {id: 3,...}]


// 3. reduce() - Reduz o array para UM valor (número, string, objeto, etc.)
console.log('3 --- reduce()');
var cart = [
    { name: 'Café', price: 10, qty: 2 },
    { name: 'Pão', price: 5, qty: 3 }
];

// Mundo real: calcular total do carrinho
var total = cart.reduce((acc, item) => acc + item.price * item.qty, 0);
console.log(total); // 35

// Mundo real: agrupar quantidade por produto (gera um objeto)
var qtyByName = cart.reduce((acc, item) => {
    acc[item.name] = (acc[item.name] || 0) + item.qty;
    return acc;
}, {});
console.log(qtyByName); // { 'Café': 2, 'Pão': 3 }


// 4. forEach() - Percorre cada elemento, mas NÃO devolve um array novo
console.log('4 --- forEach()');
var emails = ['a@x.com', 'b@x.com', 'c@x.com'];

// Mundo real: simular envio de e-mail (efeito colateral)
emails.forEach(email => {
    console.log('enviando email para', email);
});


// 5. find() - Retorna o PRIMEIRO elemento que satisfaz a condição (ou undefined)
console.log('5 --- find()');
var users = [
    { id: 10, name: 'Ana' },
    { id: 11, name: 'Carlos' }
];

// Mundo real: achar usuário pelo id
var user = users.find(u => u.id === 11);
console.log(user); // { id: 11, name: 'Carlos' }


// 6. some() - true se PELO MENOS UM elemento satisfaz a condição
console.log('6 --- some()');
var uploadFiles = [
    { name: 'a.png', sizeMb: 2 },
    { name: 'b.mp4', sizeMb: 120 }
];

// Mundo real: validar se tem arquivo acima do limite
var hasTooLargeFile = uploadFiles.some(f => f.sizeMb > 50);
console.log(hasTooLargeFile); // true


// 7. every() - true se TODOS os elementos satisfazem a condição
console.log('7 --- every()');
var formFields = [
    { field: 'name', valid: true },
    { field: 'email', valid: true },
    { field: 'cpf', valid: false }
];

// Mundo real: só libera submit se tudo estiver válido
var canSubmit = formFields.every(f => f.valid === true);
console.log(canSubmit); // false


// 8. sort() - Ordena o array (MODIFICA o original)
console.log('8 --- sort()');
var invoices = [
    { id: 1, total: 120.5 },
    { id: 2, total: 30.0 },
    { id: 3, total: 78.9 }
];

// Mundo real: ordenar por total (crescente)
invoices.sort((a, b) => a.total - b.total);
console.log(invoices);

// Mundo real: ordenar por total (decrescente)
invoices.sort((a, b) => b.total - a.total);
console.log(invoices);


// 9. flatMap() - Faz map + "achata" 1 nível
console.log('9 --- flatMap()');
var posts = [
    { id: 1, tags: ['js', 'web'] },
    { id: 2, tags: ['js', 'node'] },
    { id: 3, tags: ['web'] }
];

// Mundo real: extrair todas as tags em uma lista única (com repetição)
var allTags = posts.flatMap(p => p.tags);
console.log(allTags); // ['js', 'web', 'js', 'node', 'web']

// Mundo real: se quiser sem repetição, combina com Set
var uniqueTags = [...new Set(allTags)];
console.log(uniqueTags); // ['js', 'web', 'node']