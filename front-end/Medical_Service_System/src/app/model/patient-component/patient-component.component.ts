import { Component } from '@angular/core';
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-patient-component',
  templateUrl: './patient-component.component.html',
  styleUrls: ['./patient-component.component.css']
})


export class PatientComponentComponent{
  registerForm!: FormGroup
  submitted = false;
  loginType: any = ""
  constructor(private route:ActivatedRoute,public dialog: MatDialog, public router: Router, private formBuilder: FormBuilder) {

    
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
