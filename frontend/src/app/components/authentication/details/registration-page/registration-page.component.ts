import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.scss']
})
export class RegistrationPageComponent implements OnInit{


  registerTitle = 'Register or ...'
  loginTitle = 'Login'

  formGroup: FormGroup | undefined;
  value: string | undefined;
  value2: string | undefined;

  ngOnInit() {
    this.formGroup = new FormGroup({
      text: new FormControl<string | null>(null)
    });
  }

}
