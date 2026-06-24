import { Component, OnInit, OnDestroy, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-course-detail',
  imports: [CommonModule, RouterLink],
  templateUrl: './course-detail.component.html',
  styleUrl: './course-detail.component.css',
})
export class CourseDetail implements OnInit, OnDestroy {
  course: Course | undefined;
  errorMessage = '';
  private sub = new Subscription();

  constructor(
    private route: ActivatedRoute,
    private courseService: CourseService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    const courseIdStr = this.route.snapshot.paramMap.get('id');
    if (courseIdStr) {
      this.sub.add(
        this.courseService.getCourseById(Number(courseIdStr)).subscribe({
          next: (c) => {
            this.course = c;
            this.cdr.detectChanges();
          },
          error: (err) => {
            this.errorMessage = err.message || 'Failed to load course details.';
            this.cdr.detectChanges();
          }
        })
      );
    }
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
