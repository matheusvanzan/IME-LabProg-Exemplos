var orders = [
    { product: "Laptop", price: 3000, quantity: 1 },
    { product: "Mouse", price: 50, quantity: 3 },
    { product: "Keyboard", price: 100, quantity: 2 }
];

function calculateTotal(orders) {
    return orders.reduce((acc, order) => acc + (order.price * order.quantity), 0);
}

console.log(calculateTotal(orders)); 
// Expected output: Total cost of all items