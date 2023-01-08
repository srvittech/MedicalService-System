import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';

@Component({
  selector: 'app-edit-doctor',
  templateUrl: './edit-doctor.component.html',
  styleUrls: ['./edit-doctor.component.css']
})
export class EditDoctorComponent {
  public signupForm !: FormGroup;
  submitted = false
  user:any=[]
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
      this.doctorService.addDoctor(this.signupForm.value).subscribe(res=>{
        console.log("Doctor Added");
      })
      console.table(this.signupForm.value);
      alert("Success")
    }
 
  }
 findDoctorById(){
  this.doctorService.findDoctorById(this.signupForm.value.id).subscribe(res=>{
    this.doctorService.user = res
 })
}
updateDoctor(form:any){
  
}
  close() {
    this.dialog.closeAll()
  }
}


