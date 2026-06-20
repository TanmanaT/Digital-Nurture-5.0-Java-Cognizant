import { TestBed } from '@angular/core/testing';
import { HttpTestingController, provideHttpClientTesting } from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';

describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  const mockCourses: Course[] = [
    { id: 1, name: 'Introduction to Angular', code: 'CS-ANG20', credits: 3, gradeStatus: 'passed' },
    { id: 2, name: 'TypeScript Core Fundamentals', code: 'CS-TS45', credits: 2, gradeStatus: 'pending' }
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        CourseService,
        provideHttpClient(),
        provideHttpClientTesting()
      ]
    });
    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify(); // Ensure that there are no outstanding requests
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch courses via GET and map filtering credits > 0', () => {
    service.getCourses().subscribe((courses) => {
      expect(courses.length).toBe(2);
      expect(courses).toEqual(mockCourses);
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('GET');
    req.flush(mockCourses);
  });

  it('should fetch single course details by ID via GET', () => {
    service.getCourseById(1).subscribe((course) => {
      expect(course).toEqual(mockCourses[0]);
    });

    const req = httpMock.expectOne('http://localhost:3000/courses/1');
    expect(req.request.method).toBe('GET');
    req.flush(mockCourses[0]);
  });

  it('should create a new course via POST', () => {
    const newCourseInput = { name: 'New Course', code: 'CS-NEW', credits: 3, gradeStatus: 'pending' as const };
    const createdCourse = { id: 6, ...newCourseInput };

    service.createCourse(newCourseInput).subscribe((course) => {
      expect(course).toEqual(createdCourse);
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('POST');
    expect(req.request.body).toEqual(newCourseInput);
    req.flush(createdCourse);
  });
});
