package com.analisisexamen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Articulo {
    private String nombre;
    private int cantidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public Articulo(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + " (Cantidad: " + cantidad + ")";
    }
}

class listaCompras {
    private List<Articulo> listaCompras = new ArrayList<>();

    public void editarNombreArticulo(String nombreActual, String nuevoNombre) {
        for (Articulo articulo : listaCompras) {
            if (articulo.getNombre().equals(nombreActual)) {
                articulo.setNombre(nuevoNombre);
                System.out.println("Nombre del artículo actualizado: " + articulo);
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    }

    public void agregarArticulo(String nombre, int cantidad) {
        Articulo nuevoArticulo = new Articulo(nombre, cantidad);
        listaCompras.add(nuevoArticulo);
        System.out.println("Artículo agregado: " + nuevoArticulo);
    }

    public void mostrarLista() {
        System.out.println("Lista de compras:");
        for (Articulo articulo : listaCompras) {
            System.out.println(articulo);
        }
    }
}



