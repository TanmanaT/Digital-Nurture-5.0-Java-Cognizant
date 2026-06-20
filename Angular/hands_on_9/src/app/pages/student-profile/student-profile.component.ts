import { Component, OnInit, OnDestroy, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../../models/course.model';
import { Notification } from '../../components/notification/notification.component';
import { Store } from '@ngrx/store';
import * as CourseSelectors from '../../store/course.selectors';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-student-profile',
  imports: [CommonModule, Notification],
  templateUrl: './student-profile.component.html',
  styleUrl: './student-profile.component.css',
})
export class StudentProfile implements OnInit, OnDestroy {
  enrolledCourses: Course[] = [];
  private sub = new Subscription();

  constructor(
    private store: Store,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.sub.add(
      this.store.select(CourseSelectors.selectEnrolledCourses).subscribe((courses) => {
        this.enrolledCourses = courses;
        this.cdr.detectChanges();
      })
    );
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
