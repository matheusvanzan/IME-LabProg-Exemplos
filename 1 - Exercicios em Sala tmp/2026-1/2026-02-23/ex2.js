var orders = [
    { product: "Laptop", price: 3000, quantity: 1 },
    { product: "Mouse", price: 50, quantity: 3 },
    { product: "Keyboard", price: 100, quantity: 2 }
];

const total = orders.reduce((acc, order)=>acc+order.price*order.quantity);
console.log(total);