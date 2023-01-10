import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';
import { PopUpComponent } from '../../pop-up/pop-up.component';

@Component({
  selector: 'app-edit-doctor',
  templateUrl: './edit-doctor.component.html',
  styleUrls: ['./edit-doctor.component.css']
})
export class EditDoctorComponent {
  doctorDetails: any = {}
  public signupForm !: FormGroup;
  submitted = false
  user: any = []
  constructor(private formBuilder: FormBuilder, private router: Router,
    private dialog: MatDialog, private doctorService: DoctorServiceService) {
    this.doctorDetails = this.doctorService.user
    console.table(this.doctorDetails);

  }
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
  m1: any = ""
  m2: any = ""
  flag: boolean = false

  openDialog(): void {
    const dialogRef = this.dialog.open(PopUpComponent, {
      data: { m1: this.m1, m2: this.m2 },
    });

    dialogRef.afterClosed().subscribe(result => {

    })
  }
  roles: any = ["Eye", "ENT", "Heart"]
  signup() {

    this.submitted = true
    if (!this.signupForm.invalid) {
      this.doctorService.addDoctor(this.signupForm.value).subscribe(res => {
        console.log("Doctor Added");
        this.flag = true
      })
      console.table(this.signupForm.value);

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

      // this.doctorService.updateDoctor(this.signupForm.value).subscribe(res=>{
      //   console.table(res)
      // })
    }

  }
  findDoctorById() {
    this.doctorService.findDoctorById(this.signupForm.value.id).subscribe(res => {
      this.doctorService.user = res
    })
  }
  // update(){
  //   this.doctorService.updateDoctor(this.signupForm.value).subscribe(res=>{
  //     console.table(res)
  //   })
  //}
  close() {
    this.dialog.closeAll()
  }
}


