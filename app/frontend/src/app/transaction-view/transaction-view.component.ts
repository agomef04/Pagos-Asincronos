import { Component , Input} from '@angular/core';
import {Transaction} from '../models/transaction.model';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { HeaderComponentComponent } from '../header-component/header-component.component';
import { ViewTransactionService } from '../services/transferOperations/transferOperations.service';
import {finalize} from 'rxjs/operators';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'transaction-view',
  templateUrl: './transaction-view.component.html',
  styleUrls: ['./transaction-view.component.css']
})
export class TransactionViewComponent {
  displayedColumns: string[] = ['id','importe','numOrigen','numDestino','fecha','concepto','estado']; // Lista de columnas a mostrar
  dataSource: MatTableDataSource<any> = new MatTableDataSource; // Fuente de datos de la tabla

  @Input() transactions : Transaction[] = [{id:0,importe:1000,numeroOrigen:0,numeroDestino:0,fecha:new Date(),concepto:"Prueba",estado : "Pendiente"},{id:20,importe:1000,numeroOrigen:0,numeroDestino:0,fecha:new Date(),concepto:"Prueba",estado : "Pendiente"}]
  constructor(private viewTransactionService: ViewTransactionService) {
    this.renderTransactions()
  }

  async renderTransactions(){
    var bankAccount : any
    var userTransactions : any
    try {
      bankAccount = await this.viewTransactionService.getBankAccount(3);
      alert("Hemos traido la cuenta");
      userTransactions = await this.viewTransactionService.showTransfer(bankAccount);
      // Continúa con la ejecución aquí
    } catch (error) {
      console.error('Error:', error);
      // Maneja el error aquí si es necesario
    }
      alert("Ya tendriamos las transacciones")
      this.transactions = userTransactions;
      const data = this.transactions
      this.dataSource = new MatTableDataSource(data);
  }
}
