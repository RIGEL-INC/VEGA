import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { RegistrationPageComponent } from './components/authentication/details/registration-page/registration-page.component';
import { ProfilePageComponent } from './components/main/details/profile-page/profile-page.component';
import { AuthLayoutComponent } from './components/authentication/details/UI/auth-layout/auth-layout.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationPageComponent,
    ProfilePageComponent,
    AuthLayoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
