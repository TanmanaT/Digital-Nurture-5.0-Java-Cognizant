import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseService } from '../../services/course.service';
import { EnrollmentService } from '../../services/enrollment.service';

@Component({
  selector: 'app-course-summary-widget',
  imports: [CommonModule],
  templateUrl: './course-summary-widget.component.html',
  styleUrl: './course-summary-widget.component.css',
})
export class CourseSummaryWidget {
  constructor(
    private courseService: CourseService,
    public enrollmentService: EnrollmentService
  ) {}

  get totalCoursesCount(): number {
    return this.courseService.getCourses().length;
  }

  get enrolledCoursesCount(): number {
    return this.enrollmentService.getEnrolledCourses().length;
  }
}
