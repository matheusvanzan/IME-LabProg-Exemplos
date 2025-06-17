import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountSignalComponent } from './count-signal.component';

describe('CountSignalComponent', () => {
  let component: CountSignalComponent;
  let fixture: ComponentFixture<CountSignalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CountSignalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CountSignalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
