import { Component, OnInit } from '@angular/core';
import { ProductoService } from '../../services/producto';
import { Producto } from '../../models/producto';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './producto.html',
  styleUrls: ['./producto.css']
})
export class Productos implements OnInit {

  productos: Producto[] = [];

  nuevo: Producto = {
    nombre: '',
    precio: 0
  };

  constructor(
    private productoService: ProductoService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.cargarProductos();
  }

  cargarProductos() {
    this.productoService.getProductos().subscribe(data => {
      this.productos = data;
      this.cdr.detectChanges();
    });
  }

  crearProducto() {
    this.productoService.crearProducto(this.nuevo).subscribe(() => {
      this.nuevo = { nombre: '', precio: 0 };
      this.cargarProductos();
    });
  }

  eliminarProducto(id: number) {
    this.productoService.eliminarProducto(id).subscribe(() => {
      this.cargarProductos();
    });
  }
}