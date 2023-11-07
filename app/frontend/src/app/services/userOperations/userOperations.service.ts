import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class userOperationsService {

  constructor(private http: HttpClient, private router: Router) { }

  login(email: string, password: string){
    console.log(email + " " + password)
    this.http.get(`http://localhost:8080/users/login?email=${email}&password=${password}`, { observe: 'response' }).subscribe((response: HttpResponse<any>) => {
      console.log('Respuesta GET:', response);

      if(response.status !== 200){
        console.log("Usuario o contraseña incorrectos");
        alert("Usuario o contraseña incorrectos")
      }

      if(response.status === 200){
        this.router.navigate(['/inicio']);
      }
      
    });
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
      if (response.status === 200) {
        alert("Se ha registrado con exito")
        this.router.navigate(['/login']);
      }
      else{
        alert("El usuario ya existe");
      }
    });

  }
}
