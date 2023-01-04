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
import { AboutComponentComponent } from './model/about-component/about-component.component';
import { AppointmentComponent } from './model/doctor-component/appointment/appointment.component';
import { PatientListComponent } from './model/doctor-component/patient-list/patient-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginDialogComponent } from './model/login-component/login-dialog/login-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatToolbarModule } from '@angular/material/toolbar';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { PatientLoginComponentComponent } from './model/patient-login-component/patient-login-component.component';
import { PatientSingupDialogComponent } from './model/patient-login-component/patient-singup-dialog/patient-singup-dialog.component';



@NgModule({
  declarations: [
    AppComponent,
    DoctorComponentComponent,
    PatientComponentComponent,
    KioskComponentComponent,
    AdminComponentComponent,
    LoginComponentComponent,
    AboutComponentComponent,
    AppointmentComponent,
    PatientListComponent,
    LoginDialogComponent,
    PatientLoginComponentComponent,
    PatientSingupDialogComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    HttpClientModule,
    MatButtonModule,
    MatIconModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
