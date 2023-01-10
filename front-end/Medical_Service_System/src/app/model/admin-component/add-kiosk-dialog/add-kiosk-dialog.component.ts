import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/services/user-Service/user-service.service';
import { PopUpComponent } from '../../pop-up/pop-up.component';

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

  m1:any = ""
  m2:any = ""
flag:boolean = false

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
      this.userService.addLogin(this.signupForm.value).subscribe(res=>{
        console.log("Kiosk Added");
        this.flag = true
      })
      console.table(this.signupForm.value);
    this.dialog.closeAll()
    }

    setTimeout(()=>{    
      if (this.flag) {
        this.m1 = "Kiosk Added"
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


