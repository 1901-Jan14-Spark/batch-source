import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilecomponentsComponent } from './profilecomponents.component';

describe('ProfilecomponentsComponent', () => {
  let component: ProfilecomponentsComponent;
  let fixture: ComponentFixture<ProfilecomponentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfilecomponentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilecomponentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
