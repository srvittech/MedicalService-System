import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-doctor-component',
  templateUrl: './doctor-component.component.html',
  styleUrls: ['./doctor-component.component.css']
})
export class DoctorComponentComponent implements OnInit {
  ngOnInit(): void {
  }
  constructor(private route:ActivatedRoute,private router:Router){}
  showAppointments(){
    this.router.navigate(['appointment'],{relativeTo:this.route});
  }
  showPatientList(){
    this.router.navigate(['patientlist'],{relativeTo:this.route});
  }
  showFeedback(){
    this.router.navigate(['feedback'],{relativeTo:this.route});
  }
 
}
