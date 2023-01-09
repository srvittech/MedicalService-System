import { Component } from '@angular/core';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';

@Component({
  selector: 'app-view-doctors',
  templateUrl: './view-doctors.component.html',
  styleUrls: ['./view-doctors.component.css']
})
export class ViewDoctorsComponent {
  constructor(private doctorService:DoctorServiceService){}
  ngOnInit(): void {
    this.getDoctors()
  }
  
  user: any = {
    id: null,
    doctorName: null,
    password: null,
    yearsOfExperience: null,
    specialization:null,
    availability:null,
    email:null,
    mobile:null
  }
  getDoctors(){
    this.doctorService.getDoctors().subscribe(res=>{
      this.user=res
      console.log(res)
    })
  }
  
  

}
