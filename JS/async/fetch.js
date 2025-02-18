// var responsePromise = fetch('https://jsonplaceholder.typicode.com/users/1');

// console.log(typeof responsePromise); // object
// console.log(responsePromise instanceof Promise); // true
// console.log(responsePromise); // Promise { <pending> }

// ---

// var responsePromise = fetch('https://jsonplaceholder.typicode.com/users/1');

// responsePromise.then(response => {

//   console.log(response.status); // 200
//   console.log(response instanceof Promise); // false
//   console.log(response.json() instanceof Promise); // true
// });

// ---

// var responsePromise = fetch('https://jsonplaceholder.typicode.com/users/1');

// var jsonPromise = responsePromise
//     .then( response => response.json() );

// console.log(typeof jsonPromise); // object
// console.log(jsonPromise instanceof Promise); // true
// console.log(jsonPromise); // Promise { <pending> }

// ---

// var responsePromise = fetch('https://jsonplaceholder.typicode.com/users/1');

// var jsonPromise = responsePromise
//     .then( response => response.json() );

// jsonPromise.then(data => {
//     console.log(data); // {id: 1, name: 'Leanne Graham', ....}
// });

// ---

// fetch('https://jsonplaceholder.typicode.com/users/1')
//     .then( response => response.json() )
//     .then(data => {
//         console.log(data); // {id: 1, name: 'Leanne Graham', ....}
//     });

// ---

fetch('https://jsonplaceholder.typicode.com/users/1')
    .then(response => {
        if (!response.ok) {
            console.error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
    })
    .then(user => {
        console.log('User Data Retrieved', user);
        return user;
    })
    .catch(error => {
        console.error('Error fetching user data:', error);
    });