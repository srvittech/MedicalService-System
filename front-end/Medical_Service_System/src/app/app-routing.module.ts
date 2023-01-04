import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponentComponent } from './model/about-component/about-component.component';
import { AdminComponentComponent } from './model/admin-component/admin-component.component';
import { DoctorComponentComponent } from './model/doctor-component/doctor-component.component';
import { KioskComponentComponent } from './model/kiosk-component/kiosk-component.component';
import { LoginComponentComponent } from './model/login-component/login-component.component';
import { PatientComponentComponent } from './model/patient-component/patient-component.component';
import { PatientLoginComponentComponent } from './model/patient-login-component/patient-login-component.component';

const routes: Routes = [
  {path:"",redirectTo:"/about",pathMatch:"full"},
{path:"about",component:AboutComponentComponent},
{path:"admin",component:AdminComponentComponent},
{path:"doctor",component:DoctorComponentComponent},
{path:"patient",component:PatientComponentComponent},
{path:"kiosk",component:KioskComponentComponent},
{path:"login",component:LoginComponentComponent},
{path:"patientLogin",component:PatientLoginComponentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
