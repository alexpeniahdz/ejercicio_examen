package com.example.ejercicio_truper.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ejercicio_truper.OrdenNotFoundException;
import com.example.ejercicio_truper.entity.Ordenes;
import com.example.ejercicio_truper.repository.OrdenRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrdenesService {

    private final OrdenRepository ordenesRepository;

    
    public Ordenes create(Ordenes orden) {
        Ordenes u = ordenesRepository.save(orden);
        if (orden.getProductos() != null) {
            orden.getProductos().forEach(p -> p.setOrden(orden));
        }
        return u;
    }

     public Ordenes findById(Long id) {
        Ordenes orden = ordenesRepository.findById(id)
        .orElseThrow(() -> new OrdenNotFoundException(id));
        return orden;
    }

    


}
