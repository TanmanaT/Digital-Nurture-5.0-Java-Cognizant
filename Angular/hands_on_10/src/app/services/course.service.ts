import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map, retry, tap } from 'rxjs/operators';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private apiUrl = 'http://localhost:3000/courses';

  constructor(private http: HttpClient) {}

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.apiUrl).pipe(
      retry(2), // retry up to 2 times
      
      // tap is preferred for side-effects (e.g. logging) because it keeps the stream unchanged,
      // avoiding accidental transformations of data that map would introduce.
      tap(courses => console.log('Courses loaded via HTTP:', courses.length)),
      
      // map transforms the array (here we filter out courses with 0 credits)
      map(courses => courses.filter(c => c.credits > 0)),
      
      catchError(err => {
        console.error('Course list fetch failed:', err);
        return throwError(() => new Error('Failed to load courses. Please try again.'));
      })
    );
  }

  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.apiUrl}/${id}`).pipe(
      catchError(err => {
        console.error(`Fetch failed for course ${id}:`, err);
        return throwError(() => new Error('Failed to retrieve course details.'));
      })
    );
  }

  createCourse(course: Omit<Course, 'id'>): Observable<Course> {
    return this.http.post<Course>(this.apiUrl, course).pipe(
      catchError(err => {
        console.error('Failed to create course:', err);
        return throwError(() => new Error('Failed to register the new course.'));
      })
    );
  }

  updateCourse(course: Course): Observable<Course> {
    return this.http.put<Course>(`${this.apiUrl}/${course.id}`, course).pipe(
      catchError(err => {
        console.error(`Failed to update course ${course.id}:`, err);
        return throwError(() => new Error('Failed to save course changes.'));
      })
    );
  }

  deleteCourse(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`).pipe(
      catchError(err => {
        console.error(`Failed to delete course ${id}:`, err);
        return throwError(() => new Error('Failed to remove course.'));
      })
    );
  }
}
