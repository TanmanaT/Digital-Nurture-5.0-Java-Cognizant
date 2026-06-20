import { createAction, props } from '@ngrx/store';
import { Course } from '../models/course.model';

// Course Actions
export const loadCourses = createAction('[Course List] Load Courses');
export const loadCoursesSuccess = createAction(
  '[Course API] Load Courses Success',
  props<{ courses: Course[] }>()
);
export const loadCoursesFailure = createAction(
  '[Course API] Load Courses Failure',
  props<{ error: string }>()
);

// Enrollment Actions
export const enrollCourse = createAction(
  '[Course Card] Enroll Course',
  props<{ courseId: number }>()
);
export const unenrollCourse = createAction(
  '[Course Card] Unenroll Course',
  props<{ courseId: number }>()
);
