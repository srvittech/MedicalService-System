import { Component } from '@angular/core';
<<<<<<< HEAD
import { PatientServiceService } from 'src/app/services/patient-Service/patient-service.service';
=======
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';


>>>>>>> origin/lakshman
@Component({
  selector: 'app-patient-component',
  templateUrl: './patient-component.component.html',
  styleUrls: ['./patient-component.component.css']
})


export class PatientComponentComponent{
<<<<<<< HEAD
  user: any = {
    address: null,age:null,
    disease:null,
    email:null,
    id:null,
    mobile:null,
    name:null,
    weight:null
  }
  constructor(private patientService:PatientServiceService){
    this.user = this.patientService.patient
  }
=======
  registerForm!: FormGroup
  submitted = false;
  loginType: any = ""
  constructor(private route:ActivatedRoute,public dialog: MatDialog, public router: Router, private formBuilder: FormBuilder) {

    
>>>>>>> origin/lakshman
}


ngOnInit(): void {
  this.registerForm = this.formBuilder.group({
    age: ['',Validators.required ],
    address: ['', Validators.required],
    disease:['', Validators.required],
    
    weight: ['',Validators.required ]
  })}
  submit() {
    this.submitted = true
    if (this.registerForm.invalid){return 
    }alert("Success")
  }

  
  showFeedback(){
    this.router.navigate(['feedback'],{relativeTo:this.route});
  }
    
}
