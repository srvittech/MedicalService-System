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

  listOfDoctors:any = []
  constructor(private httpClient:HttpClient) { }

  addDoctor(form:any){
    return this.httpClient.post("http://localhost:8989/doctor/addDoctor",form)
  }
  getDoctors(){
    return this.httpClient.get("http://localhost:8989/doctor/getDoctors")
  }
  findDoctorById(id:any){
    return this.httpClient.get("http://localhost:8989/doctor/findDoctorById/"+id)
  }
  findBySpecialization(specialization:any){
    return this.httpClient.get("http://localhost:8989/doctor/getSpecialization/"+specialization)
  }
  updateDoctor(form:any){
    return this.httpClient.put("http://localhost:8989/doctor/updateDoctor/",form)
  }
  deleteDoctorById(id:any){
    return this.httpClient.delete("http://localhost:8989/doctor/deleteDoctorById/"+id)
  }
 
}
