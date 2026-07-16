import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card.component';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css',
})
export class CourseList {
  courses = [
    { id: 1, name: 'Introduction to Angular', code: 'CS-ANG20', credits: 3 },
    { id: 2, name: 'TypeScript Core Fundamentals', code: 'CS-TS45', credits: 2 },
    { id: 3, name: 'State Management with NgRx', code: 'CS-NGRX9', credits: 4 },
    { id: 4, name: 'RxJS Asynchronous Programming', code: 'CS-RXJS6', credits: 3 },
    { id: 5, name: 'Unit Testing Angular Apps', code: 'CS-TEST10', credits: 2 }
  ];

  selectedCourseId: number | null = null;

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}
