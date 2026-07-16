import { Component, OnInit, OnDestroy, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, ActivatedRoute } from '@angular/router';
import { CourseCard } from '../../components/course-card/course-card.component';
import { Course } from '../../models/course.model';
import { CourseSummaryWidget } from '../../components/course-summary-widget/course-summary-widget.component';
import { FormsModule } from '@angular/forms';
import { Store } from '@ngrx/store';
import * as CourseActions from '../../store/course.actions';
import * as CourseSelectors from '../../store/course.selectors';
import { Subscription, combineLatest } from 'rxjs';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard, CourseSummaryWidget, FormsModule],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css',
})
export class CourseList implements OnInit, OnDestroy {
  isLoading = true;
  courses: Course[] = [];
  selectedCourseId: number | null = null;
  searchTerm = '';
  errorMessage = '';
  private sub = new Subscription();

  constructor(
    private store: Store,
    private router: Router,
    private route: ActivatedRoute,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    // Dispatch action to load courses via Effects
    this.store.dispatch(CourseActions.loadCourses());

    // Combine latest route query parameters with store selectors for reactive rendering
    this.sub.add(
      combineLatest([
        this.route.queryParams,
        this.store.select(CourseSelectors.selectAllCourses),
        this.store.select(CourseSelectors.selectCoursesLoading),
        this.store.select(CourseSelectors.selectCoursesError)
      ]).subscribe(([params, allCourses, loading, error]) => {
        this.searchTerm = params['search'] || '';
        this.isLoading = loading;
        this.errorMessage = error || '';

        if (this.searchTerm.trim()) {
          this.courses = allCourses.filter(c =>
            c.name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
            c.code.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
            c.credits.toString().includes(this.searchTerm.toLowerCase())
          );
        } else {
          this.courses = allCourses;
        }
        this.cdr.detectChanges();
      })
    );
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  onSearch(): void {
    this.router.navigate(['/courses'], { queryParams: { search: this.searchTerm } });
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

  onEnroll(courseId: number): void {
    this.router.navigate(['/courses', courseId]);
  }
}
