import { Highlight } from './highlight.directive';
import { Component, DebugElement } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';

@Component({
  template: `<div [appHighlight]="'yellow'">Test Element</div>`,
  imports: [Highlight]
})
class TestComponent {}

describe('HighlightDirective', () => {
  let fixture: ComponentFixture<TestComponent>;
  let divEl: DebugElement;

  beforeEach(() => {
    fixture = TestBed.configureTestingModule({
      imports: [TestComponent, Highlight]
    }).createComponent(TestComponent);

    fixture.detectChanges();
    divEl = fixture.debugElement.query(By.css('div'));
  });

  it('should create an instance of directive', () => {
    const directive = divEl.injector.get(Highlight);
    expect(directive).toBeTruthy();
  });
});
