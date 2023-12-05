import { Component } from '@angular/core';
import { userOperationsService } from '../services/userOperations/userOperations.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent {
  userNameNR: string = '';
  userPhoneNR: string = '';
  userEmailNR: string = '';
  userPasswordNR: string = '';
  userPasswordNR2: string = '';

  constructor(private userOperationsService: userOperationsService, private _snackBar: MatSnackBar) {}

  register() {
    console.log('Nombre de usuario:', this.userNameNR);
    console.log('Número de teléfono:', this.userPhoneNR);
    console.log('Email:', this.userEmailNR);
    console.log('Contraseña:', this.userPasswordNR);
    console.log('Confirmar contraseña:', this.userPasswordNR2);

    if(this.userPasswordNR !== this.userPasswordNR2){
      this._snackBar.open("¡Las contraseñas no coinciden!", "Cerrar");
      setTimeout(() => {
        this._snackBar.dismiss();
      }, 5000);
      return;
    }
  
    // También puedes llamar a tu servicio y pasar estos datos
    this.userOperationsService.register(this.userNameNR, this.userPhoneNR, this.userEmailNR, this.userPasswordNR);
  }
  
}
