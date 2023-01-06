import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
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
  constructor(public dialog: MatDialog, public router: Router, private formBuilder: FormBuilder, private userService: UserServiceService) {

  }
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      userName: ['', Validators.required],
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
  /*registerForm = new registerFormGroup({
    userId: new registerFormControl(""),
    password: new registerFormControl(""),
    role: new registerFormControl("")
  })*/
  roles: any = ["Admin", "Kiosk", "Doctor"]

  submit() {
    this.submitted = true
    if (this.registerForm.invalid) {
      return
    } alert("Success")
    this.userService.getLogin(this.registerForm.value.email).subscribe(res => {
      this.user = res
      this.userService.user = this.user
      console.table(this.user);
      if (this.user.id == this.registerForm.value.userId && this.user.password == this.registerForm.value.password && this.registerForm.value.role.toLowerCase() == this.user.role.toLowerCase()) {
        //this.openDialog()
        this.router.navigate(['admin'])
      }
      else if (this.user.id == this.registerForm.value.userId && this.user.password == this.registerForm.value.password && this.registerForm.value.role.toLowerCase() == this.user.role.toLowerCase()) {
        //this.openDialog()
        this.router.navigate(['kiosk'])

      }
      else if (this.user.id == this.registerForm.value.userId && this.user.password == this.registerForm.value.password && this.registerForm.value.role.toLowerCase() == this.user.role.toLowerCase()) {
        //this.openDialog()
        this.router.navigate(['doctor'])
      }
      else {
        // this.dialog.open(WrongDialogComponent);
      }
    })
    //this.registerForm.reset()
  }
  openDialog() {
    // this.dialog.open(DialogComponent);
  }
}

