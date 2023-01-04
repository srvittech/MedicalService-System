import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponentComponent } from './model/about-component/about-component.component';
import { AdminComponentComponent } from './model/admin-component/admin-component.component';
import { DoctorComponentComponent } from './model/doctor-component/doctor-component.component';
import { KioskComponentComponent } from './model/kiosk-component/kiosk-component.component';
import { LoginComponentComponent } from './model/login-component/login-component.component';
import { PatientComponentComponent } from './model/patient-component/patient-component.component';
import { PatientLoginComponentComponent } from './model/patient-login-component/patient-login-component.component';
import { AppointmentComponent } from './model/doctor-component/appointment/appointment.component';
import { PatientListComponent } from './model/doctor-component/patient-list/patient-list.component';
import { FeedbackComponent } from './model/doctor-component/feedback/feedback.component';
import { PatientAppointmentsComponent } from './model/kiosk-component/patient-appointments/patient-appointments.component';
import { DoctorAvailComponent } from './model/kiosk-component/doctor-avail/doctor-avail.component';

const routes: Routes = [
  { path: "", redirectTo: "/about", pathMatch: "full" },
  { path: "about", component: AboutComponentComponent },
  { path: "admin", component: AdminComponentComponent },
  {
    path: "doctor",
    component: DoctorComponentComponent,
    children: [
      { path: 'appointment', component: AppointmentComponent },
      { path: 'patientlist', component: PatientListComponent },
      { path: 'feedback', component: FeedbackComponent }
    ]
  },
  { path: "patient", component: PatientComponentComponent },
  { path: "kiosk", component: KioskComponentComponent },
  { path: "login", component: LoginComponentComponent },
  { path: "patientLogin", component: PatientLoginComponentComponent },
  {
    path: "kiosk",
    component: KioskComponentComponent,
    children: [
      { path: 'patientappointment', component: PatientAppointmentsComponent },
      { path: 'doctoravail', component: DoctorAvailComponent }

    ]
  },
  { path: "login", component: LoginComponentComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [DoctorComponentComponent, AppointmentComponent, PatientListComponent, FeedbackComponent]