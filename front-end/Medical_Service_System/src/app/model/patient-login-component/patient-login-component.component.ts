import { Component } from '@angular/core';
import { FormGroup,FormBuilder ,Validators} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';

import { PatientSingupDialogComponent } from './patient-singup-dialog/patient-singup-dialog.component';

@Component({
  selector: 'app-patient-login-component',
  templateUrl: './patient-login-component.component.html',
  styleUrls: ['./patient-login-component.component.css']
})
export class PatientLoginComponentComponent {
  registerForm!: FormGroup
  submitted = false;
  loginType:any=""
  constructor(public dialog: MatDialog,public router:Router,private formBuilder:FormBuilder){

  }
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      userId: ['',Validators.required ],
      password:['', [Validators.required,Validators.minLength(6)]]
    })
  }
  id:any="user";
  pass:any="root123";
  /*registerForm = new registerFormGroup({
    userId: new registerFormControl(""),
    password: new registerFormControl("")
  })*/

  roles:any=["Admin","Kiosk","Doctor"]
  
  submit(){
    this.submitted = true
    if (this.registerForm.invalid){return}
    alert("Success")
    if(this.id==this.registerForm.value.userId&&this.pass==this.registerForm.value.password){
      // this.openDialog()
      this.router.navigate(['patient'])
    }
    else{
      // this.dialog.open(WrongDialogComponent);
    }
    //this.registerForm.reset()
}
openDialog(){
  this.dialog.open(PatientSingupDialogComponent);
}
}
