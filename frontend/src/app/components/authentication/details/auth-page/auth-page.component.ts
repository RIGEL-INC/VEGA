import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {LoginService} from "../services/login.service";

@Component({
  selector: 'app-auth-page',
  templateUrl: './auth-page.component.html',
  styleUrls: ['./auth-page.component.scss']
})
export class AuthPageComponent implements OnInit{
  username = '';
  password = '';
  token = '';
  loginText = 'Do not have an account yet? Register!';
  loginTitle = 'Login'

  formGroup: FormGroup | any;
  submitted = false;
  value: string | undefined;

  constructor(
    private router: Router, //Редирект
    private loginService: LoginService, //Подключил сервис с входом в аккаунт
  ){}

  toTheRegPage() {
    this.router.navigate([``])
  }

  loginButton() {
    this.loginService.authenticate(this.username, this.password).subscribe(
      (response) => { //в колбэке (response) => {...} сохраняется токен из ответа в переменную this.token, и он также сохраняется в localStorage.
        this.token = response.token;
        localStorage.setItem('token', this.token)
        console.log("Вход в аккаунт выполнен успешно!")
        this.router.navigate([`profile/${this.username}`])
      },
      (error) => {
        console.error("Ошибка в функции loginButton", error)
      }
    );
  }

  ngOnInit() {
    this.formGroup = new FormGroup({
      username: new FormControl(null, [
        Validators.required
      ]),
      password: new FormControl(null, [
        Validators.required,
        Validators.minLength(10)
      ]),
    });
  }

  removeToken($event: any) {  //logout in the future
    localStorage.removeItem('token');
    this.token = '';
  }
}
