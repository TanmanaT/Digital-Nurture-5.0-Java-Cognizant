import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {
  private enrolledCourseIds: number[] = [];

  constructor(
    private http: HttpClient,
    private courseService: CourseService
  ) {}

  enroll(courseId: number): void {
    if (!this.enrolledCourseIds.includes(courseId)) {
      this.enrolledCourseIds.push(courseId);
    }
  }

  unenroll(courseId: number): void {
    this.enrolledCourseIds = this.enrolledCourseIds.filter(id => id !== courseId);
  }

  isEnrolled(courseId: number): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  getEnrolledCourses(): Course[] {
    // Note: Since courseService now returns observables, we'll keep this simple for local UI 
    // but in future state we can resolve via state management.
    return this.enrolledCourseIds
      .map(id => {
        let match: Course | undefined;
        this.courseService.getCourseById(id).subscribe(c => match = c);
        return match;
      })
      .filter((c): c is Course => c !== undefined);
  }

  // Fetch enrolled students for a specific course (used for switchMap demonstration)
  getStudentsByCourse(courseId: number): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:3000/students?courseId=${courseId}`);
  }
}
