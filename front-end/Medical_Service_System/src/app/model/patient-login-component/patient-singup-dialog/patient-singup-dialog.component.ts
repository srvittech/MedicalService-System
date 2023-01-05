import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { PatientServiceService } from 'src/app/services/patient-Service/patient-service.service';

@Component({
  selector: 'app-patient-singup-dialog',
  templateUrl: './patient-singup-dialog.component.html',
  styleUrls: ['./patient-singup-dialog.component.css']
})
export class PatientSingupDialogComponent {
  public signupForm !: FormGroup;
  submitted = false
  constructor(private formBuilder: FormBuilder,

    private dialog: MatDialog, private patientService: PatientServiceService) { }

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      mobile: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]]
    })

  }
  signup() {
    this.submitted = true
    if (!this.signupForm.invalid) {

      this.patientService.addPatient(this.signupForm.value).subscribe(res => {
        console.table(this.signupForm.value);
        console.log("Patient Added");


      })
    }

  }
  close() {
    this.dialog.closeAll()
  }


}
