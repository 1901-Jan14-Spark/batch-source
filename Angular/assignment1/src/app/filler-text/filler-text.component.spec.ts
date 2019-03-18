import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FillerTextComponent } from './filler-text.component';

describe('FillerTextComponent', () => {
  let component: FillerTextComponent;
  let fixture: ComponentFixture<FillerTextComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FillerTextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FillerTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
