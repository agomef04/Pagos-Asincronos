import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class userOperationsService {

  email : string = '';
  id : number = 0;
  name : string = '';
  password : string = '';
  phoneNumber : string = '';

  constructor(private http: HttpClient, private router: Router, private _snackBar: MatSnackBar) { }

  login(email: string, password: string) {
    console.log(email + " " + password);
  
    this.http.get(`http://localhost:8080/users/login?email=${email}&password=${password}`, { observe: 'response' }).subscribe((response: HttpResponse<any>) => {
      if (response.status === 200) {
        this.router.navigate(['/inicio']);
        this.setUserData(response.body);
        console.log('Datos del usuario:', response.body);
      } 
      else {
        console.log('Error en el inicio de sesión. Código de estado:', response.status);
      }
    },
    (error) => {
      console.error('Error en la solicitud:', error);
      this._snackBar.open('Usuario o contraseña incorrectos', "Cerrar");
      setTimeout(() => {
        this._snackBar.dismiss();
      }, 5000);
    }
  );
  
  }
  

  register(userNameNR: string, userPhoneNR: string, userEmailNR: string, userPasswordNR: string){
    let userData = {
        "name": userNameNR,
        "email": userEmailNR,
        "password": userPasswordNR,
        "phoneNumber": userPhoneNR
    }
    
    this.http.post('http://localhost:8080/users/newUser', userData, { observe: 'response' }).subscribe((response: HttpResponse<any>) => {
      console.log('Respuesta POST:', response);
      this._snackBar.open('Se ha registrado con exito', "Cerrar");

      setTimeout(() => {
        this._snackBar.dismiss();
      }, 5000);

      this.router.navigate(['/login']);
    },
    (error) => {
      console.error('Error en la solicitud:', error);
      this._snackBar.open('No se ha podido registrar el usuario introducido, compruebe los datos', "Cerrar");

      setTimeout(() => {
        this._snackBar.dismiss();
      }, 5000);
    });
  }

  setUserData(data: { email: string, id: number, name: string, password: string, phoneNumber: string }){
    this.email = data.email;
    this.id = data.id;
    this.name = data.name;
    this.password = data.password;
    this.phoneNumber = data.phoneNumber;
  }



}
