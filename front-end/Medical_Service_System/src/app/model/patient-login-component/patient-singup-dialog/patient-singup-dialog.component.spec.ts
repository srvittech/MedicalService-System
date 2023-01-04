import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientSingupDialogComponent } from './patient-singup-dialog.component';

describe('PatientSingupDialogComponent', () => {
  let component: PatientSingupDialogComponent;
  let fixture: ComponentFixture<PatientSingupDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientSingupDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientSingupDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
