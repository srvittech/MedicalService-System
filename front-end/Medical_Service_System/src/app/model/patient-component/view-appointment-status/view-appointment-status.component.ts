import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PatientServiceService } from 'src/app/services/patient-Service/patient-service.service';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';
import { PatientFeedbackComponent } from '../patient-feedback/patient-feedback.component';

@Component({
  selector: 'app-view-appointment-status',
  templateUrl: './view-appointment-status.component.html',
  styleUrls: ['./view-appointment-status.component.css']
})
export class ViewAppointmentStatusComponent implements OnInit {
  myTransactions: any = []
  patientId:any = ""
  constructor(private dialog:MatDialog,private transactionService: TransactionServiceService,private patientService:PatientServiceService) {

  }
  ngOnInit(): void {
    this.getPatientId()
    this.fetchMyTransaction()
  }
  fetchMyTransaction() {
    this.transactionService.getTransactionByPatientId(this.patientId).subscribe(res=>{
      this.myTransactions = res
      console.table(this.myTransactions);
    })
  }
 
  getPatientId(){
   this.patientId=this.patientService.patient.id   
  }
  giveFeedback(transId:any){
    this.transactionService.myCurrentTransactionId = transId
    this.dialog.open(PatientFeedbackComponent)
  }





}
