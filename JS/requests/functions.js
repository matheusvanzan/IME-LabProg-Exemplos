API = "https://reqres.in/api/users";

function clear() {
    var resultDiv = document.getElementById("result");
    resultDiv.innerHTML = "";  // Clear any existing content
}

document.getElementById("load-js").addEventListener("click", function() {
    clear();
    console.log("Loading data using vanilla JS");

    fetch(API)
    .then(response => response.json())
    .then(data => {
        createUserCards(data.data); // Use the function here
    })
    .catch(error => console.error('Error:', error));
});

$("#load-jq").click(function() {
    clear();
    console.log("Loading data using JQuery");

    $.ajax({
        url: API,
        method: "GET",
        success: function(data) {
            console.log(data);
            createUserCardsJQ(data.data); // Use the function here
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
});


function createUserCards(users) {
    users.forEach(function(user) {
        // Create a new div for the user
        var userDiv = document.createElement("div");
        userDiv.className = "user";

        // Create an image element for the user's avatar
        var avatar = document.createElement("img");
        avatar.src = user.avatar;
        avatar.alt = user.first_name;

        // Create a paragraph for the user's name
        var name = document.createElement("p");
        name.textContent = `Name: ${user.first_name} ${user.last_name}`;

        // Create a paragraph for the user's email
        var email = document.createElement("p");
        email.textContent = `Email: ${user.email}`;

        // Append the avatar, name, and email to the userDiv
        userDiv.appendChild(avatar);
        userDiv.appendChild(name);
        userDiv.appendChild(email);

        // Append the userDiv to the resultDiv
        var resultDiv = document.getElementById("result");
        resultDiv.appendChild(userDiv);
    });
}


function createUserCardsJQ(users) {

    users.forEach(function(user) {
        var userDiv = $('<div class="user"></div>');

        var avatar = $("<img>").attr("src", user.avatar).attr("alt", user.first_name);
        var name = $("<p></p>").text(`Name: ${user.first_name} ${user.last_name}`);
        var email = $("<p></p>").text(`Email: ${user.email}`);

        resultDiv = $('#result');
        userDiv.append(avatar, name, email);
        resultDiv.append(userDiv);
    });
}