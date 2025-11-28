package com.example.ejercicio_truper.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ejercicio_truper.OrdenNotFoundException;
import com.example.ejercicio_truper.entity.Producto;
import com.example.ejercicio_truper.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public Producto update(Long id, Producto producto) {
        Producto u = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException());

        u.setPrecio(producto.getPrecio());

        Producto update = productoRepository.save(u);

        return update;
    }

}
