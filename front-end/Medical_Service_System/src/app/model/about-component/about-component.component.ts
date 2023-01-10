import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-about-component',
  templateUrl: './about-component.component.html',
  styleUrls: ['./about-component.component.css']
})
export class AboutComponentComponent {

  constructor(private routes:Router){

  }
  login(){
this.routes.navigate(['sidebar'])
  }
}
