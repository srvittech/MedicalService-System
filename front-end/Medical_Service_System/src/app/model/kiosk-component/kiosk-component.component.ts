import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';

@Component({
  selector: 'app-kiosk-component',
  templateUrl: './kiosk-component.component.html',
  styleUrls: ['./kiosk-component.component.css']
})

export class KioskComponentComponent implements OnInit {
  ngOnInit(): void {
  }
  constructor(private route: ActivatedRoute, private router: Router, private transactionService: TransactionServiceService
    ,private doctorService:DoctorServiceService) {
    this.fetchAllTransacationFromDatabase()
    this.fetchPendingTransacationFromDatabase()
    this.fetchDoctorListFromDatabase()

  }
  fetchAllTransacationFromDatabase() {
    this.transactionService.getAllTransaction().subscribe(res => {
      this.transactionService.allTransactions = res
    })
  }
  fetchPendingTransacationFromDatabase() {
    this.transactionService.allTransactions = this.transactionService.getTransactionBasedOnStatus("pending").subscribe(res => {
      this.transactionService.allPendingTransactions = res
    })
  }
  fetchDoctorListFromDatabase() {
    this.doctorService.listOfDoctors = this.doctorService.getDoctors().subscribe(res => {
      this.doctorService.listOfDoctors= res
    })

  }
  showAllAppointments() {
    this.router.navigate(['patientappointment'], { relativeTo: this.route });
    this.ngOnInit()
  }
  showPendingAppointments() {
    this.router.navigate(['pendingApp'], { relativeTo: this.route });
    this.ngOnInit()
  }
  showPatientList() {
    this.router.navigate(['doctoravail'], { relativeTo: this.route });
  }
  showFeedback() {
    this.router.navigate(['feedback'], { relativeTo: this.route });
  }

}

