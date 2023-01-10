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
    return this.httpClient.post("http://localhost:8989/user/addLogin",form)
  }
  getLogin(id:any){
    return this.httpClient.get("http://localhost:8989/user/getLogin/"+id)
  }
  updateLogin(form:any){
    return this.httpClient.put("http://localhost:8989/user/updateLogin",form)
  }
}
