var users = [
    "Alice Johnson",
    "Bob Marley",
    "Charlie Brown",
    "David Smith"
];

const usernames = users.map( u => u.toLowerCase().replace(' ', '_') );

console.log(usernames);