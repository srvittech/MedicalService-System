import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';
import { EditDoctorComponent } from './edit-doctor/edit-doctor.component';
import { FeedbackComponent } from './feedback/feedback.component';

@Component({
  selector: 'app-doctor-component',
  templateUrl: './doctor-component.component.html',
  styleUrls: ['./doctor-component.component.css']
})
export class DoctorComponentComponent implements OnInit {
  user:any = {}
  ngOnInit(): void {
    this.setUser()
    console.log("hi from doc");
    
  }
  constructor(private route: ActivatedRoute, private router: Router, private dialog: MatDialog,private doctorService:DoctorServiceService) { 
   
  }

  setUser(){
    this.user = this.doctorService.user
  }
  showAppointments() {
    this.ngOnInit()
    this.router.navigate(['appointment'], { relativeTo: this.route });
  }
  showPatientList() {
    this.router.navigate(['patientlist'], { relativeTo: this.route });
  }
  showFeedback() {
    this.router.navigate(['feedback'], { relativeTo: this.route });
  }
  openEdit() {
    this.dialog.open(EditDoctorComponent)
  }
}
