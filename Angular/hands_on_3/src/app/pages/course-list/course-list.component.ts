import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card.component';

interface Course {
  id: number;
  name: string;
  code: string;
  credits: number;
  gradeStatus: 'passed' | 'failed' | 'pending';
  isEnrolled?: boolean;
}

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css',
})
export class CourseList implements OnInit {
  isLoading = true;

  courses: Course[] = [
    { id: 1, name: 'Introduction to Angular', code: 'CS-ANG20', credits: 3, gradeStatus: 'passed' },
    { id: 2, name: 'TypeScript Core Fundamentals', code: 'CS-TS45', credits: 2, gradeStatus: 'pending' },
    { id: 3, name: 'State Management with NgRx', code: 'CS-NGRX9', credits: 4, gradeStatus: 'failed' },
    { id: 4, name: 'RxJS Asynchronous Programming', code: 'CS-RXJS6', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'Unit Testing Angular Apps', code: 'CS-TEST10', credits: 2, gradeStatus: 'pending' }
  ];

  selectedCourseId: number | null = null;

  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  // trackBy improves rendering performance for lists in Angular.
  // Instead of re-creating the entire DOM tree for the list when any change occurs,
  // Angular maps list items to unique IDs (like course.id) and only updates elements that actually changed.
  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
    
    // update isEnrolled in local array to demonstrate conditional styles
    this.courses = this.courses.map(c => 
      c.id === courseId ? { ...c, isEnrolled: !c.isEnrolled } : c
    );
  }
}
