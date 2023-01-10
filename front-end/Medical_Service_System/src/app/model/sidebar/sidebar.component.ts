import { Component } from '@angular/core';
import { ActivatedRoute, Router, Routes } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {
  constructor(private route: ActivatedRoute, private router: Router,) {

  }
  flag = true
  openLogin() {
    this.flag = false
    this.router.navigate(['login'], { relativeTo: this.route });

  }
  openLoginPatient() {
    this.flag = false
    this.router.navigate(['loginpatient'], { relativeTo: this.route });
  }


}
