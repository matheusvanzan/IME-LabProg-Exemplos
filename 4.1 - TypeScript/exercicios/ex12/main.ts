// 1. Definição da classe Post
class Post {
    userId: number
    id: number
    title: string
    body: string
  
    constructor(userId: number, id: number, title: string, body: string) {
      this.userId = userId
      this.id = id
      this.title = title
      this.body = body
    }
  }
  
  // 2. Função assíncrona para obter posts da API
  async function obterPosts(): Promise<Post[]> {
    // Fazendo fetch para a API
    const resposta: Response = await fetch("https://jsonplaceholder.typicode.com/posts")
  
    // Verifica se o request foi bem-sucedido (opcional, mas recomendado)
    if (!resposta.ok) {
      throw new Error(`Erro na requisição. Status: ${resposta.status}`)
    }
  
    // Converte o resultado em JSON
    const dados = await resposta.json()
  
    // Mapeia cada item do array para a classe Post
    const posts: Post[] = dados.map((item: any) => {
      return new Post(item.userId, item.id, item.title, item.body)
    })
  
    return posts
  }
  
  // 3. Invocando obterPosts() e exibindo no console o título do primeiro post
  (async () => {
    try {
      const listaPosts = await obterPosts()
      if (listaPosts.length > 0) {
        console.log("Título do primeiro post:", listaPosts[0].title)
      } else {
        console.log("Nenhum post encontrado.")
      }
    } catch (erro) {
      console.error("Erro ao obter posts:", erro)
    }
  })()
  