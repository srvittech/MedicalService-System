import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorServiceService } from 'src/app/services/doctor-Service/doctor-service.service';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';
import { PopUpComponent } from '../pop-up/pop-up.component';

@Component({
  selector: 'app-kiosk-component',
  templateUrl: './kiosk-component.component.html',
  styleUrls: ['./kiosk-component.component.css']
})

export class KioskComponentComponent implements OnInit {
  ngOnInit(): void {
  }
  openDialog(): void {
    const dialogRef = this.dialog.open(PopUpComponent, {
      data: {m1:"SuccesFully LoggedOut"},
    });

    dialogRef.afterClosed().subscribe(result => {
      
    })
  }
  constructor( private dialog: MatDialog,private route: ActivatedRoute, private router: Router, private transactionService: TransactionServiceService
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
  showFeedback() {
    this.router.navigate(['feedback'], { relativeTo: this.route });
  }
  logout(){
    this.router.navigate(['/about']);
    this.openDialog()
  }

}

