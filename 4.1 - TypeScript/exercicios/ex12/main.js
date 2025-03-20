"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
// 1. Definição da classe Post
class Post {
    constructor(userId, id, title, body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
// 2. Função assíncrona para obter posts da API
function obterPosts() {
    return __awaiter(this, void 0, void 0, function* () {
        // Fazendo fetch para a API
        const resposta = yield fetch("https://jsonplaceholder.typicode.com/posts");
        // Verifica se o request foi bem-sucedido (opcional, mas recomendado)
        if (!resposta.ok) {
            throw new Error(`Erro na requisição. Status: ${resposta.status}`);
        }
        // Converte o resultado em JSON
        const dados = yield resposta.json();
        // Mapeia cada item do array para a classe Post
        const posts = dados.map((item) => {
            return new Post(item.userId, item.id, item.title, item.body);
        });
        return posts;
    });
}
// 3. Invocando obterPosts() e exibindo no console o título do primeiro post
(() => __awaiter(void 0, void 0, void 0, function* () {
    try {
        const listaPosts = yield obterPosts();
        if (listaPosts.length > 0) {
            console.log("Título do primeiro post:", listaPosts[0].title);
        }
        else {
            console.log("Nenhum post encontrado.");
        }
    }
    catch (erro) {
        console.error("Erro ao obter posts:", erro);
    }
}))();
