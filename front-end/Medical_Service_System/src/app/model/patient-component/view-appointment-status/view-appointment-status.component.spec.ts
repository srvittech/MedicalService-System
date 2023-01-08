import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAppointmentStatusComponent } from './view-appointment-status.component';

describe('ViewAppointmentStatusComponent', () => {
  let component: ViewAppointmentStatusComponent;
  let fixture: ComponentFixture<ViewAppointmentStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAppointmentStatusComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewAppointmentStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
