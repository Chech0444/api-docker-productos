import { Component } from '@angular/core';
import { Productos } from './pages/producto/producto';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [Productos],
  template: `<app-productos></app-productos>` // 👈 ESTO ES CLAVE
})
export class App {}