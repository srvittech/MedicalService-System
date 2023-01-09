import { Component, OnInit } from '@angular/core';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';

@Component({
  selector: 'app-patient-appointments',
  templateUrl: './patient-appointments.component.html',
  styleUrls: ['./patient-appointments.component.css']
})
export class PatientAppointmentsComponent implements OnInit {
 allTransactionsResult: any

  constructor(private transactionService: TransactionServiceService) {
    

  }
  ngOnInit(): void {
    this.transactionService.refresh.subscribe((res) => {
      this.fetchData()
    })
    this.fetchData()
  }

  fetchData(){
    this.transactionService.getAllTransaction().subscribe(res=>{
      this.allTransactionsResult = res
    })
  }
}
