COUNT_FIB_1 = 0;
COUNT_FIB_2 = 0;
COUNT_FIB_3 = 0;

FIB_CACHE_2 = [1, 1]; // new Array();
FIB_CACHE_3 = { 0:1, 1:1 }; // JSON


function fib(x) {
    COUNT_FIB_1 += 1;

    if (x === 0 || x === 1) {
        return 1;
    } else {
        return fib(x-1) + fib(x-2);
    }
}

function fib2(x) {

    if (FIB_CACHE_2.length > x) {
        return FIB_CACHE_2[x];
    }    

    COUNT_FIB_2 += 1;
    var result = fib2(x-1) + fib2(x-2);
    FIB_CACHE_2[x] = result;
    return result;
}

function fib3(x) {

    if (FIB_CACHE_3.hasOwnProperty(x)) {
        return FIB_CACHE_3[x];
    }    

    COUNT_FIB_3 += 1;
    var result = fib3(x-1) + fib3(x-2);
    FIB_CACHE_3[x] = result;
    return result;
}

var n = 10;

console.log('fib(10) =', fib(n));
console.log('fib2(10) =', fib2(n));
console.log('fib3(10) =', fib3(n));

console.log('COUNT_FIB_1', COUNT_FIB_1);
console.log('COUNT_FIB_2', COUNT_FIB_2);
console.log('COUNT_FIB_3', COUNT_FIB_3);

console.log('FIB_CACHE_2', FIB_CACHE_2);
console.log('FIB_CACHE_3', FIB_CACHE_3);