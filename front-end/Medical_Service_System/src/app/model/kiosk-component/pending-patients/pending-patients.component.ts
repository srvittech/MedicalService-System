import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TransactionServiceService } from 'src/app/services/transaction-Service/transaction-service.service';

@Component({
  selector: 'app-pending-patients',
  templateUrl: './pending-patients.component.html',
  styleUrls: ['./pending-patients.component.css']
})
export class PendingPatientsComponent {

  pendingTransactions: any
  flag: any

  roles:any=["Forward to Doctor"]

  constructor(private transactionService: TransactionServiceService, private formBuilder: FormBuilder) {
    this.pendingTransactions = this.transactionService.allPendingTransactions
  }

  registerForm!: FormGroup
  submitted = false;
  loginType: any = ""

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      id: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role: ['', Validators.required]
    })
  }
  submit(){
    
  }

}
