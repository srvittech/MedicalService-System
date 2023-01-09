import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';

@Component({
  selector: 'app-pending-patients',
  templateUrl: './pending-patients.component.html',
  styleUrls: ['./pending-patients.component.css']
})
export class PendingPatientsComponent implements OnInit {

  pendingTransactions: any
  doctorsList: any = []
  doctorIdGen: any = ""
  registerForm!: FormGroup
  submitted = false;
  loginType: any = ""
  doctorAssignedId: any = ""
  updatedTransactionFormByKiosk: any = {}
  flag:boolean = true
  constructor(private transactionService: TransactionServiceService, private formBuilder: FormBuilder, private doctorService: DoctorServiceService) {

  }

  ngOnInit(): void {

    this.registerForm = this.formBuilder.group({
      id: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role: ['', Validators.required]
    })

    // as per your service use the below code----------------------

    this.transactionService.refresh.subscribe((res)=>{
      this.fetchData()
    })

    this.fetchData()
    //upto here -------------------------------------------------------------
  }



  submit(transId: any) {
    this.fetchDoctorIdFromDoctorAssigned()
    this.updatedTransactionFormByKiosk['transactionId'] = transId
    this.updatedTransactionFormByKiosk['doctorId'] = this.doctorIdGen
    this.updatedTransactionFormByKiosk['doctorName'] = this.doctorIdGen
    this.updatedTransactionFormByKiosk['status'] = "Forwarded to Doctor"
    this.transactionService.updateTransaction(this.updatedTransactionFormByKiosk).subscribe(res => {
    })
  }

// important below -------- make sure which variabeles are used inside html and put it inside the below method
// call this method from ngOnINit
  fetchData() {
    this.transactionService.getTransactionBasedOnStatus("pending").subscribe(res=>{
      this.pendingTransactions = res
    })
   this.doctorService.getDoctors().subscribe(res=>{
    this.doctorsList = res
    })
  }

  // upto here --------------------------------------------------------------------



  fetchDoctorIdFromDoctorAssigned() {
    this.doctorIdGen = this.doctorAssignedId.split(' ')[3]
  }

  selectedData(event: any) {
    console.log(this.doctorAssignedId);
    this.flag = false
    this.doctorAssignedId = event.target.value;
  }

}
