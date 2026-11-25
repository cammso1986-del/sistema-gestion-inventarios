package com.inventario.modelo;

/**
 * Clase derivada de Producto que representa artículos electrónicos.
 * Hereda de Producto y sobrescribe métodos para aplicar su propio descuento y detalle.
 */
public class Electronico extends Producto {
    private int garantiaMeses;

    public Electronico(String id, String nombre, double precioBase, int stock, int garantiaMeses) {
        super(id, nombre, precioBase, stock);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    // Polimorfismo: 10% de descuento en electrónicos
    @Override
    public double calcularDescuento() {
        return getPrecioBase() * 0.10;
    }

    @Override
    public String obtenerTipo() {
        return "Electrónico";
    }

    @Override
    public String generarEtiqueta() {
        return super.generarEtiqueta() + String.format(" | Garantía: %d meses", garantiaMeses);
    }
}
