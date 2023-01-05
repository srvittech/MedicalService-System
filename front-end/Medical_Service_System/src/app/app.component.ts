import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  styles :['#links.active{color:#001253}']
})
export class AppComponent implements OnInit{
  title = 'Medical_Service_System';
  
  constructor(){

  }
  ngOnInit(): void {
      
  }


}
