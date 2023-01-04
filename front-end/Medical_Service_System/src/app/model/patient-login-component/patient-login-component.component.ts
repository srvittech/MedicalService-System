import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { InternalService } from 'src/app/services/internalService/internal.service';
import { PatientSingupDialogComponent } from './patient-singup-dialog/patient-singup-dialog.component';

@Component({
  selector: 'app-patient-login-component',
  templateUrl: './patient-login-component.component.html',
  styleUrls: ['./patient-login-component.component.css']
})
export class PatientLoginComponentComponent {
  loginType:any=""
  constructor(public dialog: MatDialog,public router:Router,private internalService:InternalService){
    this.loginType=this.internalService.loginType
  }
  id:any="user";
  pass:any="root123";
  form = new FormGroup({
    userId: new FormControl(""),
    password: new FormControl("")
  })
  roles:any=["Admin","Kiosk","Doctor"]

  submit(){
    if(this.id==this.form.value.userId&&this.pass==this.form.value.password){
      // this.openDialog()
      this.router.navigate(['patient'])
    }
    else{
      // this.dialog.open(WrongDialogComponent);
    }
    this.form.reset()
}
openDialog(){
  this.dialog.open(PatientSingupDialogComponent);
}
}
