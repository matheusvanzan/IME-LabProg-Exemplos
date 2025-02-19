from flask import Flask, request, jsonify
from flask_cors import CORS

app = Flask(__name__)
CORS(app)  # Habilita CORS para todas as origens

@app.route('/login', methods=['POST'])
def login():
    data = request.json  # Obtém os dados enviados no POST
    print("Recebido:", data)  # Exibe no terminal os dados recebidos

    email = data.get("email")
    password = data.get("password")

    # Verifica apenas a senha
    if password == "mypassword":
        user_data = {
            "id": 1,
            "name": "User",
            "email": email  # Mantém o e-mail fornecido pelo aluno
        }
        return jsonify({"message": "Login successful", "user": user_data}), 200
    else:
        return jsonify({"message": "Invalid credentials"}), 401

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)  # Permite conexões externas
