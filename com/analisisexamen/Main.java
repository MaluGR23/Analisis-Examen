package com.analisisexamen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        listaCompras lista = new listaCompras();
        lista.agregarArticulo("Manzanas", 4);
        lista.agregarArticulo("Pan", 1);
        lista.mostrarLista();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del artículo que desea cambiar:");
        String nombreActual = scanner.nextLine();

        System.out.println("Ingrese el nuevo nombre para el artículo:");
        String nuevoNombre = scanner.nextLine();

        lista.editarNombreArticulo(nombreActual, nuevoNombre);
        lista.mostrarLista();
        
        scanner.close();
    }
}