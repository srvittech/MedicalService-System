import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { FeedbackServiceService } from 'src/app/services/feedback-Service/feedback-service.service';

@Component({
  selector: 'app-prescription-dialog',
  templateUrl: './prescription-dialog.component.html',
  styleUrls: ['./prescription-dialog.component.css']
})
export class PrescriptionDialogComponent {
  public feedbackForm !: FormGroup;
  submitted =false
  constructor(private formBuilder: FormBuilder){}
  ngOnInit(): void {
    this.feedbackForm = this.formBuilder.group({
    description: ['', Validators.required]
  })

}
submit(){
  this.submitted=true
  if (!this.feedbackForm.invalid){
    //this.feedbackService.addFeedback(this.feedbackForm.value).subscribe(res => {
      //console.log("Feedback Added");
    //})
    alert("Prescription Added Successfully")
  }
}

}
