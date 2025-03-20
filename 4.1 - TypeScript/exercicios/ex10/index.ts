class Ponto {
    // Atributos privados
    private x: number
    private y: number
  
    // Construtor para inicializar as coordenadas
    constructor(x: number, y: number) {
      this.x = x
      this.y = y
    }
  
    // Método para imprimir o ponto
    public imprimir(): void {
      console.log(`Ponto(${this.x}, ${this.y})`)
    }
  
    // Método para calcular o módulo (comprimento do vetor) do ponto
    public modulo(): number {
      return Math.sqrt(this.x * this.x + this.y * this.y)
    }
  
    // Método para calcular a distância entre este ponto e outro ponto
    public distancia(outro: Ponto): number {
      const dx = this.x - outro.x
      const dy = this.y - outro.y
      return Math.sqrt(dx * dx + dy * dy)
    }
  }
  
  // Exemplo de uso:
  const p1 = new Ponto(3, 4)
  const p2 = new Ponto(7, 1)
  
  p1.imprimir() // Ex: "Ponto(3, 4)"
  console.log("Módulo de p1:", p1.modulo()) // Ex: 5
  console.log("Distância entre p1 e p2:", p1.distancia(p2)) // Ex: 5
  