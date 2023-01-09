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
  doctorAssigned: any = ""
  updatedTransactionFormByKiosk: any = {}
  flag:boolean = true
  doctorNameGen:any =""
  doctorSpecializationGen:any = ""
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
    this.fetchDoctorNameFromDoctorAssigned() 
    this.fetchDoctorSpecializationFromDoctorAssigned()
    this.updatedTransactionFormByKiosk['transactionId'] = transId
    this.updatedTransactionFormByKiosk['doctorName'] = this.doctorNameGen.trim()
    this.updatedTransactionFormByKiosk['doctorSpecialization'] = this.doctorSpecializationGen.trim()
    this.updatedTransactionFormByKiosk['doctorId'] = this.doctorIdGen.trim()
    this.updatedTransactionFormByKiosk['status'] = "Forwarded to Doctor"
    console.table(this.updatedTransactionFormByKiosk);
    
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
    this.doctorIdGen = this.doctorAssigned.split('||')[1]
  
  }

  fetchDoctorNameFromDoctorAssigned() {
    this.doctorNameGen =  this.doctorAssigned.split('||')[2]
    
  }
  fetchDoctorSpecializationFromDoctorAssigned() {
    this.doctorSpecializationGen = this.doctorAssigned.split('||')[3]
  }

  selectedData(event: any) {
   
    this.flag = false
    this.doctorAssigned = event.target.value;
  }

}
