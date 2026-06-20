import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Highlight } from '../../directives/highlight.directive';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';

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
    isEnrolled?: boolean;
  };
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  // Getters keep templates clean by moving complex conditional styling logic 
  // out of the HTML template and into the TypeScript component class.
  get cardClasses() {
    return {
      'card--enrolled': !!this.course.isEnrolled,
      'card--full': this.course.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  toggleExpand(): void {
    this.isExpanded = !this.isExpanded;
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
