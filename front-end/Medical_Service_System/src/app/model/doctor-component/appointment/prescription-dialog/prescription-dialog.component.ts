import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { FeedbackServiceService } from 'src/app/services/feedback-Service/feedback-service.service';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';

@Component({
  selector: 'app-prescription-dialog',
  templateUrl: './prescription-dialog.component.html',
  styleUrls: ['./prescription-dialog.component.css']
})
export class PrescriptionDialogComponent {

  // private Long transactionId;
  // private Long patientId;
  // private String patientName;
  // private int patientAge;
  // private String patientAddress;
  // private String disease;
  // private int patientweight;
  // private Long doctorId;
  // private String status = "pending";
  // private String prescription;
  // private String dateOfRequest;
  // private String dateOfTreatment;
  public prescriptionForm !: FormGroup;
  submitted = false
  myDate: any = ""


  constructor(private dialog:MatDialog,private formBuilder: FormBuilder, private transactionService: TransactionServiceService, private datePipe: DatePipe) { }
  ngOnInit(): void {
    this.prescriptionForm = this.formBuilder.group({
      transactionId: [this.transactionService.myCurrentTransactionId],
      status:['Doctor given prescription'],
      prescription: ['', Validators.required],
      dateOfTreatment: [this.generateDate()]
    })
    // this.transactionService.refresh.subscribe((res) => {
    //   this.updatePrescription()
    // })

  }
  submit() {
    this.submitted = true
    if (!this.prescriptionForm.invalid) {
      this.updatePrescription()
      console.table(this.prescriptionForm.value);

      alert("Prescription Added Successfully")
      this.dialog.closeAll()
    }
  }

  generateDate() {
    this.myDate = this.datePipe.transform(new Date(), 'yyyy-MM-dd');
   return this.myDate
  }

  updatePrescription() {
    this.transactionService.updateTransaction(this.prescriptionForm.value).subscribe(res => {

    })
  }
  close() {
    this.dialog.closeAll()
  }

}
