import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddDoctorDialogComponent } from './add-doctor-dialog/add-doctor-dialog.component';

@Component({
  selector: 'app-admin-component',
  templateUrl: './admin-component.component.html',
  styleUrls: ['./admin-component.component.css']
})
export class AdminComponentComponent {
  constructor(private dialog: MatDialog) {

  }
  openAddDoctorDialog() {
    this.dialog.open(AddDoctorDialogComponent)
  }
}
