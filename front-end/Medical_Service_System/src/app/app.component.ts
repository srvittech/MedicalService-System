import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
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

  changeColor(component: any) {
    for (let i in this.colorDiary) {
      if (component == i) {
        this.colorDiary[i] = this.colorDark
      }
      else {
        this.colorDiary[i] = this.colorLight
      }
    }
  }

}
