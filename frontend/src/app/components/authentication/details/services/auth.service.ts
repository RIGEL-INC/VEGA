import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthResponse, User} from "./interfaces";
import {Observable, tap} from "rxjs";

@Injectable()
export class AuthService {

  constructor(private http: HttpClient) {}

  private apiUrl = 'http://localhost:8080/api/v1.0/auth';









  register(username: string, password: string): Observable<any> {
    const body = { username, password };
    return this.http.post(`${this.apiUrl}/register`, body)
  }

  get token(): string | any   {
    const tokenExp = localStorage.getItem(`backend-token-exp`)

    if (tokenExp !== null) {
      const expDate = new Date(tokenExp);
      if (expDate && new Date() > expDate) {
        this.logout();
        return null
      }
    }
    return localStorage.getItem('backend-token')
  }



  logout() {
    this.setToken(null)
  }



  private setToken(response: AuthResponse | any) {  // тут был налл
    if (response) {
      const expDate = new Date(new Date().getTime() + response.expiresIn * 1000)
      localStorage.setItem('backend-token', response.idToken)
      localStorage.setItem('backend-token-exp', expDate.toString())
    } else {
      localStorage.clear()
    }

  }

}
