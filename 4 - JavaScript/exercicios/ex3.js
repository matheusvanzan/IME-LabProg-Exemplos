var users = [
    "Alice Johnson", 
    "Bob Marley", 
    "Charlie Brown", 
    "David Smith"
];

function generateUsernames(users) {
    return users.map(user => user.toLowerCase().replace(/ /g, "_"));
}

console.log(generateUsernames(users));
// Expected output: ["alice_johnson", "bob_marley", "charlie_brown", "david_smith"]
