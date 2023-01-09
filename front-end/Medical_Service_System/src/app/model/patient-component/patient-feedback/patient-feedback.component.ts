import { Component,OnInit } from '@angular/core';
import { FormGroup, Validators ,FormBuilder} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { FeedbackServiceService } from 'src/app/services/feedback-Service/feedback-service.service';

@Component({
  selector: 'app-patient-feedback',
  templateUrl: './patient-feedback.component.html',
  styleUrls: ['./patient-feedback.component.css']
})
export class PatientFeedbackComponent implements OnInit {
  public feedbackForm !: FormGroup;
  submitted =false
  constructor(private dialog:MatDialog,private feedbackService:FeedbackServiceService,private formBuilder: FormBuilder){}
  ngOnInit(): void {
    this.feedbackForm = this.formBuilder.group({
    description: ['', Validators.required]
  })

}
submit(){
  this.submitted=true
  if (!this.feedbackForm.invalid){
    this.feedbackService.addFeedback(this.feedbackForm.value).subscribe(res => {
      console.log("Feedback Added");
    })
    alert("Feedback Added Successfully")
  }
}
close(){
  this.dialog.closeAll()
}
}