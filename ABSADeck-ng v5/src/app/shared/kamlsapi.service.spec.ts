import { TestBed } from '@angular/core/testing';

import { KamlsapiService } from './kamlsapi.service';

describe('KamlsapiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: KamlsapiService = TestBed.get(KamlsapiService);
    expect(service).toBeTruthy();
  });
});
