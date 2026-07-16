import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, FormArray, FormControl, Validators, AbstractControl, ValidationErrors } from '@angular/forms';

@Component({
  selector: 'app-reactive-enrollment-form',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.component.html',
  styleUrl: './reactive-enrollment-form.component.css',
})
export class ReactiveEnrollmentForm implements OnInit {
  enrollForm!: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      // Async validator is passed as the third parameter
      studentEmail: ['', [Validators.required, Validators.email], [this.simulateEmailCheck]],
      courseId: ['', [Validators.required, this.noCourseCode]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      additionalCourses: this.fb.array([])
    });
  }

  // Custom Synchronous Validator
  noCourseCode(control: AbstractControl): ValidationErrors | null {
    const value = control.value;
    if (value && typeof value === 'string' && value.toUpperCase().startsWith('XX')) {
      return { noCourseCode: true };
    }
    return null;
  }

  // Custom Async Validator simulating a check against an API
  simulateEmailCheck(control: AbstractControl): Promise<ValidationErrors | null> {
    return new Promise((resolve) => {
      setTimeout(() => {
        const email = control.value;
        if (email && email.includes('test@')) {
          resolve({ emailTaken: true });
        } else {
          resolve(null);
        }
      }, 800);
    });
  }

  // Typed Getter:
  // Using a typed getter in TypeScript provides compile-time type safety.
  // Instead of casting 'as FormArray' multiple times in HTML template which is error-prone,
  // this getter guarantees type-safe access to FormArray controls and properties.
  get additionalCourses(): FormArray {
    return this.enrollForm.get('additionalCourses') as FormArray;
  }

  addCourse(): void {
    this.additionalCourses.push(new FormControl('', Validators.required));
  }

  removeCourse(index: number): void {
    this.additionalCourses.removeAt(index);
  }

  canDeactivate(): boolean {
    if (this.enrollForm && this.enrollForm.dirty && !this.submitted) {
      return window.confirm('You have unsaved changes. Leave?');
    }
    return true;
  }

  onSubmit(): void {
    this.submitted = true;
    
    // Difference between value and getRawValue():
    // - enrollForm.value: Excludes any controls that are disabled.
    // - enrollForm.getRawValue(): Returns the values of all controls, regardless of their disabled status.
    console.log('Form Value (excluding disabled):', this.enrollForm.value);
    console.log('Form Raw Value (including disabled):', this.enrollForm.getRawValue());
  }
}
