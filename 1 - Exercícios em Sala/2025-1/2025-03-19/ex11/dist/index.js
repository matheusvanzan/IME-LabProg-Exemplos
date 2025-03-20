import { criarUsuario } from './services/UserService.js';
const u = { id: null, nome: 'Matheus', email: 'vanzna@ime.eb.br' }; // simulacao de dado da UI
const return_user = criarUsuario(u);
console.log(return_user);
