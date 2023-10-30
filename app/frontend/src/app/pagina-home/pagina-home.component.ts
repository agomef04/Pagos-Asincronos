import { Component } from '@angular/core';

@Component({
  selector: 'app-pagina-home',
  templateUrl: './pagina-home.component.html',
  styleUrls: ['./pagina-home.component.css']
})
export class PaginaHomeComponent {
  
  numberOrigin: string = '00000000';
  name: string = 'Alvaro Gomez';
  email: string = 'alvaro@gmail.com';

}
