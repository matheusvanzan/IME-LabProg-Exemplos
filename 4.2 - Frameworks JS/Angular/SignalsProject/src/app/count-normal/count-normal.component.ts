import { Component } from '@angular/core';

@Component({
  selector: 'app-count-normal',
  imports: [],
  templateUrl: './count-normal.component.html',
  styleUrl: './count-normal.component.css'
})
export class CountNormalComponent {  
  count: number = 0

  doubleCount(): number {
    console.log('[update] doubleCount')
    return 2 * this.count
  }

  increment(): void {
    console.log('[update] count')
    this.count += 1
  }

  outroMetodo(): string {
    console.log('[update] outroMetodo')
    return 'Hoje é ' + new Date().toLocaleString()
  }
}


