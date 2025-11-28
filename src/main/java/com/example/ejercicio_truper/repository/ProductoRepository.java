package com.example.ejercicio_truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejercicio_truper.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
