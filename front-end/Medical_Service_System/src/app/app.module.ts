import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DoctorComponentComponent } from './model/doctor-component/doctor-component.component';
import { PatientComponentComponent } from './model/patient-component/patient-component.component';
import { KioskComponentComponent } from './model/kiosk-component/kiosk-component.component';
import { AdminComponentComponent } from './model/admin-component/admin-component.component';
import { LoginComponentComponent } from './model/login-component/login-component.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    DoctorComponentComponent,
    PatientComponentComponent,
    KioskComponentComponent,
    AdminComponentComponent,
    LoginComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
