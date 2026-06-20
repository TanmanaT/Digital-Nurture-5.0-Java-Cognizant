import { Component, OnInit, OnDestroy, ChangeDetectorRef } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Store } from '@ngrx/store';
import * as CourseSelectors from '../../store/course.selectors';
import { Subscription, combineLatest } from 'rxjs';

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
  enrolledCoursesCount = 0;
  private sub = new Subscription();

  constructor(
    private store: Store,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    console.log('HomeComponent initialised — courses loaded');
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
    console.log('HomeComponent destroyed');
    this.sub.unsubscribe();
  }

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }
}
