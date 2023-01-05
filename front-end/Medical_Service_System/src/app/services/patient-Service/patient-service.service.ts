import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PatientServiceService {

  constructor(private httpClient:HttpClient) { }

  addPatient(form:any){
    return this.httpClient.post("http://localhost:9098/addpatient",form)
  }
}
