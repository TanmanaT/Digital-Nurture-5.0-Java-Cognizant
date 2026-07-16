import { Component, OnInit, OnDestroy, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseService } from '../../services/course.service';
import { EnrollmentService } from '../../services/enrollment.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-course-summary-widget',
  imports: [CommonModule],
  templateUrl: './course-summary-widget.component.html',
  styleUrl: './course-summary-widget.component.css',
})
export class CourseSummaryWidget implements OnInit, OnDestroy {
  totalCoursesCount = 0;
  private sub = new Subscription();

  constructor(
    private courseService: CourseService,
    public enrollmentService: EnrollmentService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.sub.add(
      this.courseService.getCourses().subscribe({
        next: (courses) => {
          this.totalCoursesCount = courses.length;
          this.cdr.detectChanges();
        },
        error: () => {
          this.totalCoursesCount = 0;
          this.cdr.detectChanges();
        }
      })
    );
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  get enrolledCoursesCount(): number {
    return this.enrollmentService.getEnrolledCourses().length;
  }
}
