import { Component } from '@angular/core';
import { PatientServiceService } from 'src/app/services/patient-Service/patient-service.service';
@Component({
  selector: 'app-patient-component',
  templateUrl: './patient-component.component.html',
  styleUrls: ['./patient-component.component.css']
})
export class PatientComponentComponent{
  user: any = {
    address: null,age:null,
    disease:null,
    email:null,
    id:null,
    mobile:null,
    name:null,
    weight:null
  }
  constructor(private patientService:PatientServiceService){
    this.user = this.patientService.patient
  }
}

