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
import { MatDialogModule } from '@angular/material/dialog';
import { MatToolbarModule } from '@angular/material/toolbar';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { PatientLoginComponentComponent } from './model/patient-login-component/patient-login-component.component';
import { PatientSingupDialogComponent } from './model/patient-login-component/patient-singup-dialog/patient-singup-dialog.component';
import { FeedbackComponent } from './model/doctor-component/feedback/feedback.component';
import { PatientAppointmentsComponent } from './model/kiosk-component/patient-appointments/patient-appointments.component';
import { DoctorAvailComponent } from './model/kiosk-component/doctor-avail/doctor-avail.component';
import { AddDoctorDialogComponent } from './model/admin-component/add-doctor-dialog/add-doctor-dialog.component';
import { EditDoctorComponent } from './model/doctor-component/edit-doctor/edit-doctor.component';
import { AddKioskDialogComponent } from './model/admin-component/add-kiosk-dialog/add-kiosk-dialog.component';
import { PatientFeedbackComponent } from './model/patient-component/patient-feedback/patient-feedback.component';
import { ViewAppointmentsComponent } from './model/admin-component/view-appointments/view-appointments.component';
import {DatePipe} from '@angular/common';
import { FeedbackServiceService } from './services/feedback-Service/feedback-service.service';
import { UserServiceService } from './services/user-Service/user-service.service';
import { PatientServiceService } from './services/patient-Service/patient-service.service';
import { DoctorServiceService } from './services/doctor-Service/doctor-service.service';
import { TransactionServiceService } from './services/transaction-Service/transaction-service.service';
import { PendingPatientsComponent } from './model/kiosk-component/pending-patients/pending-patients.component';
import { BookAppointmentComponent } from './model/patient-component/book-appointment/book-appointment.component';
import { ViewAppointmentStatusComponent } from './model/patient-component/view-appointment-status/view-appointment-status.component';
import { EditPatientComponent } from './model/patient-component/edit-patient/edit-patient.component';
import { ViewFeedbackComponent } from './model/admin-component/view-feedback/view-feedback.component';
import { ViewPatientsComponent } from './model/admin-component/view-patients/view-patients.component';
import { ViewDoctorsComponent } from './model/admin-component/view-doctors/view-doctors.component';
import { PrescriptionDialogComponent } from './model/doctor-component/appointment/prescription-dialog/prescription-dialog.component';
import { PopUpComponent } from './model/pop-up/pop-up.component';
import { PopUpService } from './services/dialog/pop-up.service';
import { SidebarComponent } from './model/sidebar/sidebar.component';

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
    PatientLoginComponentComponent,
    PatientSingupDialogComponent,
    FeedbackComponent,
    PatientAppointmentsComponent,
    DoctorAvailComponent,
    AddDoctorDialogComponent,
    EditDoctorComponent,
    AddKioskDialogComponent,
    PatientFeedbackComponent,
    ViewAppointmentsComponent,
    PendingPatientsComponent,
    BookAppointmentComponent,
    ViewAppointmentStatusComponent,
    EditPatientComponent,
    ViewFeedbackComponent,
    ViewPatientsComponent,
    ViewDoctorsComponent,
    PrescriptionDialogComponent,
    PopUpComponent,
    SidebarComponent
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
    FormsModule,
  ],
  providers: [DatePipe,FeedbackServiceService,UserServiceService,PatientServiceService,DoctorServiceService,TransactionServiceService,PopUpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
