import { Component,OnInit } from '@angular/core';
import { FormGroup, Validators ,FormBuilder} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { FeedbackServiceService } from 'src/app/services/feedback-Service/feedback-service.service';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';

@Component({
  selector: 'app-patient-feedback',
  templateUrl: './patient-feedback.component.html',
  styleUrls: ['./patient-feedback.component.css']
})
export class PatientFeedbackComponent implements OnInit {
  public feedbackForm !: FormGroup;
  myCurrentTransactionId:any = ""
  submitted =false
  constructor(private dialog:MatDialog,private transactionService:TransactionServiceService,private formBuilder: FormBuilder){}
  ngOnInit(): void {
    this.feedbackForm = this.formBuilder.group({
      transactionId:[this.transactionService.myCurrentTransactionId],
      feedback: ['', Validators.required]
  })

}
submit(){
  this.submitted=true
  console.log("hi");
  
  console.table(this.feedbackForm.value);
  
  if (!this.feedbackForm.invalid){
    this.transactionService.updateTransaction(this.feedbackForm.value).subscribe(res=>{
      alert("Feedback Added Successfully")
      this.dialog.closeAll()
    })
  }

}
close(){
  this.dialog.closeAll()
}
}