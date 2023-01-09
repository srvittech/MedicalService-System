import { Component } from '@angular/core';
import { PatientServiceService } from 'src/app/services/patient-Service/patient-service.service';

@Component({
  selector: 'app-view-patients',
  templateUrl: './view-patients.component.html',
  styleUrls: ['./view-patients.component.css']
})
export class ViewPatientsComponent {
  constructor(private patientService:PatientServiceService){}
  ngOnInit(): void {
    this.getPatient()
  }
  
  user: any = {
    id: null,
    name: null,
    password: null,
    age: null,
    address:null,
    disease:null,
    weight:null,
    email:null,
    mobile:null
  }
  getPatient(){
    this.patientService.getPatient().subscribe(res=>{
      this.user=res
      console.log(res)
    })
  }
  

}
