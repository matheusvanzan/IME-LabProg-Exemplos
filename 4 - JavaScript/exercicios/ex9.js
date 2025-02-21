function login(email, password) {
    fetch("https://reqres.in/api/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ email, password })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Invalid credentials");
        }
        return response.json();
    })
    .then(data => {
        console.log("Login successful");
        console.log("Token:", data.token);
    })
    .catch(error => {
        console.error(error.message);
    });
}

// Testando login com credenciais corretas
login("eve.holt@reqres.in", "cityslicka"); //

// Testando login com credenciais incorretas
login("wrong@example.com", "wrongpassword");
