var orders = [
    { id: 1, customerName: "Alice", totalPrice: 120, status: "delivered" },
    { id: 2, customerName: "Bob", totalPrice: 200, status: "pending" },
    { id: 3, customerName: "Charlie", totalPrice: 450, status: "delivered" },
    { id: 4, customerName: "David", totalPrice: 300, status: "canceled" },
    { id: 5, customerName: "Eve", totalPrice: 150, status: "delivered" }
];

function processOrders(orders) {
    // Step 1: Filter only delivered orders
    var deliveredOrders = orders.filter(order => order.status === "delivered");

    // Step 2: Transform orders to contain only id, customerName, and totalPrice
    var formattedOrders = deliveredOrders.map(order => ({
        id: order.id,
        customerName: order.customerName,
        totalPrice: order.totalPrice
    }));

    // Step 3: Calculate total revenue
    var totalRevenue = formattedOrders.reduce((sum, order) => sum + order.totalPrice, 0);

    // Return the processed result
    return {
        deliveredOrders: formattedOrders,
        totalRevenue: totalRevenue
    };
}

console.log(processOrders(orders));
