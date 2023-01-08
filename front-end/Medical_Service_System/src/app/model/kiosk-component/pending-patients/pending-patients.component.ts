import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';

@Component({
  selector: 'app-pending-patients',
  templateUrl: './pending-patients.component.html',
  styleUrls: ['./pending-patients.component.css']
})
export class PendingPatientsComponent {

  pendingTransactions: any
  doctorsList:any=[]

  constructor(private transactionService: TransactionServiceService, private formBuilder: FormBuilder,private doctorService:DoctorServiceService) {
    this.pendingTransactions = this.transactionService.allPendingTransactions
    this.doctorsList = this.doctorService.listOfDoctors
  }

  registerForm!: FormGroup
  submitted = false;
  loginType: any = ""
  doctorAssignedId:any=""

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      id: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role: ['', Validators.required]
    })
  }
  submit(transId:any){
    console.log(this.doctorAssignedId);
    
  }

}
