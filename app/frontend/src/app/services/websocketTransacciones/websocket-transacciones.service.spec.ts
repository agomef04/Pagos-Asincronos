import { TestBed } from '@angular/core/testing';

import { websocketTransacciones } from './websocket-transacciones.service';

describe('WebsocketTransaccionesService', () => {
  let service: websocketTransacciones;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(websocketTransacciones);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
