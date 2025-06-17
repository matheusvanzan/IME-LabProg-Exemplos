import { Component, computed, effect, signal, WritableSignal, Signal } from '@angular/core';



@Component({
  selector: 'app-count-signal',
  imports: [],
  templateUrl: './count-signal.component.html',
  styleUrl: './count-signal.component.css'
})
export class CountSignalComponent {

  count: WritableSignal<number> = signal(0)

  doubleCount: Signal<number> = computed(() => {
    console.log('[computed] doubleCount')
    return 2 * this.count()
  })

  outroMetodo: Signal<string> = computed(() => {
    console.log('[computed] outroMetodo')
    return 'Hoje é ' + new Date().toLocaleString()
  })

  constructor() {
    // Efeito para observar mudanças de count
    effect(() => {
      console.log('[effect] count mudou para:', this.count());
    });

    // Efeito para observar mudanças de doubleCount
    effect(() => {
      console.log('[effect] doubleCount mudou para:', this.doubleCount());
    });

    // Efeito para observar mudanças de title
    effect(() => {
      console.log('[effect] outroMetodo mudou para:', this.outroMetodo());
    });
  }

  increment(): void {
    console.log('[update] count mudou para:', this.count())
    this.count.update(c => c+1)
  }

}
