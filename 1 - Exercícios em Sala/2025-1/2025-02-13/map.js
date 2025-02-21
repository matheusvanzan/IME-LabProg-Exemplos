var users = [
    {'name': 'user1', 'age': 31},
    {'name': 'user2', 'age': 29},
    {'name': 'user3', 'age': 33},
];

var ages = users.map((user) => {
    console.log(user.name);
    return user.age;
});

console.log(ages);
users.sort((user1, user2) => user1.age - user2.age);
console.log(users);

var names = ["Álvaro", "Érika", "José", "Carlos", "Ana"];
names.sort();
console.log(names);

names.sort((a, b) => a.localeCompare(b, 'pt-BR'));
console.log(names);

names.sort((s1, s2) => s1.length - s2.length);
console.log(names);

console.log('---');

var sentences = ["Hello world", "Learning JavaScript"];
var splits = sentences.flatMap(s => s.split(' '));
console.log(splits);