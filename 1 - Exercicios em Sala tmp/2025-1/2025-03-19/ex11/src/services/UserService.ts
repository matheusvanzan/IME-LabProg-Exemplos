import { User } from '../models/User.js'

export function criarUsuario(user_data: User): User {

    if (user_data.id != null) {
        throw Error('Usuario ja existe')
    }

    // simulacao da consulta a API (fetch)
    // POST para API
    const id_ret: number = 23

    const return_user: User = {
        id: id_ret,
        nome: user_data.nome, 
        email: user_data.email
    }
    return return_user
}