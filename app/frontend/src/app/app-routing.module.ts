import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import {RegisterPageComponent} from './register-page/register-page.component';
import { InicioComponent} from './inicio/inicio.component';
import { RealizarPagosComponent } from './realizar-pagos/realizar-pagos.component';
import { TransactionViewComponent } from './transaction-view/transaction-view.component';
import {PaginaHomeComponent} from './pagina-home/pagina-home.component'

const routes: Routes = [
  {path: '', redirectTo:'/login', pathMatch: 'full'},
  {path: 'login',  component: LoginComponent},
  {path: 'register', component: RegisterPageComponent},
  {path: 'inicio',  component: InicioComponent},
  {path: 'listadoMovimientos', component: TransactionViewComponent},
  {path: 'hacerPago', component: RealizarPagosComponent},
  {path: 'home', component: PaginaHomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
