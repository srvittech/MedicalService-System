import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddKioskDialogComponent } from './add-kiosk-dialog.component';

describe('AddKioskDialogComponent', () => {
  let component: AddKioskDialogComponent;
  let fixture: ComponentFixture<AddKioskDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddKioskDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddKioskDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
