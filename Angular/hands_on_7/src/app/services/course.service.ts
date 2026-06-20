import { Injectable } from '@angular/core';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private courses: Course[] = [
    { id: 1, name: 'Introduction to Angular', code: 'CS-ANG20', credits: 3, gradeStatus: 'passed' },
    { id: 2, name: 'TypeScript Core Fundamentals', code: 'CS-TS45', credits: 2, gradeStatus: 'pending' },
    { id: 3, name: 'State Management with NgRx', code: 'CS-NGRX9', credits: 4, gradeStatus: 'failed' },
    { id: 4, name: 'RxJS Asynchronous Programming', code: 'CS-RXJS6', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'Unit Testing Angular Apps', code: 'CS-TEST10', credits: 2, gradeStatus: 'pending' }
  ];

  getCourses(): Course[] {
    return this.courses;
  }

  getCourseById(id: number): Course | undefined {
    return this.courses.find(c => c.id === id);
  }

  addCourse(course: Course): void {
    this.courses.push(course);
  }
}
