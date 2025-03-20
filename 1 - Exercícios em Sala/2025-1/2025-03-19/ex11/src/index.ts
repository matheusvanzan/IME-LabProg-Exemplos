import { User } from "./models/User.js"
import { criarUsuario } from './services/UserService.js'

const u: User = {id: null, nome: 'Matheus', email: 'vanzna@ime.eb.br'} // simulacao de dado da UI

const return_user: User = criarUsuario(u)
console.log(return_user)