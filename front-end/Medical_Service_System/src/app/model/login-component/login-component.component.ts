import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { InternalService } from 'src/app/services/internalService/internal.service';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit{
 loginType:any=""
  constructor(public dialog: MatDialog,public router:Router,private internalService:InternalService){
    this.loginType=this.internalService.loginType
  }
  ngOnInit(): void {
    
  }
  id:any="user";
  pass:any="root123";
  form = new FormGroup({
    userId: new FormControl(""),
    password: new FormControl(""),
    role: new FormControl("")
  })
  roles:any=["Admin","Kiosk","Doctor"]

  submit(){
    if(this.id==this.form.value.userId&&this.pass==this.form.value.password&&this.form.value.role=="Admin"){
      this.openDialog()
      this.router.navigate(['admin'])
    }
    else if(this.id==this.form.value.userId&&this.pass==this.form.value.password&&this.form.value.role=="Kiosk"){
      this.openDialog()
      this.router.navigate(['kiosk'])
   
    }
    else if(this.id==this.form.value.userId&&this.pass==this.form.value.password&&this.form.value.role=="Doctor"){
      this.openDialog()
      this.router.navigate(['doctor'])
    }
    else{
      // this.dialog.open(WrongDialogComponent);
    }
    this.form.reset()
}
openDialog(){
  // this.dialog.open(DialogComponent);
}
}
