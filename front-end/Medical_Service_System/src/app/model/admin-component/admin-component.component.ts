import { ThisReceiver } from '@angular/compiler';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UserServiceService } from 'src/app/services/user-Service/user-service.service';
import { AddDoctorDialogComponent } from './add-doctor-dialog/add-doctor-dialog.component';
import { AddKioskDialogComponent } from './add-kiosk-dialog/add-kiosk-dialog.component';

@Component({
  selector: 'app-admin-component',
  templateUrl: './admin-component.component.html',
  styleUrls: ['./admin-component.component.css']
})
export class AdminComponentComponent {
  constructor(private dialog: MatDialog,private userService:UserServiceService) {
   this.user = this.userService.user
  }
  user: any = {
    id: null,
    password: null,
    role: null,
    userName: null
  }
  openAddDoctorDialog() {
    this.dialog.open(AddDoctorDialogComponent)
  }
  openAddKioskDialog(){
    this.dialog.open(AddKioskDialogComponent)
  }
}
