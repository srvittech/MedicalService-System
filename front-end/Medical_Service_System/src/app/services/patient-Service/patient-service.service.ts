import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class PatientServiceService {

  constructor(private httpClient:HttpClient) { }
  patient: any = {
    address: null,age:null,
    disease:null,
    email:null,
    id:null,
    mobile:null,
    name:null,
    weight:null
  }
  addPatient(form:any):Observable<object>{
    return this.httpClient.post("http://localhost:9098/addpatient",form)
  }

  getPatientByEmail(email:any):Observable<object>{
    return this.httpClient.get("http://localhost:9098/findPatientByEmail/"+email)
  }
  updatePatient(form:any):Observable<object>{
    return this.httpClient.put("http://localhost:9098//updatePatient",form)
  }
}
