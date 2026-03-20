package com.productos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.demo.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
