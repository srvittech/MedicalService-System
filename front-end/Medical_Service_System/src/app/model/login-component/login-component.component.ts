import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';
import { UserServiceService } from 'src/app/services/user-Service/user-service.service';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {
  registerForm!: FormGroup
  submitted = false;
  loginType: any = ""
  constructor(public dialog: MatDialog, public router: Router, private formBuilder: FormBuilder, private userService: UserServiceService,private doctorService:DoctorServiceService) {

  }
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      id: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role: ['', Validators.required]
    })

  }
  user: any = {
    id: null,
    password: null,
    role: null,
    userName: null
  }
  roles: any = ["Admin", "Kiosk", "Doctor"]

  submit() {
    this.submitted = true
    if (this.registerForm.invalid) {
      return
    } alert("Success")
    this.userService.getLogin(this.registerForm.value.id).subscribe(res => {
      this.user = res
      this.userService.user = this.user
      console.table(this.user);
      
      if (this.user.id == this.registerForm.value.id && this.user.password == this.registerForm.value.password && this.registerForm.value.role.toLowerCase() =="admin") {
        //this.openDialog()
        console.log(this.registerForm.value.password );
        console.log(this.user.password);
        this.router.navigate(['admin'])
      }
      else if (this.user.id == this.registerForm.value.id && this.user.password == this.registerForm.value.password && this.registerForm.value.role.toLowerCase() == "kiosk" ){
        //this.openDialog()
        console.log("kiosk");

        this.router.navigate(['kiosk'])

      }
      else {
        // this.dialog.open(WrongDialogComponent);
      }
    })
    //this.registerForm.reset()
  this.doctorService.findDoctorById(this.registerForm.value.id).subscribe(res=>{
    this.user = res
    this.doctorService.user = this.user
    if (this.user.id == this.registerForm.value.id && this.user.password == this.registerForm.value.password ){
      //this.openDialog()
      console.log("doc");
      this.router.navigate(['doctor'])

    }
  })

  }
  openDialog() {
    // this.dialog.open(DialogComponent);
  }
}

