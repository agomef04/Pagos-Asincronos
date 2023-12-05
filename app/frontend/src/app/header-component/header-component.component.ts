import { Component } from '@angular/core';

@Component({
  selector: 'app-header-component',
  templateUrl: './header-component.component.html',
  styleUrls: ['./header-component.component.css']
})
export class HeaderComponentComponent {
  numberOrigin: string = '00000000';
  name: string = 'Alvaro Gomez';
  email: string = 'alvaro@gmail.com';
}
