import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { PatientServiceService } from 'src/app/services/patient-Service/patient-service.service';
import { PopUpComponent } from '../../pop-up/pop-up.component';

@Component({
  selector: 'app-edit-patient',
  templateUrl: './edit-patient.component.html',
  styleUrls: ['./edit-patient.component.css']
})
export class EditPatientComponent {
  patientDetails: any = {}
  public signupForm !: FormGroup;
  submitted = false
  patient: any = []
  
  m1:any = ""
  m2:any = ""
flag:boolean = false

  openDialog(): void {
    const dialogRef = this.dialog.open(PopUpComponent, {
      data: {m1:this.m1,m2:this.m2},
    });

    dialogRef.afterClosed().subscribe(result => {
      
    })
  }
  constructor(private formBuilder: FormBuilder, private router: Router,
    private dialog: MatDialog, private patientService: PatientServiceService) {
    this.patientDetails = this.patientService.patient
    console.table(this.patientDetails);
  }
  ngOnInit(): void {

    this.signupForm = this.formBuilder.group({
      id:[this.patientDetails.id],
      name: ['', Validators.required],
      age: ['', Validators.required],
      disease: ['', Validators.required],
      address: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      mobile: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      weight: ['', Validators.required]
    })
  }
  signup() {
    this.submitted = true
    if (!this.signupForm.invalid) {
      this.patientService.updatePatient(this.signupForm.value).subscribe(res => {
        this.flag = true
      })
      console.table(this.signupForm.value);
    }

    setTimeout(() => {
      if (this.flag) {
        this.m1 = "Your Profile Is Updated"
        this.m2 = "Thanks"
        this.dialog.closeAll()
        console.log("true");

      }
      else {
        this.m1 = "Something Went Wrong"
        this.m2 = "Try Again"
        console.log("false");

      }                       // <<<---using ()=> syntax
      this.openDialog()
    }, 2000);
    
  }

  close() {
    this.dialog.closeAll()
  }
}

