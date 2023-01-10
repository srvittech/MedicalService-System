import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { PopUpService } from 'src/app/services/dialog/pop-up.service';
import { PatientServiceService } from 'src/app/services/patient-Service/patient-service.service';
import { PopUpComponent } from '../../pop-up/pop-up.component';

@Component({
  selector: 'app-patient-singup-dialog',
  templateUrl: './patient-singup-dialog.component.html',
  styleUrls: ['./patient-singup-dialog.component.css']
})
export class PatientSingupDialogComponent {
  public signupForm !: FormGroup;
  submitted = false
  constructor(private formBuilder: FormBuilder,

    private dialog: MatDialog, private patientService: PatientServiceService, private popUpService: PopUpService) { }

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
        this.popUpService.m1 = "Succesfully SignedUp"
        this.popUpService.m2 = "Thanks"
        this.signupForm.reset()
        this.close()
        this.dialog.open(PopUpComponent)
      })
    }
    else {
      this.popUpService.m1 = "Something Went Wrong"
      this.popUpService.m2 = "Try Again"
      // this.close()
      this.dialog.open(PopUpComponent)
    }

  }
  close() {
    this.dialog.closeAll()
  }


}
