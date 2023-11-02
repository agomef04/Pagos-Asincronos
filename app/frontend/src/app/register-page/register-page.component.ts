import { Component } from '@angular/core';
import { LoginService } from '../services/userOperations/userOperations.service';

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

  constructor(private loginService: LoginService) {}

  register() {
    console.log('Nombre de usuario:', this.userNameNR);
    console.log('Número de teléfono:', this.userPhoneNR);
    console.log('Email:', this.userEmailNR);
    console.log('Contraseña:', this.userPasswordNR);
    console.log('Confirmar contraseña:', this.userPasswordNR2);

    if(this.userPasswordNR !== this.userPasswordNR2){
      alert("¡Las contraseñas no coinciden!")
      return;
    }
  
    // También puedes llamar a tu servicio y pasar estos datos
    this.loginService.register(this.userNameNR, this.userPhoneNR, this.userEmailNR, this.userPasswordNR);
  }
  
}
