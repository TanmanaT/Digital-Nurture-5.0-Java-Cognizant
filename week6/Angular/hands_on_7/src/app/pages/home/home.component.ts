import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CourseService } from '../../services/course.service';
import { EnrollmentService } from '../../services/enrollment.service';

@Component({
  selector: 'app-home',
  imports: [FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class Home implements OnInit, OnDestroy {
  portalName = 'Student Course Portal';
  isPortalActive = true;
  message = '';
  searchTerm = '';

  // [property] is property binding (one-way from component class to template DOM).
  // [(ngModel)] is two-way binding (synchronizes template DOM input with component property in both directions).

  constructor(
    private courseService: CourseService,
    private enrollmentService: EnrollmentService
  ) {}

  get totalCoursesCount(): number {
    return this.courseService.getCourses().length;
  }

  get enrolledCoursesCount(): number {
    return this.enrollmentService.getEnrolledCourses().length;
  }

  ngOnInit(): void {
    console.log('HomeComponent initialised — courses loaded');
  }

  ngOnDestroy(): void {
    console.log('HomeComponent destroyed');
  }

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }
}
