import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TribeComponent } from './tribe.component';

describe('TribeComponent', () => {
  let component: TribeComponent;
  let fixture: ComponentFixture<TribeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TribeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TribeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
