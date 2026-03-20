package com.productos.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productos.demo.entity.Producto;
import com.productos.demo.service.ProductoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listar(){
        return productoService.listar();
    }

    @PostMapping
    public Producto subir(@RequestBody Producto producto){
        return productoService.subir(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        productoService.eliminar(id);
    }
}
