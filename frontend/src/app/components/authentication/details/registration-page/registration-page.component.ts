import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.scss']
})
export class RegistrationPageComponent implements OnInit{

  username = '';
  password = '';
  token = '';
  loginText = 'Already have an account? Come in!'
  registerTitle = 'Register'

  formGroup: FormGroup | any;
  submitted = false;

  constructor(
    private auth: AuthService,
    private router: Router, //Редирект
    // private authService: RegistrationService,
  ){}

  register(): void {
    this.auth.register(this.username, this.password).subscribe(
      (response) => { //в колбэке (response) => {...} сохраняется токен из ответа в переменную this.token, и он также сохраняется в localStorage.
        this.token = response.token;
        localStorage.setItem('token', this.token)
        console.log("Регистрация аккаунта выполнена успешно!")
        this.router.navigate([`profile/${this.username}`])
      },
      (error) => {
        console.error('Ошибка при регистрации: ', error)
      }
    );
  }

  toTheLoginPage() {
    this.router.navigate([`login`])
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
