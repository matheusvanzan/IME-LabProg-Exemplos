async function login(email, password) {
    try {
        const response = await fetch("http://<SEU-IP>:5000/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ email, password })
        });

        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error("Error:", error);
    }
}

// Testando login com diferentes e-mails
login("student1@example.com", "mypassword"); // Deve aceitar
login("random@example.com", "mypassword");   // Deve aceitar
login("wrong@example.com", "wrongpassword"); // Deve rejeitar
