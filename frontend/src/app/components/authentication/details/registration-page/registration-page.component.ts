import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "../services/interfaces";

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.scss']
})
export class RegistrationPageComponent implements OnInit{


  registerTitle = 'Register or ...'
  loginTitle = 'Login'

  formGroup: FormGroup | any;
  value: string | undefined;
  value2: string | undefined;


  submit() {
    console.log(this.formGroup)
    if (this.formGroup.invalid) {
      return
    }

    const user: User = {
      email: this.formGroup.value.email,
      password: this.formGroup.value.password,
    }

    // будем что то делать (Отправляем запрос на сервер
    // с этими данными и если все хорошо то сделать редирект,
    // если нет, то вывести ошибки на страницу(мб алерт или
    // всплывающую ошибку))
  }

  alert() {
    alert("Thank you <3. You just donated 1.000$")
  }

  ngOnInit() {
    this.formGroup = new FormGroup({
      email: new FormControl(null, [
        Validators.required,
        Validators.email
      ]),
      password: new FormControl(null, [
        Validators.required,
        Validators.minLength(10)
      ]),
    });
  }

}
