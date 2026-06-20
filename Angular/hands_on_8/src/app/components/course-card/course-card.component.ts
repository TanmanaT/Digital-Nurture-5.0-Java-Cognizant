import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Highlight } from '../../directives/highlight.directive';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';
import { EnrollmentService } from '../../services/enrollment.service';

@Component({
  selector: 'app-course-card',
  imports: [CommonModule, Highlight, CreditLabelPipe],
  templateUrl: './course-card.component.html',
  styleUrl: './course-card.component.css',
})
export class CourseCard implements OnChanges {
  @Input() course!: { 
    id: number; 
    name: string; 
    code: string; 
    credits: number; 
    gradeStatus: 'passed' | 'failed' | 'pending';
  };
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  constructor(public enrollmentService: EnrollmentService) {}

  get cardClasses() {
    const enrolled = this.enrollmentService.isEnrolled(this.course.id);
    return {
      'card--enrolled': enrolled,
      'card--full': this.course.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  toggleExpand(): void {
    this.isExpanded = !this.isExpanded;
  }

  toggleEnroll(): void {
    if (this.enrollmentService.isEnrolled(this.course.id)) {
      this.enrollmentService.unenroll(this.course.id);
    } else {
      this.enrollmentService.enroll(this.course.id);
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
