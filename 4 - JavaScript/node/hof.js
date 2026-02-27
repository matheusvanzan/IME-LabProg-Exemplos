// Higher-order functions examples in JavaScript
// Ideia principal: você passa uma função (callback) para outra função (map/filter/reduce/etc).

// 1. map() - Transforma cada elemento e devolve um NOVO array (mesmo tamanho)
console.log('1 ---');
var numbers = [1, 2, 3, 4, 5];

// map(callback, thisArg)
// callback recebe: (elemento, indice, arrayOriginal)
// thisArg define o valor de "this" dentro do callback (muito raro hoje em dia)
var doubled = numbers.map((n, index, a) => {
    // Só para visualizar o que o map entrega para o callback
    console.log('n =', n, 'index =', index, 'array =', a, 'this =', this);

    // O valor retornado aqui vira o novo elemento do array resultante
    return n * 2;
}, this);

console.log(doubled); // [2, 4, 6, 8, 10]


// 2. filter() - Seleciona elementos com base em uma condição (pode diminuir o array)
console.log('2 ---');
var numbers = [1, 2, 3, 4, 5];

// Mantém só os números pares (condição true)
var evenNumbers = numbers.filter(n => n % 2 === 0);
console.log(evenNumbers); // [2, 4]


// 3. reduce() - Reduz o array para UM valor (número, string, objeto, etc.)
console.log('3 ---');
var numbers = [1, 2, 3, 4, 5];

// reduce(callback, valorInicial)
// callback recebe: (acumulador, elementoAtual)
// valorInicial = 0 faz o acumulador começar em 0
var sum = numbers.reduce((acc, number) => acc + number, 0);
console.log(sum); // 15

// Exemplo com strings: sem valorInicial, o acc começa como o primeiro elemento do array
var mixedArray = ['Hello', 'World'];
var result = mixedArray.reduce((acc, str) => acc + ' ' + str);
console.log(result); // "Hello World"

// Aqui também não tem valorInicial
// acc começa em 1, depois soma 2, depois 3, ...
var sum2 = numbers.reduce((acc, number) => acc + number);

// Atenção: aqui o console.log está imprimindo "sum", não "sum2"
console.log(sum); // 15


// 4. forEach() - Percorre cada elemento, mas NÃO devolve um array novo
console.log('4 ---');
var numbers = [1, 2, 3, 4, 5];

// Útil para efeitos colaterais: log, atualizar tela, etc.
numbers.forEach(n => console.log(n * 2)); // 2, 4, 6, 8, 10


// 5. find() - Retorna o PRIMEIRO elemento que satisfaz a condição (ou undefined)
console.log('5 ---');
var numbers = [1, 2, 3, 4, 5];

var firstEven = numbers.find(n => n % 2 === 0);
console.log(firstEven); // 2


// 6. some() - Retorna true se PELO MENOS UM elemento satisfaz a condição
console.log('6 ---');
var numbers = [1, 2, 3, 4, 5];

var hasEven = numbers.some(n => n % 2 === 0);
console.log(hasEven); // true


// 7. every() - Retorna true se TODOS os elementos satisfazem a condição
console.log('7 ---');
var numbers = [1, 2, 3, 4, 5];

var allEven = numbers.every(n => n % 2 === 0);
console.log(allEven); // false


// 8. sort() - Ordena o array (MODIFICA o array original)
console.log('8 ---');
var numbers = [5, 2, 8, 1, 4];

// Para números, sempre passe um comparador (senão vira ordenação por string)
numbers.sort((a, b) => a - b); // crescente
console.log(numbers); // [1, 2, 4, 5, 8]

// Repare que é o MESMO array sendo reordenado
numbers.sort((a, b) => b - a); // decrescente
console.log(numbers); // [8, 5, 4, 2, 1]

// Strings: sort() padrão ordena por ordem Unicode (pode dar resultado estranho com acentos)
var names = ['Álvaro', 'Érika', 'José', 'Carlos', 'Ana'];

names.sort();
console.log(names); // pode ficar com acentos em ordem inesperada

// localeCompare com 'pt-BR' faz ordenação adequada para português
names.sort((a, b) => a.localeCompare(b, 'pt-BR'));
console.log(names); // ['Ana', 'Álvaro', 'Carlos', 'Érika', 'José']


// 9. flatMap() - Faz map + "achata" (flatten) 1 nível
console.log('9 ---');

// Exemplo correto: cada frase vira uma lista de palavras
var sentences = ['Hello world', 'Learning JavaScript'];

// split(' ') transforma uma string em array de palavras
// flatMap já junta tudo em um array só
var words = sentences.flatMap(sentence => sentence.split(' '));
console.log(words); // ['Hello', 'world', 'Learning', 'JavaScript']

// Diferença map vs flatMap:
// map gera um array de arrays (2 níveis)
var mapped = sentences.map(sentence => sentence.split(' '));
console.log(mapped); // [['Hello', 'world'], ['Learning', 'JavaScript']]

// flatMap remove 1 nível de array
var flatMapped = sentences.flatMap(sentence => sentence.split(' '));
console.log(flatMapped); // ['Hello', 'world', 'Learning', 'JavaScript']