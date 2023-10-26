import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { InicioComponent} from './inicio/inicio.component';
import { RealizarPagosComponent } from './realizar-pagos/realizar-pagos.component';

const routes: Routes = [
  { path: 'inicio', component: InicioComponent },
  { path: 'listadoMovimientos', component: InicioComponent },
  { path: 'hacerPago', component: RealizarPagosComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
