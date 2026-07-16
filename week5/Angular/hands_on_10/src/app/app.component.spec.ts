import { TestBed } from '@angular/core/testing';
import { App } from './app.component';
import { provideRouter } from '@angular/router';
import { Loading } from './services/loading.service';
import { BehaviorSubject } from 'rxjs';

describe('App', () => {
  let mockLoading: any;

  beforeEach(async () => {
    mockLoading = {
      isLoading$: new BehaviorSubject<boolean>(false)
    };

    await TestBed.configureTestingModule({
      imports: [App],
      providers: [
        provideRouter([]),
        { provide: Loading, useValue: mockLoading }
      ]
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(App);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
});
