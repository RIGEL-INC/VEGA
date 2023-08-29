import { Component } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { forkJoin } from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  users: any[] = [];

  constructor(private http: HttpClient) {
    this.getUsers()

  }

  getUsers () {
    const userIds = [0, 1];
    const userAPI = 'http://localhost:8080/api/v1.0/people/';
    const requests = userIds.map(id => {
      return this.http.get(`${userAPI}${id}`)
    });

    forkJoin(requests).subscribe(
      (response: any[]) => {
         this.users = response;// починить response --> responses
         console.log(this.users);
      },
      error => {
        console.error('Error fetching users', error)
      }
    )

  }

}
