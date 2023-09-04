import { Component } from '@angular/core';

@Component({
  selector: 'app-auth-layout',
  templateUrl: './auth-layout.component.html',
  styleUrls: ['./auth-layout.component.scss']
})
export class AuthLayoutComponent {


  alert() {
    alert("Thank you <3. You just donated 1.000$")
  }
}
