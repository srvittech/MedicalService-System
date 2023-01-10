import { Component } from '@angular/core';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';

@Component({
  selector: 'app-view-appointments',
  templateUrl: './view-appointments.component.html',
  styleUrls: ['./view-appointments.component.css']
})
export class ViewAppointmentsComponent {
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
