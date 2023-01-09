import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent {
  prescription: any = ""
  forwardedTransactions: any
  myDoctorId: any = ""
  updatedTransactionFormByDoctor: any = {}
  constructor(private dialog:MatDialog,private route: ActivatedRoute, private router: Router,private transactionService: TransactionServiceService, private formBuilder: FormBuilder, private doctorService: DoctorServiceService) {
    this.myDoctorId = this.doctorService.user.id
  }

  ngOnInit(): void {
    // as per your service use the below code----------------------

    this.transactionService.refresh.subscribe((res) => {
      this.fetchData()
    })

    this.fetchData()
    //upto here -------------------------------------------------------------
  }

  // this.transactionId = transactionId;
  // this.patientId = patientId;
  // this.doctorId = doctorId;
  // this.disease = disease;
  // this.status = status;
  // this.prescription = prescription;
  // this.dateOfRequest = dateOfRequest;
  // this.dateOfTreatment = dateOfTreatment;

  submit(transId: any) {
    this.updatedTransactionFormByDoctor['transactionId'] = transId
    this.updatedTransactionFormByDoctor['prescription'] = this.prescription
    this.transactionService.updateTransaction(this.updatedTransactionFormByDoctor).subscribe(res => {
    })
  }

  // important below -------- make sure which variabeles are used inside html and put it inside the below method
  // call this method from ngOnINit
  fetchData() {
    this.transactionService.getTransactionByDoctorId(this.myDoctorId).subscribe(res => {
      this.forwardedTransactions = res
    })
  }

  // upto here --------------------------------------------------------------------




}
