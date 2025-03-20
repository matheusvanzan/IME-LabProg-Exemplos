let contadorId = 0;
export function criarUsuario(dados) {
    if (dados.id != null) {
        throw Error('Usuário já existe');
    }
    contadorId++;
    return {
        id: contadorId,
        nome: dados.nome,
        email: dados.email
    };
}
