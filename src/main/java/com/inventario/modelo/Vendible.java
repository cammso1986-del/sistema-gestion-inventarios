package com.inventario.modelo;

/**
 * Interfaz que define el contrato común para productos que pueden venderse
 * y mostrar información en una etiqueta de inventario.
 */
public interface Vendible {
    double calcularPrecioFinal();
    String generarEtiqueta();
}
