import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CourseDetail } from './course-detail.component';
import { provideRouter } from '@angular/router';
import { CourseService } from '../../services/course.service';
import { of } from 'rxjs';
import { Course } from '../../models/course.model';

describe('CourseDetail', () => {
  let component: CourseDetail;
  let fixture: ComponentFixture<CourseDetail>;
  let mockCourseService: any;
  const mockCourse: Course = { id: 1, name: 'Introduction to Angular', code: 'CS-ANG20', credits: 3, gradeStatus: 'passed' };

  beforeEach(async () => {
    mockCourseService = {
      getCourseById: jasmine.createSpy('getCourseById').and.returnValue(of(mockCourse))
    };

    await TestBed.configureTestingModule({
      imports: [CourseDetail],
      providers: [
        provideRouter([]),
        { provide: CourseService, useValue: mockCourseService }
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseDetail);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
