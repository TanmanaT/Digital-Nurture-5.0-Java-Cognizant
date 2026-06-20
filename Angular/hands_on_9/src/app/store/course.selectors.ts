import { createFeatureSelector, createSelector } from '@ngrx/store';
import { CourseState } from './course.reducer';

export const selectCourseState = createFeatureSelector<CourseState>('course');

export const selectAllCourses = createSelector(
  selectCourseState,
  (state) => state.courses
);

export const selectCoursesLoading = createSelector(
  selectCourseState,
  (state) => state.loading
);

export const selectCoursesError = createSelector(
  selectCourseState,
  (state) => state.error
);

export const selectEnrolledCourseIds = createSelector(
  selectCourseState,
  (state) => state.enrolledCourseIds
);

export const selectEnrolledCourses = createSelector(
  selectAllCourses,
  selectEnrolledCourseIds,
  (courses, enrolledIds) => courses.filter((c) => enrolledIds.includes(c.id))
);
