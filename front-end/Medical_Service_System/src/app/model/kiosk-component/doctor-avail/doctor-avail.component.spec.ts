import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorAvailComponent } from './doctor-avail.component';

describe('DoctorAvailComponent', () => {
  let component: DoctorAvailComponent;
  let fixture: ComponentFixture<DoctorAvailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoctorAvailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoctorAvailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
