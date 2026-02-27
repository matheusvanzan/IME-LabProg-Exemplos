fetch('https://jsonplaceholder.typicode.com/users/1')
    .then(resp => resp.json())
    .then(data => {
        console.log(data);
    });


