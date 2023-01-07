import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TransactionServiceService {
  constructor(private httpClient: HttpClient) { }
  addTransaction(transaction: any) {
    return this.httpClient.post("http://localhost:7091/addTransaction", transaction)
  }
  getAllTransaction() {
    return this.httpClient.get("http://localhost:7091/getAllTransaction")
  }
  getTransactionBasedOnStatus(status: any) {
    return this.httpClient.get("http://localhost:7091/getTransactionBasedOnStatus/"+status)
  }
  getTransactionByDoctorId(doctorId: any) {
    return this.httpClient.get("http://localhost:7091/getTransactionByDoctorId/"+doctorId)
  }
  getTransactionByPatientId(patientId: any) {
    return this.httpClient.get("http://localhost:7091/getTransactionByPatientId/"+patientId)
  }
  getTransactionByTransactionId(transactionId: any) {
    return this.httpClient.get("http://localhost:7091/getTransactionByTransactionId/"+transactionId)
  }
  updateTransaction(transaction: any) {
    return this.httpClient.put("http://localhost:7091/updateTransaction",transaction)
  }
}
