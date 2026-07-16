import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card.component';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';
import { CourseSummaryWidget } from '../../components/course-summary-widget/course-summary-widget.component';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard, CourseSummaryWidget],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css',
})
export class CourseList implements OnInit {
  isLoading = true;
  courses: Course[] = [];
  selectedCourseId: number | null = null;

  constructor(
    private courseService: CourseService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    // Read from CourseService
    this.courses = this.courseService.getCourses();

    setTimeout(() => {
      this.isLoading = false;
      this.cdr.detectChanges(); // Force change detection in zoneless mode
    }, 1500);
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

  onEnroll(courseId: number): void {
    console.log('Enroll click triggered for ID:', courseId);
    this.selectedCourseId = courseId;
  }
}
