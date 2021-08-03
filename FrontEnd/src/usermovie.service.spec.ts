import { TestBed } from '@angular/core/testing';

import { UsermovieService } from './usermovie.service';

describe('UsermovieService', () => {
  let service: UsermovieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsermovieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
