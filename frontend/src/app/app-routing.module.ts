import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthLayoutComponent} from "./components/authentication/details/UI/auth-layout/auth-layout.component";
import {
  RegistrationPageComponent
} from "./components/authentication/details/registration-page/registration-page.component";
import {ProfilePageComponent} from "./components/main/details/profile-page/profile-page.component";

const routes: Routes = [
  {
    path: '', component: AuthLayoutComponent, children: [
      {path: '', redirectTo: '/', pathMatch: 'full'},
      {path: '', component: RegistrationPageComponent},
    ]
  },

  {path: 'profile/:user_name', component: ProfilePageComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
