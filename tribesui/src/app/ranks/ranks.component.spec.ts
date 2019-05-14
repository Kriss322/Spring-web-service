import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RanksComponent } from './ranks.component';

describe('RanksComponent', () => {
  let component: RanksComponent;
  let fixture: ComponentFixture<RanksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RanksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RanksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
