import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ButtonModule } from 'primeng/button';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {InputTextModule} from "primeng/inputtext";
import {PaginatorModule} from "primeng/paginator";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SharedModule} from "./components/services/shared.module";


import { AppComponent } from './app.component';
import { RegistrationPageComponent } from './components/authentication/details/registration-page/registration-page.component';
import { ProfilePageComponent } from './components/main/details/profile-page/profile-page.component';
import { AuthLayoutComponent } from './components/authentication/details/UI/auth-layout/auth-layout.component';
import { AuthPageComponent } from './components/authentication/details/auth-page/auth-page.component';

import {AuthService} from "./components/authentication/details/services/auth.service";
import {LoginService} from "./components/authentication/details/services/login.service";

@NgModule({
  declarations: [
    AppComponent,
    RegistrationPageComponent,
    ProfilePageComponent,
    AuthLayoutComponent,
    AuthPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    InputTextModule,
    PaginatorModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,

  ],
  providers: [
    AuthService,
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
