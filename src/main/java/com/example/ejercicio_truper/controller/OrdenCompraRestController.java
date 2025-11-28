package com.example.ejercicio_truper.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ejercicio_truper.entity.Ordenes;
import com.example.ejercicio_truper.entity.Producto;
import com.example.ejercicio_truper.service.OrdenesService;
import com.example.ejercicio_truper.service.ProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ordenes")
@RequiredArgsConstructor
public class OrdenCompraRestController {

    private final OrdenesService ordenesService;

    private final ProductoService productoService;

    @GetMapping("/{id}")
    public ResponseEntity<Ordenes> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ordenesService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Ordenes> create(@RequestBody Ordenes orden) {
        Ordenes created = ordenesService.create(orden);
        return ResponseEntity.created(URI.create("/ordenes/" + created.getId()))
                .body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto) {
        Producto updated = productoService.update(id, producto);
        return ResponseEntity.ok(updated);
    }

}
