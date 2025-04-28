import { Component, computed, Signal, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-main',
  imports: [FormsModule], // 👈 ngModel!
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {
  count: number = 0
  a: number = 0
  b: number = 0

  c() {
    return this.a + this.b
  }

  users = [
    {id: 1, name: 'User 1'},
    {id: 2, name: 'User 2'},
    {id: 3, name: 'User 3'},
  ]

  increment() {
    this.count += 1
  }

  decrement() {
    this.count -= 1
  }

  setCount(event: Event) {
    const input = event.target as HTMLInputElement;
    this.count = +input.value; // converte string para número
  }

  disabled() {
    return this.count % 2 == 0
  }
  
}
