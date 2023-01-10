import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, tap } from 'rxjs';
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
  private refreshTransactions = new Subject<void>();
  get refresh(){
   return this.refreshTransactions
  }
  getPatient():Observable<object>{
    return this.httpClient.get("http://localhost:8989/patient/getpatient")
  }

  addPatient(patient:any):Observable<object>{
<<<<<<< HEAD
    return this.httpClient.post("http://localhost:8989/patient/addpatient",patient)
=======
    return this.httpClient.post("http://localhost:9098/addpatient",patient).pipe(tap(()=>{
        this.refresh.next();
       })
      )
>>>>>>> origin/sourav
  }

  findPatientById(id:any):Observable<object>{
    return this.httpClient.get("http://localhost:8989/patient/findPatientById/"+id)
  }
  findPatientByEmail(email:any):Observable<object>{
    return this.httpClient.get("http://localhost:8989/patient/findPatientByEmail/"+email)
  }

  updatePatient(patient:any):Observable<object>{
<<<<<<< HEAD
    return this.httpClient.put("http://localhost:8989/patient/updatePatient",patient)
=======
    return this.httpClient.put("http://localhost:9098/updatePatient",patient).pipe(tap(()=>{
      this.refresh.next();
     })
    )
>>>>>>> origin/sourav
  }

  DeleteById(id:any):Observable<object>{
    return this.httpClient.get("http://localhost:8989/patient/deletePatientById/"+id)
  }
}