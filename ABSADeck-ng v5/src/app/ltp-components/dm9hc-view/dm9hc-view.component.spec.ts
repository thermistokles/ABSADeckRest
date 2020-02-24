import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Dm9hcViewComponent } from './dm9hc-view.component';

describe('Dm9hcViewComponent', () => {
  let component: Dm9hcViewComponent;
  let fixture: ComponentFixture<Dm9hcViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Dm9hcViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Dm9hcViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
