import { Routes } from '@angular/router';
import { FirstComponent } from './first/first.component';
import { SecondComponent } from './second/second.component';

export const routes: Routes = [
    { 
        path: 'minha-primeira-rota', 
        component: FirstComponent
    },
    {
        path: 'minha-outra-rota',
        component: SecondComponent
    }
];
