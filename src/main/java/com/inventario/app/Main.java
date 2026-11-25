package com.inventario.app;

import com.inventario.modelo.Alimento;
import com.inventario.modelo.Electronico;
import com.inventario.modelo.Producto;
import com.inventario.modelo.Ropa;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que demuestra el uso de polimorfismo sobre distintas
 * subclases de Producto y ejecuta pruebas de venta y cálculo de precios.
 */
public class Main {
    public static void main(String[] args) {
        // Lista polimórfica: referencias de tipo Producto apuntando a objetos de distintas subclases
        List<Producto> inventario = new ArrayList<>();

        inventario.add(new Electronico("E-01", "Audífonos inalámbricos", 1500.0, 10, 12));
        inventario.add(new Alimento("A-01", "Leche entera 1L", 28.0, 25, "2026-12-15", true));
        inventario.add(new Ropa("R-01", "Chamarra ligera", 900.0, 8, "M", "Poliéster"));

        System.out.println("=== INVENTARIO INICIAL ===");
        mostrarInventario(inventario);

        System.out.println("\n=== PRUEBAS DE VENTA ===");
        procesarVenta(inventario.get(0), 2);  // Válida
        procesarVenta(inventario.get(1), 5);  // Válida
        procesarVenta(inventario.get(2), 15); // Inválida por falta de stock

        System.out.println("\n=== INVENTARIO FINAL ===");
        mostrarInventario(inventario);
    }

    // Trata cada elemento como Producto sin importar su subclase concreta
    public static void mostrarInventario(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println(producto.generarEtiqueta());
        }
    }

    public static void procesarVenta(Producto producto, int cantidad) {
        if (producto.reducirStock(cantidad)) {
            double total = producto.calcularPrecioFinal() * cantidad;
            System.out.printf("Venta realizada: %d x %s -> Total: $%.2f (Stock restante: %d)%n",
                    cantidad, producto.getNombre(), total, producto.getStock());
        } else {
            System.out.printf("Stock insuficiente para '%s' (Disponible: %d)%n",
                    producto.getNombre(), producto.getStock());
        }
    }
}
