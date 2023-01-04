import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-kiosk-component',
  templateUrl: './kiosk-component.component.html',
  styleUrls: ['./kiosk-component.component.css']
})
export class KioskComponentComponent implements OnInit{
  ngOnInit(): void {
  }
  constructor(private route:ActivatedRoute,private router:Router){}
  showAppointments(){
    this.router.navigate(['patientappointment'],{relativeTo:this.route});
  }
  showPatientList(){
    this.router.navigate(['doctoravail'],{relativeTo:this.route});
  }
  showFeedback(){
    this.router.navigate(['feedback'],{relativeTo:this.route});
  }
}
