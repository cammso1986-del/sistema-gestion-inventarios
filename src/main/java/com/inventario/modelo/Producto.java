package com.inventario.modelo;

/**
 * Clase abstracta base que concentra los atributos y comportamientos comunes
 * a todos los productos. Define métodos abstractos para que cada clase derivada
 * aplique su propia lógica de forma polimórfica.
 */
public abstract class Producto implements Vendible {
    private String id;
    private String nombre;
    private double precioBase;
    private int stock;

    // Constructor común reutilizado por las subclases con super(...)
    public Producto(String id, String nombre, double precioBase, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = Math.max(0, stock);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    // Método concreto compartido por todas las subclases
    public boolean reducirStock(int cantidad) {
        if (cantidad > 0 && cantidad <= this.stock) {
            this.stock -= cantidad;
            return true;
        }
        return false;
    }

    // Métodos abstractos: obligatorios de implementar en cada subclase
    public abstract double calcularDescuento();
    public abstract String obtenerTipo();

    // Implementación polimórfica: invoca calcularDescuento() de la subclase real
    @Override
    public double calcularPrecioFinal() {
        double precioConDescuento = precioBase - calcularDescuento();
        return Math.max(0.0, precioConDescuento);
    }

    // Etiqueta base que las subclases pueden ampliar usando super.generarEtiqueta()
    @Override
    public String generarEtiqueta() {
        return String.format("[%s] %s (%s) | Base: $%.2f | Final: $%.2f | Stock: %d",
                id, nombre, obtenerTipo(), precioBase, calcularPrecioFinal(), stock);
    }
}
