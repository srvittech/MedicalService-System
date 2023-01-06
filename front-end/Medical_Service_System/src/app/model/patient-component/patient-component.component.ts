import { Component } from '@angular/core';
import { PatientServiceService } from 'src/app/services/patient-Service/patient-service.service';
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-patient-component',
  templateUrl: './patient-component.component.html',
  styleUrls: ['./patient-component.component.css']
})


export class PatientComponentComponent{
  user: any = {
    address: null,age:null,
    disease:null,
    email:null,
    id:null,
    mobile:null,
    name:null,
    weight:null
  }

  registerForm!: FormGroup
  submitted = false;
  loginType: any = ""
  constructor(private patientService:PatientServiceService,private route:ActivatedRoute,public dialog: MatDialog, public router: Router, private formBuilder: FormBuilder) {
    this.user = this.patientService.patient
    
}


ngOnInit(): void {
  this.registerForm = this.formBuilder.group({
    id:[this.user.id],
    age: ['',Validators.required ],
    address: ['', Validators.required],
    disease:['', Validators.required],
    weight: ['',Validators.required ]
  })}
  submit() {
    this.submitted = true
    if (this.registerForm.invalid){return 
    }
    this.patientService.updatePatient(this.registerForm.value).subscribe(res=>{
      console.table(res);
    })

    alert("Success")
  }

  
  showFeedback(){
    this.router.navigate(['feedback'],{relativeTo:this.route});
  }
    
}
