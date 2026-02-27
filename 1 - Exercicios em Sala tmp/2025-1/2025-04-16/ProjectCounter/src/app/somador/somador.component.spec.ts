import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SomadorComponent } from './somador.component';

describe('SomadorComponent', () => {
  let component: SomadorComponent;
  let fixture: ComponentFixture<SomadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SomadorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SomadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
