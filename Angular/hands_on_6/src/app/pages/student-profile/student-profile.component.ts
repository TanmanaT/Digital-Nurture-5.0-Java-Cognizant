import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EnrollmentService } from '../../services/enrollment.service';
import { Course } from '../../models/course.model';
import { Notification } from '../../components/notification/notification.component';

@Component({
  selector: 'app-student-profile',
  imports: [CommonModule, Notification],
  templateUrl: './student-profile.component.html',
  styleUrl: './student-profile.component.css',
})
export class StudentProfile {
  constructor(public enrollmentService: EnrollmentService) {}

  get enrolledCourses(): Course[] {
    return this.enrollmentService.getEnrolledCourses();
  }
}
