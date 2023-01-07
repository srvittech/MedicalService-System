import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientLoginComponentComponent } from './patient-login-component.component';

describe('PatientLoginComponentComponent', () => {
  let component: PatientLoginComponentComponent;
  let fixture: ComponentFixture<PatientLoginComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientLoginComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientLoginComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
