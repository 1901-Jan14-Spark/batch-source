import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ColoredTextComponent } from './colored-text.component';

describe('ColoredTextComponent', () => {
  let component: ColoredTextComponent;
  let fixture: ComponentFixture<ColoredTextComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ColoredTextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ColoredTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
