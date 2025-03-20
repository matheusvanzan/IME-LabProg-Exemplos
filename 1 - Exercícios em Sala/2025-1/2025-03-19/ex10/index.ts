class Ponto {
    private x: number
    private y: number

    constructor(xAux: number, yAux:number) {
        this.x = xAux
        this.y = yAux
    }

    public imprimir(): void {
        console.log(`Ponto <${this.x}, ${this.y}>`)
    }

    public distancia(outro_ponto: Ponto): number {
        const dx = this.x - outro_ponto.x
        const dy = this.y - outro_ponto.y
        return Math.sqrt(dx*dx + dy*dy)
    }
}

const p1: Ponto = new Ponto(1, 2)
p1.imprimir()

const p2: Ponto = new Ponto(3, 4)
const n: number = p2.distancia(p1)
console.log(n)