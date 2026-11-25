package com.inventario.modelo;

/**
 * Clase derivada de Producto que representa prendas de vestir.
 * Agrega atributos propios como talla y material.
 */
public class Ropa extends Producto {
    private String talla;
    private String material;

    public Ropa(String id, String nombre, double precioBase, int stock, String talla, String material) {
        super(id, nombre, precioBase, stock);
        this.talla = talla;
        this.material = material;
    }

    public String getTalla() {
        return talla;
    }

    public String getMaterial() {
        return material;
    }

    // Polimorfismo: 20% de descuento en ropa
    @Override
    public double calcularDescuento() {
        return getPrecioBase() * 0.20;
    }

    @Override
    public String obtenerTipo() {
        return "Ropa";
    }

    @Override
    public String generarEtiqueta() {
        return super.generarEtiqueta() + String.format(" | Talla: %s | Material: %s",
                talla, material);
    }
}