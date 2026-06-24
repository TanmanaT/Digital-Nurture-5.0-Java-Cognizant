import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges, OnInit, OnDestroy, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Highlight } from '../../directives/highlight.directive';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';
import { Store } from '@ngrx/store';
import * as CourseActions from '../../store/course.actions';
import * as CourseSelectors from '../../store/course.selectors';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-course-card',
  imports: [CommonModule, Highlight, CreditLabelPipe],
  templateUrl: './course-card.component.html',
  styleUrl: './course-card.component.css',
})
export class CourseCard implements OnChanges, OnInit, OnDestroy {
  @Input() course!: { 
    id: number; 
    name: string; 
    code: string; 
    credits: number; 
    gradeStatus: 'passed' | 'failed' | 'pending';
  };
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;
  isEnrolled = false;
  private sub = new Subscription();

  constructor(
    private store: Store,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.sub.add(
      this.store.select(CourseSelectors.selectEnrolledCourseIds).subscribe((enrolledIds) => {
        this.isEnrolled = enrolledIds.includes(this.course.id);
        this.cdr.detectChanges();
      })
    );
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  get cardClasses() {
    return {
      'card--enrolled': this.isEnrolled,
      'card--full': this.course.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  toggleExpand(): void {
    this.isExpanded = !this.isExpanded;
  }

  toggleEnroll(): void {
    if (this.isEnrolled) {
      this.store.dispatch(CourseActions.unenrollCourse({ courseId: this.course.id }));
    } else {
      this.store.dispatch(CourseActions.enrollCourse({ courseId: this.course.id }));
    }
    this.enrollRequested.emit(this.course.id);
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      const prev = changes['course'].previousValue;
      const curr = changes['course'].currentValue;
      console.log('Course changed:', {
        previous: prev,
        current: curr
      });
    }
  }
}
