import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { Loading } from '../services/loading.service';
import { finalize } from 'rxjs';

export const loadingInterceptor: HttpInterceptorFn = (req, next) => {
  const loadingService = inject(Loading);
  
  loadingService.show();
  
  return next(req).pipe(
    finalize(() => {
      loadingService.hide();
    })
  );
};
