import { Routes } from '@angular/router';
import { CountNormalComponent } from './count-normal/count-normal.component';
import { CountSignalComponent } from './count-signal/count-signal.component';

export const routes: Routes = [
    { path: 'count-normal', component: CountNormalComponent },
    { path: 'count-signal', component: CountSignalComponent }
];
