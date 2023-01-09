import { Component } from '@angular/core';
import { FeedbackServiceService } from 'src/app/services/feedback-Service/feedback-service.service';

@Component({
  selector: 'app-view-feedback',
  templateUrl: './view-feedback.component.html',
  styleUrls: ['./view-feedback.component.css']
})
export class ViewFeedbackComponent {
  constructor(private feedbackService:FeedbackServiceService){}
  ngOnInit(): void {
    this.getAllFeedback()
  }
  
  user: any = {
    feedbackId: null,
    patientId: null,
    patientName: null,
    description: null,
    solution:null
  }
  getAllFeedback(){
    this.feedbackService.getAllFeedback().subscribe(res=>{
      this.user=res
      console.log(res)
    })
  }
}