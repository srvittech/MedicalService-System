import { HttpClient } from '@angular/common/http';

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FeedbackServiceService {

  constructor(private httpClient:HttpClient) { }
 
  addFeedback(form:any){
    return this.httpClient.post("http://localhost:8989/feedback/addFeedback",form)
  }
  getAllFeedback(){
    return this.httpClient.get("http://localhost:8989/feedback/getFeedbacks")
  }
  updateFeedback(form:any){
    return this.httpClient.put("http://localhost:8989/feedback/updateFeedback",form)
  }
  findFeedbackById(id:any){
    return this.httpClient.get("http://localhost:8989/feedback/findFeedback/"+id)
  }
}
