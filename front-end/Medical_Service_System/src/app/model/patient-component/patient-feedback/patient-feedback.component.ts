import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { FeedbackServiceService } from 'src/app/services/feedback-Service/feedback-service.service';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';
import { PopUpComponent } from '../../pop-up/pop-up.component';

@Component({
  selector: 'app-patient-feedback',
  templateUrl: './patient-feedback.component.html',
  styleUrls: ['./patient-feedback.component.css']
})
export class PatientFeedbackComponent implements OnInit {
  m1: any = ""
  m2: any = ""
  flag: boolean = false

  openDialog(): void {
    const dialogRef = this.dialog.open(PopUpComponent, {
      data: { m1: this.m1, m2: this.m2 },
    });

    dialogRef.afterClosed().subscribe(result => {

    })
  }
  openDialogLogout(): void {
    const dialogRef = this.dialog.open(PopUpComponent, {
      data: {m1:"SuccesFully LoggedOut"},
    });

    dialogRef.afterClosed().subscribe(result => {
      
    })
  }

  public feedbackForm !: FormGroup;
  myCurrentTransactionId: any = ""
  submitted = false
  constructor(private dialog: MatDialog, private transactionService: TransactionServiceService, private formBuilder: FormBuilder) { }
  ngOnInit(): void {
    this.feedbackForm = this.formBuilder.group({
      transactionId: [this.transactionService.myCurrentTransactionId],
      feedback: ['', Validators.required]
    })

  }
  submit() {
    this.submitted = true
    console.log("hi");

    console.table(this.feedbackForm.value);

    if (!this.feedbackForm.invalid) {
      this.transactionService.updateTransaction(this.feedbackForm.value).subscribe(res => {
        this.flag = true
        this.dialog.closeAll()
      })
    }
    setTimeout(() => {
      if (this.flag) {
        this.m1 = "Feedback Added Successfully"
        this.m2 = "Thanks"
        this.dialog.closeAll()
        console.log("true");

      }
      else {
        this.m1 = "Something Went Wrong"
        this.m2 = "Try Again"
        console.log("false");

      }                       // <<<---using ()=> syntax
      this.openDialog()
    }, 2000);

  }
  close() {
    this.dialog.closeAll()
    this.openDialogLogout()
  }
}