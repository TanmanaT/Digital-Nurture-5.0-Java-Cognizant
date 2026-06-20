import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CourseList } from './course-list.component';
import { provideMockStore } from '@ngrx/store/testing';
import { provideRouter } from '@angular/router';
import * as CourseSelectors from '../../store/course.selectors';

describe('CourseList', () => {
  let component: CourseList;
  let fixture: ComponentFixture<CourseList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseList],
      providers: [
        provideRouter([]),
        provideMockStore({
          selectors: [
            { selector: CourseSelectors.selectAllCourses, value: [] },
            { selector: CourseSelectors.selectCoursesLoading, value: false },
            { selector: CourseSelectors.selectCoursesError, value: null },
            { selector: CourseSelectors.selectEnrolledCourseIds, value: [] }
          ]
        })
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseList);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
