import { BrowserModule }      from '@angular/platform-browser';
import { NgModule }           from '@angular/core';
import { FormsModule }        from '@angular/forms';
import { HttpModule }         from '@angular/http';
import { RouterModule }       from '@angular/router';
import { APP_BASE_HREF }      from '@angular/common';


import { AppComponent }       from './app.component';
import { LoginComponent }     from './login/login.component';
import { Users }              from './models/Users';
import { RestService }        from './rest.service';
import { AppRoutingModule }   from './app-routing.module';
import { AdminComponent }     from './admin/admin.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [RestService, {provide: APP_BASE_HREF, useValue : '/FilmRental'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
