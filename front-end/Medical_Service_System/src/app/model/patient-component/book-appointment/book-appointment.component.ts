import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormGroup,Validators,FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientServiceService } from 'src/app/services/patient-Service/patient-service.service';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';
import { PopUpComponent } from '../../pop-up/pop-up.component';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css']
})
export class BookAppointmentComponent {
  patientTransaction: any = {}
  user: any = {
    address: null, age: null,
    disease: null,
    email: null,
    id: null,
    mobile: null,
    name: null,
    weight: null
  }
  registerForm!: FormGroup
  submitted = false;
  loginType: any = ""
  
  constructor(private patientService: PatientServiceService, private route: ActivatedRoute, public dialog: MatDialog,
    public router: Router, private formBuilder: FormBuilder, private transactionService: TransactionServiceService, private datePipe: DatePipe) {
    this.user = this.patientService.patient
    this.transactionService.addTransaction(this.user)

  }
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      id: [this.user.id],
      age: ['', Validators.required],
      address: ['', Validators.required],
      disease: ['', Validators.required],
      weight: ['', Validators.required]
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

  myDate: any = ""
  generateDate() {
    this.myDate = this.datePipe.transform(new Date(), 'yyyy-MM-dd');
    return this.myDate;
  }

  submit() {
    this.submitted = true
    console.log("hi");
    if (this.registerForm.invalid) {
      return
    }
    this.generateDate()
    console.log(this.registerForm.value);
    this.patientTransaction["patientId"] = this.registerForm.value.id
    this.patientTransaction["patientName"] = this.user.name
    this.patientTransaction["patientAge"] = this.registerForm.value.age
    this.patientTransaction["patientAddress"] = this.registerForm.value.address
    this.patientTransaction["patientweight"] = this.registerForm.value.weight
    this.patientTransaction["disease"] = this.registerForm.value.disease
    this.patientTransaction["dateOfRequest"] = this.myDate
    this.transactionService.addTransaction(this.patientTransaction).subscribe(res=>{
      console.table(res);
      
    })
    this.patientService.updatePatient(this.registerForm.value).subscribe(res => {
      console.table(res);
      this.flag = true
    })

    setTimeout(() => {
      if (this.flag) {
        this.m1 = "Your Appointment Will Be Shortly Fixed With A Doctor"
        this.m2 = "Thanks"
        this.dialog.closeAll()
        console.log("true");

      }
      else {
        this.m1 = "Something Went Wrong"
        this.m2 = "Try Again"
        console.log("false");

      }                       // <<<---using ()=> syntax
      this.openDialog()
    }, 2000);

    this.router.navigate(['/patient'])
  }

 
}
