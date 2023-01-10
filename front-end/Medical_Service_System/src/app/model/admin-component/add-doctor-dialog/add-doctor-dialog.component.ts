import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';

@Component({
  selector: 'app-add-doctor-dialog',
  templateUrl: './add-doctor-dialog.component.html',
  styleUrls: ['./add-doctor-dialog.component.css']
})
export class AddDoctorDialogComponent {
  public signupForm !: FormGroup;
  submitted = false
  constructor(private formBuilder: FormBuilder, private router: Router,
    private dialog: MatDialog, private doctorService: DoctorServiceService) { }

  ngOnInit(): void {

    this.signupForm = this.formBuilder.group({
      doctorName: ['', Validators.required],
      specialization: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      mobile: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      yearsOfExperience: ['', Validators.required]
    })
  }

  roles: any = ["Eye", "ENT", "Heart"]
  signup() {

    this.submitted = true
    if (!this.signupForm.invalid) {
      this.doctorService.addDoctor(this.signupForm.value).subscribe(res => {
        console.log("Doctor Added");
      })
    this.dialog.closeAll()
    }

  }
  close() {
    this.dialog.closeAll()
  }

}
