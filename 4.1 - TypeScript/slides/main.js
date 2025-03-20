"use strict";
// Objetos
let pessoa2 = {
    nome: "João",
    idade: 30
};
function processarResposta(resp) {
    if (resp.status === "ok") {
        console.log("Dados:", resp.data);
    }
    else {
        console.log("Erro:", resp.mensagem);
    }
}
const rectangle = {
    height: 20,
    width: 10
};
const login = (cred) => {
    if (cred.usuario === "admin" && cred.senha === "123") {
        return { sucesso: true, token: "abc123" };
    }
    else {
        return { sucesso: false };
    }
};
const resposta = login({ usuario: "admin", senha: "123" });
console.log(resposta);
// Casting
let valor = "Texto genérico";
let valorAsString = valor;
let valor2 = "Outro texto";
let valor2AsString = valor2;
console.log(valorAsString.toUpperCase());
console.log(valor2AsString.toUpperCase());
