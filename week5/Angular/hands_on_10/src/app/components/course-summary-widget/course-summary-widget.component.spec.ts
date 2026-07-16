import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CourseSummaryWidget } from './course-summary-widget.component';
import { provideMockStore } from '@ngrx/store/testing';
import * as CourseSelectors from '../../store/course.selectors';

describe('CourseSummaryWidget', () => {
  let component: CourseSummaryWidget;
  let fixture: ComponentFixture<CourseSummaryWidget>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseSummaryWidget],
      providers: [
        provideMockStore({
          selectors: [
            { selector: CourseSelectors.selectAllCourses, value: [] },
            { selector: CourseSelectors.selectEnrolledCourseIds, value: [] }
          ]
        })
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseSummaryWidget);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
