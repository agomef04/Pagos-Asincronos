import { Component , Input} from '@angular/core';
import {Transaction} from '../models/transaction.model';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'transaction-view',
  templateUrl: './transaction-view.component.html',
  styleUrls: ['./transaction-view.component.css']
})
export class TransactionViewComponent {
  displayedColumns: string[] = ['id','importe','numOrigen','numDestino','fecha','concepto']; // Lista de columnas a mostrar
  dataSource: MatTableDataSource<any>; // Fuente de datos de la tabla

  @Input() transactions : Transaction[] = [{id:0,importe:1000,numeroOrigen:0,numeroDestino:0,fecha:new Date(),concepto:""}]
  constructor() {
    // Datos de ejemplo, reemplaza con tus datos reales
    const data = this.transactions
    this.dataSource = new MatTableDataSource(data);
  }
}
