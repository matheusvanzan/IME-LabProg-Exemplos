import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-somador',
  imports: [FormsModule],
  templateUrl: './somador.component.html',
  styleUrl: './somador.component.css'
})
export class SomadorComponent {
  a: number = 0
  b: number = 0

  soma() {
    return this.a + this.b
  }
}
