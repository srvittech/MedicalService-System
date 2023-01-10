import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';
import { PopUpComponent } from '../../pop-up/pop-up.component';

@Component({
  selector: 'app-add-doctor-dialog',
  templateUrl: './add-doctor-dialog.component.html',
  styleUrls: ['./add-doctor-dialog.component.css']
})
export class AddDoctorDialogComponent {
  
  m1:any = ""
  m2:any = ""
flag:boolean = false
  roles: any = ["Eye", "ENT", "Heart"]

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


  openDialog(): void {
    const dialogRef = this.dialog.open(PopUpComponent, {
      data: {m1:this.m1,m2:this.m2},
    });

    dialogRef.afterClosed().subscribe(result => {
      
    })
  }


  signup() {

    this.submitted = true
    if (!this.signupForm.invalid) {
      this.doctorService.addDoctor(this.signupForm.value).subscribe(res => {
        console.log("Doctor Added");
        this.flag = true
      })
      alert("Success")
    this.dialog.closeAll()
    }

    setTimeout(()=>{    
      if (this.flag) {
        this.m1 = "Doctor Added Succesfully"
        this.m2 = "Thanks"
        console.log("true");
        
      }
      else{
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
