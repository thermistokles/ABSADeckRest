import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabsltpComponent } from './tabsltp.component';

describe('TabsltpComponent', () => {
  let component: TabsltpComponent;
  let fixture: ComponentFixture<TabsltpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabsltpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabsltpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
