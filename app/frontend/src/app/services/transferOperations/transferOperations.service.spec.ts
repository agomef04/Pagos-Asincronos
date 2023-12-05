import { TestBed } from '@angular/core/testing';

import { ViewTransactionService } from './transferOperations.service';

describe('ViewTransactionService', () => {
  let service: ViewTransactionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewTransactionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
