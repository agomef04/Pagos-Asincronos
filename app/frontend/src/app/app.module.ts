import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { LoginComponent } from './login/login.component';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {Component} from '@angular/core';
import { RealizarPagosComponent } from './realizar-pagos/realizar-pagos.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { PaginaHomeComponent } from './pagina-home/pagina-home.component';
import { InicioComponent } from './inicio/inicio.component';
import { TransactionViewComponent } from './transaction-view/transaction-view.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { HeaderComponentComponent } from './header-component/header-component.component';
import { BloqueadorDirective } from './register-page/bloqueador.directive';
import { HttpClientModule } from '@angular/common/http';
import {HashLocationStrategy, LocationStrategy} from '@angular/common'

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RealizarPagosComponent,
    PaginaHomeComponent,
    InicioComponent,
    TransactionViewComponent,
    RegisterPageComponent,
    HeaderComponentComponent,
    BloqueadorDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatSlideToggleModule,
    MatCardModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    FormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatTableModule,
    HttpClientModule,
    MatSnackBarModule
  ],
  providers: [{provide:LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule { }

