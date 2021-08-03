import { TestBed } from '@angular/core/testing';

import { ApimoviesService } from './apimovies.service';

describe('ApimoviesService', () => {
  let service: ApimoviesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApimoviesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
