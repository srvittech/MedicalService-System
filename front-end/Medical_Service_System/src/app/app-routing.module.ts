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
import { PatientFeedbackComponent } from './model/patient-component/patient-feedback/patient-feedback.component';
import { PendingPatientsComponent } from './model/kiosk-component/pending-patients/pending-patients.component';
import { BookAppointmentComponent } from './model/patient-component/book-appointment/book-appointment.component';
import { ViewAppointmentStatusComponent } from './model/patient-component/view-appointment-status/view-appointment-status.component';
import { ViewAppointmentsComponent } from './model/admin-component/view-appointments/view-appointments.component';
import { ViewPatientsComponent } from './model/admin-component/view-patients/view-patients.component';
import { ViewDoctorsComponent } from './model/admin-component/view-doctors/view-doctors.component';
import { ViewFeedbackComponent } from './model/admin-component/view-feedback/view-feedback.component';
import { SidebarComponent } from './model/sidebar/sidebar.component';

const routes: Routes = [
  { path: "", redirectTo: "/about", pathMatch: "full" },
  { path: "about", component: AboutComponentComponent },

  {
    path: "sidebar", component: SidebarComponent, children: [
      { path: "login", component: LoginComponentComponent }, 
      {
        path: "loginpatient", component: PatientLoginComponentComponent
      }
    ]
  },

  {
    path: "admin", component: AdminComponentComponent,
    children: [
      { path: 'appointments', component: ViewAppointmentsComponent },
      { path: 'feedbacks', component: ViewFeedbackComponent },
      { path: 'doctors', component: ViewDoctorsComponent },
      { path: 'patients', component: ViewPatientsComponent }]
  },
  {
    path: "doctor",
    component: DoctorComponentComponent,
    children: [
      { path: 'appointment', component: AppointmentComponent },
      { path: 'patientlist', component: PatientListComponent },
      { path: 'feedback', component: FeedbackComponent }
    ]

  },
  {
    path: "patient", component: PatientComponentComponent,

    children: [
      { path: 'feedback', component: PatientFeedbackComponent },
      { path: 'bookAppointment', component: BookAppointmentComponent },
      { path: 'viewStatus', component: ViewAppointmentStatusComponent }

    ]

  },
  { path: "kiosk", component: KioskComponentComponent },
  { path: "login", component: LoginComponentComponent },
  { path: "patientLogin", component: PatientLoginComponentComponent },
  {
    path: "kiosk",
    component: KioskComponentComponent,
    children: [
      { path: 'patientappointment', component: PatientAppointmentsComponent },
      { path: 'doctoravail', component: DoctorAvailComponent },
      { path: 'pendingApp', component: PendingPatientsComponent }

    ]
  },
  { path: "login", component: LoginComponentComponent },
  { path: "login1", component: LoginComponentComponent },
  { path: "login2", component: LoginComponentComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [DoctorComponentComponent, AppointmentComponent, PatientListComponent, FeedbackComponent]