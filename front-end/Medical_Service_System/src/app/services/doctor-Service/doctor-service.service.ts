import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DoctorServiceService {
  user: any = {
    id: null,
    password: null,
    role: null,
    userName: null
  }
  constructor(private httpClient:HttpClient) { }

  addDoctor(form:any){
    return this.httpClient.post("http://localhost:9092/addDoctor",form)
  }
  findDoctorById(id:any){
    return this.httpClient.get("http://localhost:9092/findDoctorById/"+id)
  }
}
