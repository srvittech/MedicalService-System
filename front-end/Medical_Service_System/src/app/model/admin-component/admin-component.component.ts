import { ThisReceiver } from '@angular/compiler';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute,Router } from '@angular/router';
import { UserServiceService } from 'src/app/services/user-Service/user-service.service';
import { PopUpComponent } from '../pop-up/pop-up.component';
import { AddDoctorDialogComponent } from './add-doctor-dialog/add-doctor-dialog.component';
import { AddKioskDialogComponent } from './add-kiosk-dialog/add-kiosk-dialog.component';

@Component({
  selector: 'app-admin-component',
  templateUrl: './admin-component.component.html',
  styleUrls: ['./admin-component.component.css']
})
export class AdminComponentComponent {
  constructor(private router:Router,private dialog: MatDialog,private userService:UserServiceService,private route:ActivatedRoute) {
   this.user = this.userService.user
  }
  openDialog(): void {
    const dialogRef = this.dialog.open(PopUpComponent, {
      data: {m1:"SuccesFully LoggedOut"},
    });

    dialogRef.afterClosed().subscribe(result => {
      
    })
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
  
  openAppointments(){
    this.router.navigate(['appointments'], { relativeTo: this.route });
  }
  openFeedbacks(){
    this.router.navigate(['feedbacks'], { relativeTo: this.route });
  }
  openDoctors(){
    this.router.navigate(['doctors'], { relativeTo: this.route });
  }
  openPatients(){
    this.router.navigate(['patients'], { relativeTo: this.route });
  }
  logout(){
    this.router.navigate(['/about']);
    this.openDialog()
  }
}
