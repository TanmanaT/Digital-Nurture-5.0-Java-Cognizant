import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CourseCard } from './course-card.component';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import * as CourseActions from '../../store/course.actions';
import * as CourseSelectors from '../../store/course.selectors';
import { SimpleChange } from '@angular/core';

describe('CourseCard', () => {
  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;
  let store: MockStore;
  const mockCourse = {
    id: 1,
    name: 'Introduction to Angular',
    code: 'CS-ANG20',
    credits: 3,
    gradeStatus: 'passed' as const
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseCard],
      providers: [
        provideMockStore({
          selectors: [
            { selector: CourseSelectors.selectEnrolledCourseIds, value: [] }
          ]
        })
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCard);
    component = fixture.componentInstance;
    component.course = mockCourse;
    store = TestBed.inject(MockStore);
    fixture.detectChanges();
  });

  it('should create and render course input details', () => {
    expect(component).toBeTruthy();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.course-title')?.textContent).toContain('Introduction to Angular');
    expect(compiled.querySelector('.course-code')?.textContent).toContain('CS-ANG20');
  });

  it('should toggle details expansion on click', () => {
    expect(component.isExpanded).toBeFalse();
    component.toggleExpand();
    expect(component.isExpanded).toBeTrue();
    component.toggleExpand();
    expect(component.isExpanded).toBeFalse();
  });

  it('should dispatch enrollCourse action when not enrolled and clicked', () => {
    spyOn(store, 'dispatch');
    component.isEnrolled = false;
    component.toggleEnroll();
    expect(store.dispatch).toHaveBeenCalledWith(
      CourseActions.enrollCourse({ courseId: mockCourse.id })
    );
  });

  it('should dispatch unenrollCourse action when enrolled and clicked', () => {
    spyOn(store, 'dispatch');
    component.isEnrolled = true;
    component.toggleEnroll();
    expect(store.dispatch).toHaveBeenCalledWith(
      CourseActions.unenrollCourse({ courseId: mockCourse.id })
    );
  });

  it('should log changes on ngOnChanges lifecycle hook', () => {
    spyOn(console, 'log');
    component.ngOnChanges({
      course: new SimpleChange(null, mockCourse, true)
    });
    expect(console.log).toHaveBeenCalled();
  });
});
