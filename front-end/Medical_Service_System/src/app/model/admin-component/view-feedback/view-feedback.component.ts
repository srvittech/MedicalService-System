import { Component } from '@angular/core';
import { FeedbackServiceService } from 'src/app/services/feedback-Service/feedback-service.service';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';

@Component({
  selector: 'app-view-feedback',
  templateUrl: './view-feedback.component.html',
  styleUrls: ['./view-feedback.component.css']
})
export class ViewFeedbackComponent {
  constructor(private transactionService:TransactionServiceService){}
  ngOnInit(): void {
    this.getAllFeedback()
    this.transactionService.refresh.subscribe((res)=>{
      this.getAllFeedback()
    })
  }
  
  user: any = {
    feedbackId: null,
    patientId: null,
    patientName: null,
    description: null,
    solution:null
  }
  getAllFeedback(){
    this.transactionService.getAllTransaction().subscribe(res=>{
      this.user=res
      console.log(res)
    })
  }
}