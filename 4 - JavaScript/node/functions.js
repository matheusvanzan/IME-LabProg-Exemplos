// Arrow functions
// A mesma função de soma escrita de 3 formas diferentes.

// 1) Função "tradicional" (function)
function sum1(a, b) {
    // Corpo com return explícito
    return a + b;
}

// 2) Arrow function com "return implícito"
// Quando NÃO usamos chaves {}, a expressão é retornada automaticamente.
var sum2 = (a, b) => a + b;

// 3) Arrow function com chaves {}
// Quando usamos chaves {}, precisamos escrever o return.
var sum3 = (a, b) => {
    return a + b;
};

// Valores de teste
var a = 1;
var b = 2;

// Chamando as três funções: todas retornam a mesma coisa
console.log(`sum1(${a}, ${b}) = ${sum1(a, b)}`); // sum1(1, 2) = 3
console.log(`sum2(${a}, ${b}) = ${sum2(a, b)}`); // sum2(1, 2) = 3
console.log(`sum3(${a}, ${b}) = ${sum3(a, b)}`); // sum3(1, 2) = 3


// Function of function
// Exemplo de função sendo guardada em variável e passada como parâmetro.
// Isso é a base de HOF (High Order Functions): função que recebe/retorna função.

// Aqui a variável "sum" aponta para a função sum3.
// Ou seja: sum(a, b) vai executar sum3(a, b).
var sum = sum3;

// "sub" usa a função "sum" internamente para fazer subtração.
// Ideia: a - b  ==  a + (-b)
var sub = (a, b) => sum(a, -b);

// "calc" recebe uma operação (função) e executa essa operação.
// operation pode ser sum, sub, ou qualquer função no formato (a, b) => ...
var calc = (a, b, operation) => {
    return operation(a, b);
};

// Passando funções como argumento
console.log('calc sum', calc(a, b, sum)); // calc sum 3
console.log('calc sub', calc(a, b, sub)); // calc sub -1


// Callbacks
// Callback é uma função que você "entrega" para outra função chamar depois.

function myCallback() {
    console.log('Process finished');
}

// Função que simula um processo demorado.
// Ela recebe uma função (callback) e chama depois de 2 segundos.
function myLongProcess(callback) {
    console.log('Process started');
    
    // setTimeout agenda uma função para rodar depois de um tempo.
    setTimeout(() => {
        // Quando o "processo" termina, chamamos o callback.
        callback();
    }, 2000); // 2000 ms = 2 segundos
}

// Passamos myCallback como parâmetro (não executamos aqui, só passamos a referência)
myLongProcess(myCallback);


// Arrays
// Exemplo de função que percorre um array e cria um novo array com valores dobrados.

var numbers = [1, 2, 3, 4, 5];

// "double" recebe um array e devolve um novo array
// com cada elemento multiplicado por 2.
var double = (array) => {
    // Criamos um array vazio para guardar o resultado
    var returnArray = [];

    // Loop clássico: i vai de 0 até array.length - 1
    for (var i = 0; i < array.length; i++) {
        // Pegamos o elemento atual e dobramos
        returnArray.push(2 * array[i]);
    }

    // Retornamos o novo array (não alteramos o original)
    return returnArray;
};

console.log(double(numbers)); // [ 2, 4, 6, 8, 10 ]

console.log();