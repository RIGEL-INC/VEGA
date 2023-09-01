import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "../services/interfaces";
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";
import {RegistrationService} from "../services/registration.service";

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.scss']
})
export class RegistrationPageComponent implements OnInit{

  username = '';
  password = '';
  token = '';

  constructor(
    private auth: AuthService,

    // private router: Router, //Редирект
    // private authService: RegistrationService,
  ){}

  registerTitle = 'Register'
  loginTitle = 'Login'

  formGroup: FormGroup | any;
  submitted = false;

  value: string | undefined;
  value2: string | undefined;


  register(): void {
    this.auth.register(this.username, this.password).subscribe(
      (response: any) => {
        this.token = response.token;
        localStorage.setItem('token', this.token)
      },
      (error) => {
        console.error('Ошибка при регистрации: ', error)
      }
    );
  }





  // register() {
  //   this.authService.register(this.email, this.password).subscribe(
  //     (response) => {
  //       const token = response.token;
  //       // Сохраните токен, например, в Local Storage
  //       localStorage.setItem('jwtToken', token);
  //     },
  //     (error) => {
  //       console.error('Registration failed:', error);
  //     }
  //   );
  // }




  submit() {
    console.log(this.formGroup)
    if (this.formGroup.invalid) {
      return
    }

    this.submitted = true

    const user: User = {
      username: this.formGroup.value.username,
      password: this.formGroup.value.password,
    }

    // this.auth.login(user).subscribe(() => {
    //   this.formGroup.reset()
    //   this.router.navigate(['', 'profile/:user_name'])    //тут отредачить путь к странице надо будет скорее всего
    //   this.submitted = false
    // })

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
      username: new FormControl(null, [
        Validators.required,
        Validators.email
      ]),
      password: new FormControl(null, [
        Validators.required,
        Validators.minLength(10)
      ]),
    });
  }

  removeToken($event: any) {
    localStorage.removeItem('token');
    this.token = '';
  }
}
