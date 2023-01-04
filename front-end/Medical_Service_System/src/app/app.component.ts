import { Component, OnInit } from '@angular/core';
import { InternalService } from './services/internalService/internal.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Medical_Service_System';
  colorLight: any = "#3E6D9C"
  colorDark: any = "#001253"
  colorDiary: any = {
    about: this.colorDark,
    doctor: this.colorLight,
    patient: this.colorLight,
    kiosk: this.colorLight,
    admin: this.colorLight
  }
  constructor(private internalService:InternalService){

  }
  ngOnInit(): void {
      
  }

  changeColor(component: any) {
    for (let i in this.colorDiary) {
      if (component == i) {
        this.colorDiary[i] = this.colorDark
      }
      else {
        this.colorDiary[i] = this.colorLight
      }
    }
    this.internalService.loginType = component
    this.ngOnInit()
  }

}
