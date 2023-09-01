import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {AuthResponse, User} from "./interfaces";
import {Observable, tap} from "rxjs";

@Injectable()
export class AuthService {

  private apiUrl = 'http://localhost:8080/api/v1.0/auth';

  constructor(private http: HttpClient) {}

  register(username: string, password: string): Observable<any> {
    const body = { username, password };
    return this.http.post(`${this.apiUrl}/register`, body)
  }




















  // constructor(private http: HttpClient) {}
  //
  // get token(): string {
  //   const  expDate = new Date(localStorage.getItem('backend-token-exp'))
  //   if (new Date() > expDate) {
  //     this.logout()
  //     return null
  //   }
  //   return localStorage.getItem('backend-token')
  // }
  //
  // login(user: User): Observable<any> {
  //   //auth
  //   user.returnSecureToken = true
  //
  //   return this.http.post(`http://localhost:8080/api/v1.0/auth/authenticate`, user) // тут через $ вставить environment??? Надо ли вообще ибо вроде все норм. гет есть/эндпоинт нужен
  //     .pipe(
  //       tap(this.setToken)//получаем некий токен и обрабаотываем в setToken e
  //     )
  // }
  //
  // logout() {
  //   this.setToken(null)
  // }
  //
  // isAuthenticated(): boolean {
  //   return !!this.token
  // }
  //
  // private setToken(response: AuthResponse | null) {
  //   if (response) {
  //     const expDate = new Date(new Date().getTime() + response.expiresIn * 1000)
  //     localStorage.setItem('backend-token', response.idToken)
  //     localStorage.setItem('backend-token-exp', expDate.toString())
  //   } else {
  //     localStorage.clear()
  //   }
  //
  // }

}
