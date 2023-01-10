import { Component, OnInit } from '@angular/core';
import { FeedbackServiceService } from 'src/app/services/feedback-Service/feedback-service.service';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  constructor(private transactionService: TransactionServiceService) { }
  ngOnInit(): void {
    this.getAllFeedback()
  }

  user: any = {
    feedbackId: null,
    patientId: null,
    patientName: null,
    description: null,
    solution: null
  }
  getAllFeedback() {
    this.transactionService.getAllTransaction().subscribe(res => {
      this.user = res
      console.log(res)
    })
  }

}
