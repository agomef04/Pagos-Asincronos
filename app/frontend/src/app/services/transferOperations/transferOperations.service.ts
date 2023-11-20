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
  getBankAccount(id : Number):Promise<any>{
    var response = this.http.get<any>(`http://localhost:8080/accounts?idBankAccount=${id}`).toPromise();
    return response;
    /*this.http.get(`http://localhost:8080/accounts?idBankAccount=${id}` ,{ observe: 'response' }).subscribe((response: HttpResponse<any>) =>{
    alert(JSON.stringify(response.body))
    return response.toPromise();
    })*/
  }
  showTransfer(bankAccount : any):Promise<any>{
    alert("Transferencias pedidas de cuenta con id:"+bankAccount.id)
    var response = this.http.get(`http://localhost:8080/accounts?id=${bankAccount.id}`).toPromise();
    return response;
  }
}
