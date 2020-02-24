import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppstatusViewComponent } from './appstatus-view.component';

describe('AppstatusViewComponent', () => {
  let component: AppstatusViewComponent;
  let fixture: ComponentFixture<AppstatusViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppstatusViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppstatusViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
