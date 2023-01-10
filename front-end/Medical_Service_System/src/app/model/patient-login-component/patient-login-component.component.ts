import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { PatientServiceService } from 'src/app/services/patient-Service/patient-service.service';
import { PopUpComponent } from '../pop-up/pop-up.component';

import { PatientSingupDialogComponent } from './patient-singup-dialog/patient-singup-dialog.component';

@Component({
  selector: 'app-patient-login-component',
  templateUrl: './patient-login-component.component.html',
  styleUrls: ['./patient-login-component.component.css']
})
export class PatientLoginComponentComponent {
  registerForm!: FormGroup
  submitted = false;
  
  m1:any = ""
  m2:any = ""
  flag:boolean = false


  constructor(public dialog: MatDialog, public router: Router, private formBuilder: FormBuilder, private patientService: PatientServiceService) {

  }
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]]
    })
  }
  
  openPopDialog(): void {
    const dialogRef = this.dialog.open(PopUpComponent, {
      data: {m1:this.m1,m2:this.m2},
    });

    dialogRef.afterClosed().subscribe(result => {
      
    })
  }
  user: any = {
    address: null,age:null,
    disease:null,
    email:null,
    id:null,
    mobile:null,
    name:null,
    weight:null
  }

  submit() {
    this.submitted = true
    if (this.registerForm.invalid) { return }

    this.patientService.findPatientByEmail(this.registerForm.value.email).subscribe(res => {
      this.user = res
      this.patientService.patient = this.user
      console.table(this.user);
      if (this.user.email.toLowerCase() == this.registerForm.value.email.toLowerCase() && this.user.password == this.registerForm.value.password) {
        // this.openDialog()
        this.flag = true
        this.router.navigate(['patient'])
      }
     
    });



    setTimeout(()=>{    
      if (this.flag) {
        this.m1 = "Logged In Succesfull"
        this.m2 = "Thanks"
        console.log("true");
        
      }
      else{
        this.m1 = "Wrong UserId / Password Combination"
        this.m2 = "Try Again"
        console.log("false");
        
      }                       // <<<---using ()=> syntax
      this.openPopDialog()
    }, 2000);

    //this.registerForm.reset()
  }
  openDialog() {
    this.dialog.open(PatientSingupDialogComponent);
  }
}
