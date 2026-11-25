package com.inventario.modelo;

/**
 * Clase derivada de Producto que representa alimentos.
 * Incluye fecha de caducidad y control de refrigeración.
 */
public class Alimento extends Producto {
    private String fechaCaducidad;
    private boolean requiereRefrigeracion;

    public Alimento(String id, String nombre, double precioBase, int stock,
                    String fechaCaducidad, boolean requiereRefrigeracion) {
        super(id, nombre, precioBase, stock);
        this.fechaCaducidad = fechaCaducidad;
        this.requiereRefrigeracion = requiereRefrigeracion;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public boolean isRequiereRefrigeracion() {
        return requiereRefrigeracion;
    }

    // Polimorfismo: 15% si requiere refrigeración, 5% en caso contrario
    @Override
    public double calcularDescuento() {
        double porcentaje = requiereRefrigeracion ? 0.15 : 0.05;
        return getPrecioBase() * porcentaje;
    }

    @Override
    public String obtenerTipo() {
        return "Alimento";
    }

    @Override
    public String generarEtiqueta() {
        String refri = requiereRefrigeracion ? "Sí" : "No";
        return super.generarEtiqueta() + String.format(" | Caduca: %s | Refrigeración: %s",
                fechaCaducidad, refri);
    }
}