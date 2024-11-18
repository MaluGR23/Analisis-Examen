import java.util.ArrayList;
import java.util.List;
import java.io.*;

class Articulo {
    private String nombre;
    private int cantidad;
    private boolean estadoCompra;   
    private boolean comprado;  

    public Articulo(String nombre, int cantidad, boolean estadoCompra, boolean comprado) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.estadoCompra = estadoCompra;
        this.comprado = comprado;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean isEstadoCompra(){
        return estadoCompra;
    }

    public boolean isComprado() {
		return comprado;
	}

    @Override
    public String toString() {
        return nombre + " (Cantidad: " + cantidad + ")";
    }
}

class listaCompras {
    private List<Articulo> listaCompras = new ArrayList<>();

    public void contarArticulos(){
        System.out.println("Cantidad total de artículos en la lista: " + listaCompras.size());
    }

    public void agregarArticulo(String nombre, int cantidad) {
        Articulo nuevoArticulo = new Articulo(nombre, cantidad);
        listaCompras.add(nuevoArticulo);
        System.out.println("Articulo agregado: " + nuevoArticulo);
    }

    public Articulo buscarArticulo(String nombre){
        for(Articulo articulo : listaCompras){
            if (articulo.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Articulo encontrado "+ articulo);
                return articulo;
            }
        }
        System.out.println("Articulo no encontrado");
        return null;
    }

     public void ListarArticulos() {

        if (contador == 0) {
            System.out.println("La lista está vacía.");
        } else {
            for (int i = 0; i < contador; i++) {

                System.out.println((i + 1) + "; " + articulos[i]);
            }
        }
    }

    public void filtrarArticulosPendientes(){
        System.out.println("Articulos Pendientes: ")
        for(Articulo articulo: listaCompras){
            if (articulo.isEstadoCompra==false){
            System.out.println(articulo.nombre + " ")
            }
        }
	}

    public void eliminarArticulo(String nombre) {
        Articulo articuloAEliminar = buscarArticulo(nombre);
        if (articuloAEliminar != null) {
            listaCompras.remove(articuloAEliminar);
            System.out.println("Artículo eliminado: " + articuloAEliminar);
        } else {
            System.out.println("No se pudo eliminar el artículo, no se encontró.");
        }
    }

    public void mostrarLista() {

        System.out.println("Lista de Compras:");
        for (Articulo articulo : listaCompras) {
            System.out.println("- " + articulo);
        }
    }
    public void ordenarArticulosAlfabeticamente() {
        int n = listaCompras.size();
        for (int ii = 0; ii < n - 1; ii++) {
            for (int jj = 0; jj < n - ii - 1; jj++) {
                if (listaCompras.get(jj).getNombre().compareToIgnoreCase(listaCompras.get(jj + 1).getNombre()) > 0) {
                    Articulo temp = listaCompras.get(jj);
                    listaCompras.set(jj, listaCompras.get(jj + 1));
                    listaCompras.set(jj + 1, temp);
                }
            }
        }
        System.out.println("Artículos ordenados alfabéticamente:");
        mostrarLista(); 
    }

    public static Articulo[] filtrarArticulosComprados(Articulo[] articulos) {

        //Richard
        int contador = 0;
        for (Articulo articulo : articulos) {
            if (articulo.isComprado()) {
                contador++;
            }
        }

        Articulo[] articulosComprados = new Articulo[contador];
        int index = 0;

        for (Articulo articulo : articulos) {
            if (articulo.isComprado()) {
                articulosComprados[index++] = articulo;
            }
        }

        return articulosComprados;
    }

    // Santiago Anaya

    public Articulo[] marcarArticuloComoComprado(Articulo[] articulos){

        Articulo[] comprados = new Articulo[20];

        for (Articulo articulo : articulos) {

            if (articulo.isComprado() && articulo != null) {
                
                comprados = articulos;
                return comprados;
                
                
            }
            
        } 

        return comprados;
    }
    //santiago pinto//
    public void mostrarArticulosConCantidad() {
    if (articulos.isEmpty()) {
        System.out.println("La lista de compras está vacía.");
    } else {
        System.out.println("Lista de Artículos con Cantidad:");
        for (Articulo articulo : articulos) {
            System.out.println(articulo.getNombre() + " - Cantidad: " + articulo.getCantidad());
        }
    }

    public static void guardarListaEnArchivo(String[] lista, String nombreArchivo) {
        try {
            FileWriter writer = new FileWriter(nombreArchivo);
            for (String item : lista) {
                writer.write(item + "\n");
            }
            writer.close();
            System.out.println("Lista guardada exitosamente en '" + nombreArchivo + "'.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar la lista.");
            e.printStackTrace();
        }
    }
}

    // Cesar Prada
    public void limpiarLista() {
        listaArticulos.clear();
        System.out.println("La lista ha sido vaciada.");
    }
    // ivan peñaranda
      public void agregarDesdeArchivo(List<String> lista, String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea); 
            }
            System.out.println("Elementos agregados desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }

}

public class Main {
    public static void main(String[] args) {
        listaCompras lista = new listaCompras();
        lista.agregarArticulo("Manzanas", 4);
        lista.agregarArticulo("Pan", 1);
        lista.mostrarLista();
        lista.contarArticulos();
    }
}
