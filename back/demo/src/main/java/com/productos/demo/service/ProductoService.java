package com.productos.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productos.demo.entity.Producto;
import com.productos.demo.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listar(){
        return productoRepository.findAll();
    }

    public Producto subir(Producto producto){
        return productoRepository.save(producto);
    }

    public void eliminar(Long id){
        productoRepository.deleteById(id);
    }
}
