import { Component, OnInit } from '@angular/core';
import { FeedbackServiceService } from 'src/app/services/feedback-Service/feedback-service.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit{
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
