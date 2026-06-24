import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Home } from './home.component';
import { provideMockStore } from '@ngrx/store/testing';
import * as CourseSelectors from '../../store/course.selectors';

describe('Home', () => {
  let component: Home;
  let fixture: ComponentFixture<Home>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Home],
      providers: [
        provideMockStore({
          selectors: [
            { selector: CourseSelectors.selectAllCourses, value: [] },
            { selector: CourseSelectors.selectEnrolledCourseIds, value: [] }
          ]
        })
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(Home);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
