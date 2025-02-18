
var clearText = () => {
    document.getElementById('content').innerHTML = '';
}

var addText = (text) => {
    var contentDiv = document.getElementById('content');
    contentDiv.innerHTML += text + '<br>';
}


var listUsers = () => {

    // reset text
    clearText();
    addText('Loading...');

    fetch('https://jsonplaceholder.typicode.com/users/')
        .then(response => {
            if (!response.ok) {
                console.error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            console.log('User Data Retrieved', data);
            clearText();

            // addText(JSON.stringify(data)); // prints all

            data.forEach(user => {
                addText(user.id + ' - ' + user.name);
            });

            return data;
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });


}