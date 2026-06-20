import { Component, OnInit, OnDestroy, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import * as CourseSelectors from '../../store/course.selectors';
import { Subscription, combineLatest } from 'rxjs';

@Component({
  selector: 'app-course-summary-widget',
  imports: [CommonModule],
  templateUrl: './course-summary-widget.component.html',
  styleUrl: './course-summary-widget.component.css',
})
export class CourseSummaryWidget implements OnInit, OnDestroy {
  totalCoursesCount = 0;
  enrolledCoursesCount = 0;
  private sub = new Subscription();

  constructor(
    private store: Store,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.sub.add(
      combineLatest([
        this.store.select(CourseSelectors.selectAllCourses),
        this.store.select(CourseSelectors.selectEnrolledCourseIds)
      ]).subscribe(([courses, enrolledIds]) => {
        this.totalCoursesCount = courses.length;
        this.enrolledCoursesCount = enrolledIds.length;
        this.cdr.detectChanges();
      })
    );
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
