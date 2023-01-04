import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KioskComponentComponent } from './kiosk-component.component';

describe('KioskComponentComponent', () => {
  let component: KioskComponentComponent;
  let fixture: ComponentFixture<KioskComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KioskComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KioskComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
