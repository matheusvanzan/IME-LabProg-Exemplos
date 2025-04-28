import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { SomadorComponent } from './somador/somador.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule, SomadorComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  count = 0
  users = [
    {id: 1, name: 'User 1'},
    {id: 2, name: 'User 2'},
    {id: 3, name: 'User 3'},
  ]

  inc() {
    this.count += 1
  }

  setCount(event: Event) {
    const input = event.target as HTMLInputElement
    this.count = +input.value
  }
}
