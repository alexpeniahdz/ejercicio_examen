package com.example.ejercicio_truper;

public class OrdenNotFoundException extends RuntimeException{

    public OrdenNotFoundException(Long id){
        super("Orden no encontrada");
    }
}
