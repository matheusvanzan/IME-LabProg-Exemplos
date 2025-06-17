import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountNormalComponent } from './count-normal.component';

describe('CountNormalComponent', () => {
  let component: CountNormalComponent;
  let fixture: ComponentFixture<CountNormalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CountNormalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CountNormalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
