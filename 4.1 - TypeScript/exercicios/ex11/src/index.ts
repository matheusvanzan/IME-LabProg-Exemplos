import { Usuario } from "./Usuario.js"
import { criarUsuario } from "./UsuarioService.js"

const dadosUsuario: Usuario = { id:null, nome: "Maria", email: "maria@teste.com" }
const novoUsuario = criarUsuario(dadosUsuario)

console.log("Usuário criado:", novoUsuario)
