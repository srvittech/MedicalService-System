import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private httpClient:HttpClient) { }
  user: any = {
    id:null,
    password:null,
    role:null,
    userName:null
  }

  addLogin(form:any){
    return this.httpClient.post("http://localhost:9091/addLogin",form)
  }
  getLogin(id:any){
    return this.httpClient.get("http://localhost:9091/getLogin/"+id)
  }
}
