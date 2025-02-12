var products = [
    { name: "Laptop", price: 3000, quantity: 5 },
    { name: "Mouse", price: 50, quantity: 0 },
    { name: "Keyboard", price: 100, quantity: 2 },
    { name: "Monitor", price: 700, quantity: 0 },
    { name: "Headset", price: 150, quantity: 3 }
];

// Implement your function here
function availableProducts(products) {
    return products.filter(p => p.quantity > 0)
}

console.log(availableProducts(products));
// Expected output: Array with only products that have quantity > 0
