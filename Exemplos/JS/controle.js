
// Estrutura condicional

if (a % 2 == 0) {
    consosle.log('a é par');
}

if (a % 2 == 0) {
    consosle.log('a é par');
} else {
    console.log('a é impar')
}


// Operadores ternários
// a = [teste relacional]?[valor verdadeiro]:[valor falso]

b = a % 2 == 0 ? a/2 : a



// Estrutura condicional

switch(a % 3) {
	case 0: 
		console.log('');
		break;
	
	case 1: 
		console.log('');
		break;
	
	case 2: 
		console.log('');
		break;
	
	default: 
		console.log('default');
}


// Estruturas de repetição

while (i < 10) {
    console.log(i);
    i++;
}

do {
    console.log(i);
    i++;
} while(i < 10);

for (var i=0; i < lista.length; i+=1) {
    console.log(i);
}


// Declaração de funções

function nome(parâmetros){
    bloco;
}

function quadrado(x) {
    return x*x;
}
