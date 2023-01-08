import { Component } from '@angular/core';
import { FormBuilder, FormGroup,Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { PatientServiceService } from 'src/app/services/patient-Service/patient-service.service';

@Component({
  selector: 'app-edit-patient',
  templateUrl: './edit-patient.component.html',
  styleUrls: ['./edit-patient.component.css']
})
export class EditPatientComponent {
  patientDetails:any ={}
  public signupForm !: FormGroup;
  submitted = false
  patient:any=[]
  constructor(private formBuilder: FormBuilder, private router: Router, 
    private dialog: MatDialog, private patientService: PatientServiceService) {
      this.patientDetails = this.patientService.patient
      console.table(this.patientDetails);
  }
  ngOnInit(): void {

    this.signupForm = this.formBuilder.group({
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
  signup(){
    this.submitted = true
    if (!this.signupForm.invalid) {
      this.patientService.addPatient(this.signupForm.value).subscribe(res=>{
        console.log("Patient Added");
      })
      console.table(this.signupForm.value);
      alert("Success")
      // this.doctorService.updateDoctor(this.signupForm.value).subscribe(res=>{
      //   console.table(res)
      // })
    }
  }
    findPatientById(){
      this.patientService.findPatientById(this.signupForm.value.id).subscribe(res=>{
        this.patientService.patient = res
     })
  }
}

