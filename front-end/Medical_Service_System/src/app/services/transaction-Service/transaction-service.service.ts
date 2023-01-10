import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransactionServiceService {
  constructor(private httpClient: HttpClient) { }

  allTransactions:any= []
  allPendingTransactions:any= []
  myCurrentTransactionId:any

  // add this in your service ----------------------------------------------

 private refreshTransactions = new Subject<void>();

 get refresh(){
  return this.refreshTransactions
 }

// add the below code in add and update methods after post(). and put().

//  .pipe(tap(()=>{
//   this.refresh.next();
// })
// )

// add and update ends-------------------------------------------------

//  upto here ---------------------------------------------------------------------------------

  addTransaction(transaction: any) {
    return this.httpClient.post("http://localhost:7091/addTransaction", transaction).pipe(tap(()=>{
      this.refresh.next();
    })
    )
  }
  getAllTransaction() {
    return this.httpClient.get("http://localhost:8989/transaction/getAllTransaction")
  }
  getTransactionBasedOnStatus(status: any) {
    return this.httpClient.get("http://localhost:8989/transaction/getTransactionBasedOnStatus/"+status)
  }
  getTransactionByDoctorId(doctorId: any) {
    return this.httpClient.get("http://localhost:8989/transaction/getTransactionByDoctorId/"+doctorId)
  }
  getTransactionByPatientId(patientId: any) {
    return this.httpClient.get("http://localhost:8989/transaction/getTransactionByPatientId/"+patientId)
  }
  getTransactionByTransactionId(transactionId: any) {
    return this.httpClient.get("http://localhost:8989/transaction/getTransactionByTransactionId/"+transactionId)
  }
  updateTransaction(transaction: any) {
    return this.httpClient.put("http://localhost:8989/transaction/updateTransaction",transaction).pipe(tap(()=>{
      this.refresh.next();
    }))
  }
}
