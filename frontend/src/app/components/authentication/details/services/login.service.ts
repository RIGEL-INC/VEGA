import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class LoginService {
  constructor(private http: HttpClient){}

  private apiUrl = 'http://localhost:8080/api/v1.0/auth/authenticate';
  private token: string | null = null;

  authenticate(username: string, password: string): Observable<any> {
    const body = { username, password }
    return this.http.post<any>(this.apiUrl, body)
  }

  setToken(token: string | null) {
    this.token = token
  }

  getToken(): string | null {
    return this.token
  }

  isLoggedIn(): boolean {
    return !!this.token;
  }

}

// В этом сервисе я буду отправлять POST-запрос на сервер для аутентификации и сохранять токен при успешной аутентификации
