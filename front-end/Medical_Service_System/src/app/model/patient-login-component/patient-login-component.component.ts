import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { PatientServiceService } from 'src/app/services/patient-Service/patient-service.service';

import { PatientSingupDialogComponent } from './patient-singup-dialog/patient-singup-dialog.component';

@Component({
  selector: 'app-patient-login-component',
  templateUrl: './patient-login-component.component.html',
  styleUrls: ['./patient-login-component.component.css']
})
export class PatientLoginComponentComponent {
  registerForm!: FormGroup
  submitted = false;
  constructor(public dialog: MatDialog, public router: Router, private formBuilder: FormBuilder, private patientService: PatientServiceService) {

  }
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]]
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

    this.patientService.getPatientByEmail(this.registerForm.value.email).subscribe(res => {
      this.user = res
      this.patientService.patient = this.user
      console.table(this.user);
      if (this.user.email.toLowerCase() == this.registerForm.value.email.toLowerCase() && this.user.password == this.registerForm.value.password) {
        // this.openDialog()
        this.router.navigate(['patient'])
      }
      else {
        // this.dialog.open(WrongDialogComponent);
      }

    });



    alert("Success")

    //this.registerForm.reset()
  }
  openDialog() {
    this.dialog.open(PatientSingupDialogComponent);
  }
}
