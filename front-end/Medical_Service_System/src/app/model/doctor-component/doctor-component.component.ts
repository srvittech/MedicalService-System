import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { EditDoctorComponent } from './edit-doctor/edit-doctor.component';

@Component({
  selector: 'app-doctor-component',
  templateUrl: './doctor-component.component.html',
  styleUrls: ['./doctor-component.component.css']
})
export class DoctorComponentComponent implements OnInit {
  ngOnInit(): void {
  }
  constructor(private route: ActivatedRoute, private router: Router, private dialog: MatDialog) { }
  showAppointments() {
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
