import { Component , Input} from '@angular/core';
import {Transaction} from '../models/transaction.model';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { HeaderComponentComponent } from '../header-component/header-component.component';
import { ViewTransactionService } from '../services/transferOperations/transferOperations.service';
import {finalize} from 'rxjs/operators';
import { HttpResponse } from '@angular/common/http';
import { userOperationsService } from '../services/userOperations/userOperations.service';

@Component({
  selector: 'transaction-view',
  templateUrl: './transaction-view.component.html',
  styleUrls: ['./transaction-view.component.css']
})
export class TransactionViewComponent {
  displayedColumns: string[] = ['id','importe','numOrigen','numDestino','fecha','concepto','estado']; // Lista de columnas a mostrar
  dataSource: MatTableDataSource<any> = new MatTableDataSource; // Fuente de datos de la tabla

  @Input() transactions : Transaction[] = []
  constructor(private viewTransactionService: ViewTransactionService,private userService: userOperationsService) {
    this.renderTransactions()
  }

  async renderTransactions(){
    var userTransactions : any
    var defTransaction : any
    try {
      userTransactions = await this.viewTransactionService.showTransfer(this.userService.phoneNumber);
      console.log("Hemos traido la cuenta");
      // Continúa con la ejecución aquí
    } catch (error) {
      console.error('Error:', error);
      // Maneja el error aquí si es necesario
    }
      console.log("Ya tendriamos las transacciones")
      for (let transfer of userTransactions) {
        transfer.accountOrigin = transfer.accountOrigin.user.phoneNumber;
        transfer.accountDestination = transfer.accountDestination.user.phoneNumber;
      }
      this.transactions = userTransactions;
      const data = this.transactions
      this.dataSource = new MatTableDataSource(data);
  }
}
