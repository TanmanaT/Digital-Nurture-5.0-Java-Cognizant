import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, ActivatedRoute } from '@angular/router';
import { CourseCard } from '../../components/course-card/course-card.component';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';
import { CourseSummaryWidget } from '../../components/course-summary-widget/course-summary-widget.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard, CourseSummaryWidget, FormsModule],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css',
})
export class CourseList implements OnInit {
  isLoading = true;
  courses: Course[] = [];
  selectedCourseId: number | null = null;
  searchTerm = '';

  constructor(
    private courseService: CourseService,
    private router: Router,
    private route: ActivatedRoute,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    // Read query parameter 'search'
    const searchParam = this.route.snapshot.queryParamMap.get('search');
    if (searchParam) {
      this.searchTerm = searchParam;
    }

    this.loadCourses();

    setTimeout(() => {
      this.isLoading = false;
      this.cdr.detectChanges(); // Force change detection in zoneless mode
    }, 1500);
  }

  loadCourses(): void {
    const allCourses = this.courseService.getCourses();
    if (this.searchTerm.trim()) {
      this.courses = allCourses.filter(c => 
        c.name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        c.code.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    } else {
      this.courses = allCourses;
    }
  }

  onSearch(): void {
    // Navigate with query parameters
    this.router.navigate(['/courses'], { queryParams: { search: this.searchTerm } });
    this.loadCourses();
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

  onEnroll(courseId: number): void {
    // Navigate to course detail page
    this.router.navigate(['/courses', courseId]);
  }
}
