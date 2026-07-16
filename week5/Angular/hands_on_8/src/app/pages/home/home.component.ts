import { Component, OnInit, OnDestroy, ChangeDetectorRef } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CourseService } from '../../services/course.service';
import { EnrollmentService } from '../../services/enrollment.service';
import { Subscription } from 'rxjs';

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
  totalCoursesCount = 0;
  private sub = new Subscription();

  constructor(
    private courseService: CourseService,
    private enrollmentService: EnrollmentService,
    private cdr: ChangeDetectorRef
  ) {}

  get enrolledCoursesCount(): number {
    return this.enrollmentService.getEnrolledCourses().length;
  }

  ngOnInit(): void {
    console.log('HomeComponent initialised — courses loaded');
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
    console.log('HomeComponent destroyed');
    this.sub.unsubscribe();
  }

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }
}
