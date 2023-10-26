import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RealizarPagosComponent } from './realizar-pagos.component';

describe('RealizarPagosComponent', () => {
  let component: RealizarPagosComponent;
  let fixture: ComponentFixture<RealizarPagosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RealizarPagosComponent]
    });
    fixture = TestBed.createComponent(RealizarPagosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
