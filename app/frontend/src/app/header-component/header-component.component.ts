import { Component } from '@angular/core';
import { userOperationsService } from './../services/userOperations/userOperations.service';

@Component({
  selector: 'app-header-component',
  templateUrl: './header-component.component.html',
  styleUrls: ['./header-component.component.css']
})
export class HeaderComponentComponent {
  constructor(private userOps: userOperationsService) {}

  datoUsuario = {
    numberOrigin: this.userOps.phoneNumber,
    name: this.userOps.name,
    email: this.userOps.email
  };
  
}
