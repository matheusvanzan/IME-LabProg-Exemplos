// Objetos
let pessoa2: { nome: string; idade: number } = {
    nome: "João",
    idade: 30
  }

// Enum
// enum StatusCodes {
//     NotFound = 404,
//     Success = 200,
//     Accepted = 202,
//     BadRequest = 400
// }

// console.log(StatusCodes.NotFound) // logs 404
// console.log(StatusCodes.Success) // logs 200

// Alias
type Sucesso = {
    status: "ok"
    data: string
}

type Erro = {
    status: "erro"
    mensagem: string
}

type Resposta = Sucesso | Erro // Union Type

function processarResposta(resp: Resposta) {
    if (resp.status === "ok") {
        console.log("Dados:", resp.data)
    } else {
        console.log("Erro:", resp.mensagem)
    }
}


// Interfaces
interface Rectangle {
    height: number,
    width: number
}

const rectangle: Rectangle = {
    height: 20,
    width: 10
}

interface Credenciais { usuario: string; senha: string; }
type RespostaLogin = { sucesso: boolean; token?: string; }

const login = (cred: Credenciais): RespostaLogin => {
    if (cred.usuario === "admin" && cred.senha === "123") {
        return { sucesso: true, token: "abc123" }
    } else {
        return { sucesso: false }
    }
}

const resposta = login({ usuario: "admin", senha: "123" })
console.log(resposta)
 
// Casting

let valor: unknown = "Texto genérico"
let valorAsString = valor as string

let valor2: unknown = "Outro texto"
let valor2AsString = <string> valor2

console.log(valorAsString.toUpperCase())
console.log(valor2AsString.toUpperCase())

