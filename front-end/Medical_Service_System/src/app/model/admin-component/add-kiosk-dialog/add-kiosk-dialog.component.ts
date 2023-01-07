import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';
import { UserServiceService } from 'src/app/services/user-Service/user-service.service';

@Component({
  selector: 'app-add-kiosk-dialog',
  templateUrl: './add-kiosk-dialog.component.html',
  styleUrls: ['./add-kiosk-dialog.component.css']
})
export class AddKioskDialogComponent {
  public signupForm !: FormGroup;
  submitted = false
  constructor(private formBuilder: FormBuilder, private router: Router, 
    private dialog: MatDialog, private userService: UserServiceService) { }

  ngOnInit(): void {

    this.signupForm = this.formBuilder.group({
      userName: ['', Validators.required],
      role: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]]
    })
  }
  signup() {
    
    this.submitted = true
    if (!this.signupForm.invalid) {
      this.userService.addLogin(this.signupForm.value).subscribe(res=>{
        console.log("Kiosk Added");
      })
      console.table(this.signupForm.value);
      alert("Success")
    }

  }
  close() {
    this.dialog.closeAll()
  }

}


