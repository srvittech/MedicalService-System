import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private httpClient:HttpClient) { }

  addLogin(form:any){
    return this.httpClient.post("http://localhost:9091/addLogin",form)
  }
  getLogin(id:any){
    return this.httpClient.get("http://localhost:9091/addLogin/"+id)
  }
}
