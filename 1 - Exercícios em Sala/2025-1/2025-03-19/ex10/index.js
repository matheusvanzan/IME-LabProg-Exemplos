"use strict";
class Ponto {
    constructor(xAux, yAux) {
        this.x = xAux;
        this.y = yAux;
    }
    imprimir() {
        console.log(`Ponto <${this.x}, ${this.y}>`);
    }
    distancia(outro_ponto) {
        const dx = this.x - outro_ponto.x;
        const dy = this.y - outro_ponto.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
const p1 = new Ponto(1, 2);
p1.imprimir();
const p2 = new Ponto(3, 4);
const n = p2.distancia(p1);
console.log(n);
