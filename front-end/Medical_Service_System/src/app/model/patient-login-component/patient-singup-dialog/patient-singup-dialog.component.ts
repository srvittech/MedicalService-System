import { Component } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-patient-singup-dialog',
  templateUrl: './patient-singup-dialog.component.html',
  styleUrls: ['./patient-singup-dialog.component.css']
})
export class PatientSingupDialogComponent {
  public signupForm !: FormGroup;

  constructor(private formBuilder : FormBuilder,private router:Router) {}

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      name:[''],
      email:[''],
      password:[''],
      mobile:['']
    })
    
  }
    signup(){
      
        
    }


}
