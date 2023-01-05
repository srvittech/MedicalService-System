import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {
  registerForm!: FormGroup
  submitted = false;
  loginType: any = ""
  constructor(public dialog: MatDialog, public router: Router, private formBuilder: FormBuilder) {

  }
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      userId: ['',Validators.required ],
      password:['', [Validators.required,Validators.minLength(6)]],
      role: ['', Validators.required]
    })

  }
  id: any = "user";
  pass: any = "root123";
  /*registerForm = new registerFormGroup({
    userId: new registerFormControl(""),
    password: new registerFormControl(""),
    role: new registerFormControl("")
  })*/
  roles: any = ["Admin", "Kiosk", "Doctor"]

  submit() {
    this.submitted = true
    if (this.registerForm.invalid){return 
    }alert("Success")
      if (this.id == this.registerForm.value.userId && this.pass == this.registerForm.value.password && this.registerForm.value.role == "Admin") {
        this.openDialog()
        this.router.navigate(['admin'])
      }
      else if (this.id == this.registerForm.value.userId && this.pass == this.registerForm.value.password && this.registerForm.value.role == "Kiosk") {
        this.openDialog()
        this.router.navigate(['kiosk'])

      }
      else if (this.id == this.registerForm.value.userId && this.pass == this.registerForm.value.password && this.registerForm.value.role == "Doctor") {
        this.openDialog()
        this.router.navigate(['doctor'])
      }
      else {
        // this.dialog.open(WrongDialogComponent);
      }
    //this.registerForm.reset()
  }
  openDialog() {
    // this.dialog.open(DialogComponent);
  }
}
