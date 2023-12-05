import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { Transaction } from 'src/app/models/transaction.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ViewTransactionService {

  constructor(private http: HttpClient, private router: Router) { }
 /* getBankAccount(id : number):Promise<any>{
    let idInteger : number =  Math.floor(id);
    var response = this.http.get<any>(`http://localhost:8080/accounts?idBankAccount=${idInteger}`).toPromise();
    return response;
  }*/
  showTransfer(phoneNumber : String):Promise<any>{
    console.log("Transferencias pedidas de cuenta con tlf:"+phoneNumber)
    var response = this.http.get(`http://localhost:8080/listTransfer?phoneNumber=${phoneNumber}`).toPromise();
    return response;
  }
}
