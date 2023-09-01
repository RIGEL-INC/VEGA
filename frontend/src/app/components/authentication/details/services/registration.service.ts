import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  private apiUrl = 'http://localhost:8080/api/v1.0/auth'; // Замените на ваш API URL

  constructor(private http: HttpClient) { }

  register(username: string, password: string): Observable<any> {
    const body = {
      username: username,
      password: password
    };

    return this.http.post(`${this.apiUrl}/register`, body);
  }
}
