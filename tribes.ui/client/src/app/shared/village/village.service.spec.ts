import { TestBed, inject } from '@angular/core/testing';

import { VillageService } from './village.service';

describe('VillageService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [VillageService]
    });
  });

  it('should be created', inject([VillageService], (service: VillageService) => {
    expect(service).toBeTruthy();
  }));
});
